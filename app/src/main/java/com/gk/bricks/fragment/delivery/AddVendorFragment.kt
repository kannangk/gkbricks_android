package com.gk.bricks.fragment.delivery

import android.app.AlertDialog
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.gk.bricks.BuildConfig
import com.gk.bricks.R
import com.gk.bricks.databinding.FragmentEmployeeAddBinding
import com.gk.bricks.databinding.FragmentVendorAddBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.interfaces.OnUpload
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.EMP_PROFILE_S3_PATH
import com.gk.bricks.util.Constants.UPDATE_FROM
import com.gk.bricks.util.Constants.VENDOR_PROFILE_S3_PATH
import com.gk.bricks.util.fileUpload
import com.gk.bricks.util.generateRandomText
import com.gk.bricks.viewmodel.MainNavViewModel
import com.google.android.libraries.ads.mobile.sdk.nativead.e
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.util.Date

@AndroidEntryPoint
class AddVendorFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentVendorAddBinding
    private var profileUrl: String? = null
    private var vendorType = "FIRE_WOOD"

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
        binding = FragmentVendorAddBinding.inflate(inflater, container, false)
        vendorType = arguments?.getString("vendor_type") ?: "FIRE_WOOD"
        if(vendorType=="FIRE_WOOD")
            binding.tvTitle.text = mContext.getString(R.string.add_firewood_owner)
        else
            binding.tvTitle.text = mContext.getString(R.string.add_sand_owner)
        binding.btnSave.setOnClickListener {
            onSaveEmpProfile()
        }

        binding.btnCancel.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.captureImageView.setOnClickListener {
//            captureImage()
            selectImageSource()
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
            toolbarTintColor = ContextCompat.getColor(requireContext(), R.color.capture_toolbar_tint)
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
            saveImageFileToS3(croppedUri!!)
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

    private fun saveImageFileToS3(uri: Uri) {
        CoroutineScope(IO).launch {
            val file = uriToFile(mContext, uri)
            if (file == null)
                return@launch
            val fileName = file.name
            Log.d("GK_BRICKS", "profile file name: $fileName")
            val key = "$VENDOR_PROFILE_S3_PATH${fileName}"
            activity?.runOnUiThread {
                binding.pbProfile.visibility = View.VISIBLE
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
                            binding.pbProfile.visibility = View.GONE
                        }
                        profileUrl = url
                        loadProfileImageFromS3(url)
                    }

                    override fun onUploadFailed() {
                        Log.d("GK_BRICKS", "Error: profile Upload Failed")
                        activity?.runOnUiThread {
                            binding.pbProfile.visibility = View.GONE
                        }
                    }

                    override fun onError(id: Int, ex: Exception) {
                        Log.d(
                            "GK_BRICKS",
                            "Error: profile upload Failed with error ${ex.message}"
                        )
                        activity?.runOnUiThread {
                            binding.pbProfile.visibility = View.GONE
                        }
                    }

                    override fun onProgressUpdate(percentage: Int, uploadedSize: Long) {
                        Log.d(
                            "GK_BRICKS",
                            "profile Upload Progress $percentage% $uploadedSize KB"
                        )
                        activity?.runOnUiThread {
                            binding.pbProfile.visibility = View.GONE
                        }
                    }

                }
            )
        }
    }

    private fun loadProfileImageFromS3(url: String) {
        GlobalScope.launch(Main) {
            Glide.with(binding.captureImageView.context)
                .load(url)
                .placeholder(R.drawable.ic_profile) // optional
                .error(R.drawable.ic_profile)             // optional
                .into(binding.captureImageView)
        }
    }

    private fun onSaveEmpProfile(){
        try {
            val name = binding.etOwnerName.text.toString().trim()
            val balance = binding.etRemainingBalance.text.toString().trim()
            if(profileUrl==null){
                showToast(resources.getString(R.string.please_add_photo))
                return
            }else if(name.isEmpty()){
                binding.tlOwnerName.error=resources.getString(R.string.field_is_required)
                return
            }else if(balance.isEmpty()){
                binding.tlRemainingBalance.error=resources.getString(R.string.field_is_required)
                return
            }
            val vendor = Vendor()
            vendor.vendorId = generateRandomText()
            vendor.vendorType = vendorType
            vendor.vendorName = name
            vendor.vendorBalance = balance.toInt()
            vendor.isBlocked = false
            vendor.vendorPhoto = profileUrl?:""
            vendor.companyName = COMPANY_NAME
            vendor.updateFrom = UPDATE_FROM
            onSaveVendor(vendor)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun onSaveVendor(vendor: Vendor){
        GlobalScope.launch(IO){
            activity?.runOnUiThread {
                binding.pbLoad.visibility = View.VISIBLE
                binding.btnView.visibility = View.GONE
            }
            vendor.saveInBackground { e ->
                if (e == null) {
                    Log.d("GK_BRICKS", "Vendor data updated successfully")
                    activity?.runOnUiThread {
                        binding.pbLoad.visibility = View.VISIBLE
                        binding.btnView.visibility = View.GONE
                    }
                    showToast(resources.getString(R.string.saved_success))
                    viewModel.navigateBack()
                } else {
                    Log.e("GK_BRICKS", "Vendor to update video data", e)
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