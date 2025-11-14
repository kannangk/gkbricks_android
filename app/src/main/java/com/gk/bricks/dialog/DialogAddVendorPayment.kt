package com.gk.bricks.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentResolver
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.canhub.cropper.CropImageView
import com.gk.bricks.BuildConfig
import com.gk.bricks.R
import com.gk.bricks.api.ApiResponse
import com.gk.bricks.api.RetrofitClient
import com.gk.bricks.api.VendorPaymentRequest
import com.gk.bricks.databinding.DialogAddVendorPaymentBinding
import com.gk.bricks.interfaces.OnUpload
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.EMP_PROFILE_S3_PATH
import com.gk.bricks.util.Constants.VENDOR_DOC_S3_PATH
import com.gk.bricks.util.fileUpload
import com.parse.ParseUser
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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class DialogAddVendorPayment(
    private var vendorId: String,
    private var vendorType: String,
    private val onUpdated: () -> Unit
) : DialogFragment() {

    private lateinit var binding: DialogAddVendorPaymentBinding
    private val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private var selectedDate: String? = null
    private var documentUrl = ""
    private var imageUri: Uri? = null

    // =============== LAUNCHERS ===============

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

    // =========================================

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())

        // ✅ Must call this BEFORE setting content view
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogAddVendorPaymentBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)

        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(requireContext(), R.color.light_grey))
        )
        dialog.window?.attributes?.windowAnimations = R.style.FadingDialogAnimation

        adjustDialogWidth(requireContext(), dialog.window, 1f)
        setupCalendar()
        clickListeners()

        return dialog
    }


    private fun setupCalendar() {
        val calendar = Calendar.getInstance()
        val today = calendar.time
        binding.calenderDate.date = today.time
        format.timeZone = TimeZone.getTimeZone("UTC")
        selectedDate = format.format(today)

        binding.calenderDate.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            format.timeZone = TimeZone.getTimeZone("UTC")
            val dateS = format.parse(date)
            selectedDate = format.format(dateS)
        }
    }

    private fun clickListeners() {
        binding.etPaidAmount.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                binding.tlPaidAmount.error = null
                binding.tlPaidAmount.isErrorEnabled = false
            }
        }

        binding.btnCancel.setOnClickListener { dismiss() }

        binding.ivCapture.setOnClickListener { selectImageSource() }

        binding.btnSave.setOnClickListener {
            if (binding.etPaidAmount.text?.trim()?.isEmpty() == true) {
                binding.tlPaidAmount.error=resources.getString(R.string.field_is_required)
                Toast.makeText(requireContext(), R.string.check_paid_amount, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (selectedDate == null) {
                Toast.makeText(requireContext(), R.string.select_one_date, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val amount = binding.etPaidAmount.text?.trim().toString().toIntOrNull() ?: 0
            onPayLog(amount)
        }
    }

    private fun onPayLog(paidAmount: Int) {
        if (paidAmount == 0) {
            binding.tlPaidAmount.error=resources.getString(R.string.field_is_required)
            Toast.makeText(requireContext(), R.string.field_is_required, Toast.LENGTH_LONG).show()
            return
        }
        binding.pbLoad.visibility = View.VISIBLE
        binding.btnSave.isClickable = false
        binding.btnSave.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.lightGrey))

        val parseUser = ParseUser.getCurrentUser()
        RetrofitClient.instance.paidVendor(
            getApiKey(2, BuildConfig.DEBUG),
            VendorPaymentRequest(
                parseUser.sessionToken,
                vendorId,
                COMPANY_NAME,
                paidAmount,
                vendorType,
                selectedDate!!,
                documentUrl
            )
        ).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                binding.pbLoad.visibility = View.GONE
                if (response.isSuccessful) {
                    val result = response.body()
                    Toast.makeText(requireContext(), result?.message ?: "Updated", Toast.LENGTH_LONG).show()
                    onUpdated.invoke()
                    dismiss()
                } else {
                    Toast.makeText(requireContext(), "Update Failed", Toast.LENGTH_LONG).show()
                    binding.btnSave.isClickable = true
                    binding.btnSave.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                binding.pbLoad.visibility = View.GONE
                Toast.makeText(requireContext(), "Update Failed: ${t.message}", Toast.LENGTH_LONG).show()
                binding.btnSave.isClickable = true
                binding.btnSave.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))
            }
        })
    }

    private fun selectImageSource() {
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

    private fun openGallery() {
        pickImageLauncher.launch("image/*")
    }

    private fun captureImage() {
        val photoFile = File(requireContext().cacheDir, "captured_image.jpg")
        imageUri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            photoFile
        )
        takePictureLauncher.launch(imageUri)
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

    private fun saveImageFileToS3(uri: Uri) {
        CoroutineScope(IO).launch {
            val file = uriToFile(requireContext(), uri) ?: return@launch
            val fileName = file.name
            val key = "$VENDOR_DOC_S3_PATH$fileName"

            launch(Main) {
                binding.pbView.visibility = View.VISIBLE
                binding.pbLoad.visibility = View.VISIBLE
                binding.btnSave.isClickable = false
                binding.btnSave.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.lightGrey))

            }

            fileUpload(
                requireContext(),
                key,
                file,
                getApiKey(5, BuildConfig.DEBUG),
                getApiKey(6, BuildConfig.DEBUG),
                getApiKey(7, BuildConfig.DEBUG),
                object : OnUpload {
                    override fun onUploadSuccess(url: String) {
                        Log.d("GK_BRICKS", "Upload success: $url")
                        activity?.runOnUiThread {
                            binding.pbView.visibility = View.GONE
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))

                        }
                        documentUrl = url
                        loadProfileImageFromS3(url)
                    }

                    override fun onUploadFailed() {
                        activity?.runOnUiThread {
                            binding.pbView.visibility = View.GONE
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))

                        }
                    }

                    override fun onError(id: Int, ex: Exception) {
                        activity?.runOnUiThread {
                            binding.pbView.visibility = View.GONE
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))

                        }
                    }

                    override fun onProgressUpdate(percentage: Int, uploadedSize: Long) {
                        activity?.runOnUiThread {
                            binding.pbView.visibility = View.GONE
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.green))

                        }
                    }
                }
            )
        }
    }

    private fun loadProfileImageFromS3(url: String) {
        GlobalScope.launch(Main) {
            binding.pbView.visibility = View.GONE
            Glide.with(binding.ivCapture.context)
                .load(url)
                .placeholder(R.drawable.ic_profile)
                .error(R.drawable.ic_profile)
                .into(binding.ivCapture)
        }
    }

    private fun uriToFile(context: Context, uri: Uri): File? {
        val contentResolver = context.contentResolver
        val fileName = getFileName(contentResolver, uri)
        val tempFile = File(context.cacheDir, fileName ?: "temp_file")
        try {
            contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(tempFile).use { output -> input.copyTo(output) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        return tempFile
    }

    private fun getFileName(contentResolver: ContentResolver, uri: Uri): String? {
        var name: String? = null
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (it.moveToFirst()) name = it.getString(nameIndex)
        }
        return name ?: uri.lastPathSegment
    }

    fun adjustDialogWidth(context: Context, window: Window?, default: Float = 0.95f) {
        val width = (context.resources.displayMetrics.widthPixels * default)
        val height = (context.resources.displayMetrics.heightPixels * default)
        window?.setLayout(width.toInt(), height.toInt())
    }

    private external fun getApiKey(id: Int, isDebug: Boolean): String
}
