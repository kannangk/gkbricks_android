package com.gk.bricks.fragment.delivery

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.gk.bricks.BuildConfig
import com.gk.bricks.R
import com.gk.bricks.api.ApiResponse
import com.gk.bricks.api.RetrofitClient
import com.gk.bricks.api.VendorLoadLogRequest
import com.gk.bricks.databinding.FragmentVendorLogsAddBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.interfaces.OnUpload
import com.gk.bricks.model.parse.VendorPaidLog
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.VENDOR_DOC_S3_PATH
import com.gk.bricks.util.Constants.VENDOR_FIRE_WOOD_TYPE
import com.gk.bricks.util.fileUpload
import com.gk.bricks.util.firewoodItemMap
import com.gk.bricks.util.sandItemMap
import com.gk.bricks.viewmodel.MainNavViewModel
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.util.Calendar

@AndroidEntryPoint
class AddVendorLogsFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentVendorLogsAddBinding
    private var profileUrl1 = ""
    private var profileUrl2 = ""
    private var profileUrl3 = ""
    private var vendorType = VENDOR_FIRE_WOOD_TYPE
    private var vendorId = ""
    private var vendorName = ""
    private var clickedPosition = 0
    private var selectedLoadName: String? = null

    private val mainNavViewModel by lazy {
        ViewModelProvider(this)[MainNavViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = mainNavViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVendorLogsAddBinding.inflate(inflater, container, false)
        vendorId = arguments?.getString("vendor_id") ?: ""
        vendorType = arguments?.getString("vendor_type") ?: VENDOR_FIRE_WOOD_TYPE
        vendorName = arguments?.getString("vendor_name") ?: ""
        var itemValues = sandItemMap(mContext)
        if (vendorType == VENDOR_FIRE_WOOD_TYPE) {
            binding.tvTitle.text = mContext.getString(R.string.add_firewood_log)
            binding.tlLoadName.hint = mContext.getString(R.string.firewood_name_label)
            binding.tlLoadAmount.hint = mContext.getString(R.string.firewood_price_label)
            itemValues = firewoodItemMap(mContext)
        } else {
            binding.tvTitle.text = mContext.getString(R.string.add_sand_log)
            binding.tlLoadName.hint = mContext.getString(R.string.sand_name_label)
            binding.tlLoadAmount.hint = mContext.getString(R.string.sand_price_label)
        }
        binding.btnSave.setOnClickListener {
            onShowDate()
        }

        binding.btnCancel.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.captureImageView1.setOnClickListener {
            clickedPosition = 1
            selectImageSource()
        }

        binding.captureImageView2.setOnClickListener {
            clickedPosition = 2
            selectImageSource()
        }

        binding.captureImageView3.setOnClickListener {
            clickedPosition = 3
            selectImageSource()
        }

        val adapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, itemValues.values.toList())
        binding.etLoadName.setAdapter(adapter)

        binding.etLoadName.setOnItemClickListener { _, _, position, _ ->
            selectedLoadName = itemValues.keys.elementAt(position)
        }

        binding.etLoadName.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                binding.tlLoadName.error = null
                binding.tlLoadName.isErrorEnabled = false
            }
        }

        binding.etLoadCount.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                binding.tlLoadCount.error = null
                binding.tlLoadCount.isErrorEnabled = false
            }
        }

        binding.etLoadAmount.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                binding.tlLoadAmount.error = null
                binding.tlLoadAmount.isErrorEnabled = false
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun selectImageSource() {
        val options = arrayOf("Camera", "Gallery")
        AlertDialog.Builder(requireContext())
            .setTitle("Select Image")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> captureImage()
                    1 -> openGallery()
                }
            }
            .show()
    }

    fun openGallery() {
        pickImageLauncher.launch("image/*")
    }

    private fun launchCrop(uri: Uri) {
        val options = CropImageOptions().apply {
            guidelines = CropImageView.Guidelines.ON
            cropMenuCropButtonTitle = "Done"
            activityTitle = "Crop Image"
            toolbarColor = ContextCompat.getColor(requireContext(), R.color.capture_toolbar)
            toolbarTintColor =
                ContextCompat.getColor(requireContext(), R.color.capture_toolbar_tint)
        }
        cropImage.launch(CropImageContractOptions(uri, options))
    }

    // CAMERA
    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                imageUri?.let { uri ->
                    launchCrop(uri)
                }
            }
        }

    // GALLERY
    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let { launchCrop(it) }
        }

    // CROP
    private val cropImage = registerForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            val croppedUri = result.uriContent
            when (clickedPosition) {
                1 -> saveImageFileToS3(croppedUri!!, binding.captureImageView1, binding.pbProfile1)
                2 -> saveImageFileToS3(croppedUri!!, binding.captureImageView2, binding.pbProfile2)
                else -> saveImageFileToS3(
                    croppedUri!!,
                    binding.captureImageView3,
                    binding.pbProfile3
                )
            }
        } else {
            val error = result.error
            Toast.makeText(requireContext(), "Crop failed: $error", Toast.LENGTH_SHORT).show()
        }
    }


    private var imageUri: Uri? = null

    fun captureImage() {
        val photoFile = File(requireContext().cacheDir, "captured_image.jpg")
        imageUri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            photoFile
        )
        takePictureLauncher.launch(imageUri)
    }

    fun uriToFile(context: Context, uri: Uri): File? {
        val contentResolver = context.contentResolver
        val fileName = getFileName(contentResolver, uri)
        val tempFile = File(context.cacheDir, fileName ?: "temp_file")

        try {
            contentResolver.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(tempFile).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        return tempFile
    }

    private fun getFileName(contentResolver: ContentResolver, uri: Uri): String? {
        var name: String? = null
        val returnCursor = contentResolver.query(uri, null, null, null, null)
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            name = returnCursor.getString(nameIndex)
            returnCursor.close()
        }
        if (name == null) {
            name = uri.lastPathSegment
        }
        return name
    }

    private fun saveImageFileToS3(uri: Uri, captureImageView: AppCompatImageView, pbProfile: View) {
        CoroutineScope(IO).launch {
            val file = uriToFile(mContext, uri)
            if (file == null)
                return@launch
            val fileName = file.name
            Log.d("GK_BRICKS", "profile file name: $fileName")
            val key = "$VENDOR_DOC_S3_PATH${fileName}"
            activity?.runOnUiThread {
                pbProfile.visibility = View.VISIBLE
                binding.pbShimmerLoad.visibility = View.VISIBLE
            }
            fileUpload(
                mContext,
                key,
                file,
                getApiKey(5, BuildConfig.DEBUG),
                getApiKey(6, BuildConfig.DEBUG),
                getApiKey(7, BuildConfig.DEBUG),
                object : OnUpload {
                    override fun onUploadSuccess(url: String) {
                        Log.d("GK_BRICKS", "profile upload success url: $url")
                        activity?.runOnUiThread {
                            pbProfile.visibility = View.GONE
                        }
                        when (clickedPosition) {
                            1 -> {
                                profileUrl1 = url
                                activity?.runOnUiThread {
                                    binding.rlCapture2.visibility = View.VISIBLE
                                }
                            }

                            2 -> {
                                profileUrl2 = url
                                activity?.runOnUiThread {
                                    binding.rlCapture3.visibility = View.VISIBLE
                                }
                            }

                            else -> {
                                profileUrl3 = url
                                activity?.runOnUiThread {
                                    binding.rlCaptureAdd.visibility = View.GONE
                                }
                            }
                        }
                        activity?.runOnUiThread {
                            binding.pbShimmerLoad.visibility = View.GONE
                        }

                        loadProfileImageFromS3(url, captureImageView)
                    }

                    override fun onUploadFailed() {
                        Log.d("GK_BRICKS", "Error: profile Upload Failed")
                        activity?.runOnUiThread {
                            pbProfile.visibility = View.GONE
                        }
                    }

                    override fun onError(id: Int, ex: Exception) {
                        Log.d(
                            "GK_BRICKS",
                            "Error: profile upload Failed with error ${ex.message}"
                        )
                        activity?.runOnUiThread {
                            pbProfile.visibility = View.GONE
                        }
                    }

                    override fun onProgressUpdate(percentage: Int, uploadedSize: Long) {
                        Log.d(
                            "GK_BRICKS",
                            "profile Upload Progress $percentage% $uploadedSize KB"
                        )
                        activity?.runOnUiThread {
                            pbProfile.visibility = View.GONE
                        }
                    }

                }
            )
        }
    }

    private fun loadProfileImageFromS3(url: String, captureImageView: AppCompatImageView) {
        GlobalScope.launch(Main) {
            Glide.with(captureImageView.context)
                .load(url)
                .placeholder(R.drawable.ic_profile) // optional
                .error(R.drawable.ic_profile)             // optional
                .into(captureImageView)
        }
    }

    private fun onShowDate() {
        showDatePicker { selectedDate ->
            onSaveVendorLoad(selectedDate)
        }
    }


    fun showDatePicker(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            /* context = */ mContext,
            { _, year, month, dayOfMonth ->
                val date = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
//                val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//                format.timeZone = TimeZone.getTimeZone("UTC")
//                val selectedDate = format.parse(date)
//                if (selectedDate != null) {
                onDateSelected(date)
//                } // call the listener
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }


    private fun onSaveVendorLoad(selectedDate: String) {
        try {
            val balance = binding.etLoadAmount.text.toString().trim()
            val count = binding.etLoadCount.text.toString().trim()
            if (selectedLoadName == null) {
                binding.tlLoadName.error = resources.getString(R.string.field_is_required)
                return
            } else if (balance.isEmpty()) {
                binding.tlLoadAmount.error = resources.getString(R.string.field_is_required)
                return
            } else if (count.isEmpty()) {
                binding.tlLoadCount.error = resources.getString(R.string.field_is_required)
                return
            }
            activity?.runOnUiThread {
                binding.pbLoad.visibility = View.VISIBLE
                binding.btnView.visibility = View.GONE
            }

            val parseUser = ParseUser.getCurrentUser()
            RetrofitClient.instance.vendorLoadLog(
                getApiKey(2, BuildConfig.DEBUG), VendorLoadLogRequest(
                    parseUser.sessionToken,
                    vendorId,
                    COMPANY_NAME,
                    vendorType,
                    selectedDate,
                    count.toInt(),
                    balance.toInt(),
                    selectedLoadName!!,
                    profileUrl1,
                    profileUrl2,
                    profileUrl3
                )
            )
                .enqueue(object : Callback<ApiResponse> {
                    override fun onResponse(
                        call: Call<ApiResponse>,
                        response: Response<ApiResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("GK_BRICKS", "vendorPaidLog data updated successfully")
                            activity?.runOnUiThread {
                                binding.pbLoad.visibility = View.VISIBLE
                                binding.btnView.visibility = View.GONE
                            }
                            showToast(resources.getString(R.string.saved_success))
                            viewModel.navigateBack()
                        } else {
                            Log.e(
                                "GK_BRICKS",
                                "vendorPaidLog to update video data ${response.code().toString()}"
                            )
                            showToast(resources.getString(R.string.save_failed))
                            activity?.runOnUiThread {
                                binding.pbLoad.visibility = View.GONE
                                binding.btnView.visibility = View.VISIBLE
                            }
                        }
                    }

                    override fun onFailure(
                        call: Call<ApiResponse>,
                        t: Throwable
                    ) {
                        showToast(resources.getString(R.string.save_failed))
                        activity?.runOnUiThread {
                            binding.pbLoad.visibility = View.GONE
                            binding.btnView.visibility = View.VISIBLE
                        }
                    }
                })

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun onSaveVendor(vendorPaidLog: VendorPaidLog) {
        GlobalScope.launch(IO) {
            activity?.runOnUiThread {
                binding.pbLoad.visibility = View.VISIBLE
                binding.btnView.visibility = View.GONE
            }
            vendorPaidLog.saveInBackground { e ->
                if (e == null) {
                    Log.d("GK_BRICKS", "vendorPaidLog data updated successfully")
                    activity?.runOnUiThread {
                        binding.pbLoad.visibility = View.VISIBLE
                        binding.btnView.visibility = View.GONE
                    }
                    showToast(resources.getString(R.string.saved_success))
                    viewModel.navigateBack()
                } else {
                    Log.e("GK_BRICKS", "vendorPaidLog to update video data", e)
                    showToast(resources.getString(R.string.save_failed))
                    activity?.runOnUiThread {
                        binding.pbLoad.visibility = View.GONE
                        binding.btnView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private external fun getApiKey(id: Int, isDebug: Boolean): String

}