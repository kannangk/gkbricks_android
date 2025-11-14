package com.gk.bricks.dialog

import ads_mobile_sdk.br
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.gk.bricks.BuildConfig
import com.gk.bricks.R
import com.gk.bricks.api.ApiResponse
import com.gk.bricks.api.ChamberLoadingLogRequest
import com.gk.bricks.api.EmployeePayRequest
import com.gk.bricks.api.RetrofitClient
import com.gk.bricks.databinding.DialogAddChamberLoadingBinding
import com.gk.bricks.databinding.DialogAddProductionBricksBinding
import com.gk.bricks.model.parse.BricksChamberLoadingLogs
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.UPDATE_FROM
import com.parse.ParseQuery
import com.parse.ParseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone


class DialogAddChamberLoadBricks(
    private val activity: FragmentActivity,
    private var chamberId: String,
    private val onUpdated:()->Unit
) : Dialog(activity) {

    private var selectedDate: String? = null
    private lateinit var binding: DialogAddChamberLoadingBinding
    private val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddChamberLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)
        window?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(context, R.color.light_grey))
        )

        binding.calenderDate.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            format.timeZone = TimeZone.getTimeZone("UTC")
            val dateS = format.parse(date)
            selectedDate = format.format(dateS)
        }

        window?.let {
            it.attributes.windowAnimations = R.style.FadingDialogAnimation
        }
        adjustDialogWidth(activity, window, 1f)

        clickListeners()
        showKeyboard()
        val calendar = Calendar.getInstance()
        val today = calendar.time
        binding.calenderDate.date = today.time
        format.timeZone = TimeZone.getTimeZone("UTC")
        selectedDate = format.format(today)
    }

    fun adjustDialogWidth(context: Context, window: Window?, default: Float = 0.95f) {
        val width = (context.resources.displayMetrics.widthPixels * default)
        val height = (context.resources.displayMetrics.heightPixels * default)
        window?.setLayout(width.toInt(), height.toInt())
    }

    private fun clickListeners() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSave.setOnClickListener {
            if (binding.etBricksCount.text?.trim()?.isEmpty() == true) {
                Toast.makeText(
                    activity,
                    activity.resources.getString(R.string.check_bricks_count),
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }else if (binding.etPaidAmount.text?.trim()?.isEmpty() == true) {
                Toast.makeText(
                    activity,
                    activity.resources.getString(R.string.check_paid_amount),
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            } else if (selectedDate == null) {
                Toast.makeText(
                    activity,
                    activity.resources.getString(R.string.select_one_date),
                    Toast.LENGTH_LONG
                )
                    .show()
                return@setOnClickListener
            }

            onPayLog(binding.etBricksCount.text?.trim().toString().toInt(),binding.etPaidAmount.text?.trim().toString().toInt())
        }
    }

    private fun onPayLog(bricksCount: Int,paidAmount: Int){
        try {
            if(bricksCount==0 && paidAmount==0) {
                Toast.makeText(
                    activity,
                    activity.resources.getString(R.string.field_is_required),
                    Toast.LENGTH_LONG
                )
                return
            }
            binding.pbLoad.visibility = View.VISIBLE
            binding.btnSave.isClickable = false
            binding.btnSave.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.lightGrey))
            val parseUser = ParseUser.getCurrentUser()
            RetrofitClient.instance.paidChamberLoading(
                getApiKey(2, BuildConfig.DEBUG), ChamberLoadingLogRequest(
                    parseUser.sessionToken ,chamberId, COMPANY_NAME, bricksCount, paidAmount, selectedDate!!
                )
            )
                .enqueue(object : retrofit2.Callback<ApiResponse> {
                    override fun onResponse(
                        call: Call<ApiResponse>,
                        response: retrofit2.Response<ApiResponse>
                    ) {
                        if (response.isSuccessful) {
                            val result = response.body()
                            Log.d(
                                "GKBRICKS_Chamber_load_log",
                                "Payment updated: ${result?.message}"
                            )
                            binding.pbLoad.visibility = View.GONE
                            Toast.makeText(
                                activity,
                                result?.message ?: "Updated",
                                Toast.LENGTH_LONG
                            )
                            onUpdated.invoke()
                            dismiss()
                        } else {
                            Log.e(
                                "GKBRICKS_Chamber_load_log",
                                "Payment failed: ${response.code()}"
                            )
                            Toast.makeText(
                                activity,
                                "Updated Failed",
                                Toast.LENGTH_LONG
                            )
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.green))
                        }
                    }

                    override fun onFailure(
                        call: Call<ApiResponse>,
                        t: Throwable
                    ) {
                        Log.e("GKBRICKS_Chamber_load_log", "Payment Error: ${t.message}")
                        Toast.makeText(
                            activity,
                            "Updated Failed",
                            Toast.LENGTH_LONG
                        )
                        binding.btnSave.isClickable = true
                        binding.btnSave.backgroundTintList =
                            ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.green))
                    }
                })
        }catch (e: Exception){
            e.printStackTrace()
        }
    }



    private fun showKeyboard() {
        if (binding.etBricksCount.requestFocus()) {
            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            val inputMethodManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
            inputMethodManager.showSoftInput(
                binding.etBricksCount,
                InputMethodManager.SHOW_IMPLICIT
            );
        }
    }

    override fun dismiss() {
        hideKeyBoard()
        binding.etBricksCount.clearFocus()
        activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        super.dismiss()
        //hide keyboard

    }


    private fun hideKeyBoard() {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
        /*val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        Log.d(TAG, "hideKeybaord: hiding keyboard")
        imm.hideSoftInputFromWindow(activity.window.decorView.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)*/
    }

    private external fun getApiKey(id: Int, isDebug: Boolean): String


}