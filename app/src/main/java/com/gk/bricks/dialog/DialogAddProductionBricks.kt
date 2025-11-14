package com.gk.bricks.dialog

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
import com.gk.bricks.R
import com.gk.bricks.databinding.DialogAddProductionBricksBinding
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.UPDATE_FROM
import com.parse.ParseQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone


class DialogAddProductionBricks(
    private val activity: FragmentActivity,
    private var currentCount: Int
) : Dialog(activity) {

    private var selectedDate: Date? = null
    private lateinit var binding: DialogAddProductionBricksBinding
    private val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private var selectedDateProduction: BricksProduction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddProductionBricksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)
        window?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(context, R.color.light_grey))
        )
        binding.etProductionCount.setText(currentCount.toString())

        binding.calenderDate.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            format.timeZone = TimeZone.getTimeZone("UTC")
            selectedDate = format.parse(date)
            fetchProductionCount(selectedDate!!)
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
        val currentDateString = format.format(today)
        selectedDate = format.parse(currentDateString)
        fetchProductionCount(selectedDate!!)
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
            if (binding.etProductionCount.text?.trim()?.isEmpty() == true) {
                Toast.makeText(
                    activity,
                    activity.resources.getString(R.string.check_bricks_count),
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

            GlobalScope.launch(IO) {
                activity.runOnUiThread {
                    binding.pbLoad.visibility = View.VISIBLE
                    binding.btnSave.isClickable = false
                    binding.btnSave.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.lightGrey))
                }
                if (selectedDateProduction == null) {
                    val bricksProduction = BricksProduction()
                    bricksProduction.totalProduction =
                        (binding.etProductionCount.text?.toString()?.trim() ?: "0").toInt()
                    bricksProduction.companyName = COMPANY_NAME
                    bricksProduction.workingDate = selectedDate!!
                    bricksProduction.updateFrom = UPDATE_FROM
                    bricksProduction.saveInBackground { e ->
                        if (e == null) {
                            CoroutineScope(Dispatchers.Main).launch {
                                binding.pbLoad.visibility = View.GONE
                                binding.btnSave.isClickable = true
                                binding.btnSave.backgroundTintList =
                                    ColorStateList.valueOf(
                                        ContextCompat.getColor(
                                            activity,
                                            R.color.green
                                        )
                                    )
                                Toast.makeText(
                                    activity,
                                    activity.resources.getString(R.string.updated_success),
                                    Toast.LENGTH_LONG
                                ).show()
                                dismiss()
                                delay(1000)
                            }
                        } else {
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(
                                    activity,
                                    activity.resources.getString(R.string.try_again),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                } else {
                    selectedDateProduction?.totalProduction = (binding.etProductionCount.text?.toString()?.trim() ?: "0").toInt()
                    selectedDateProduction?.updateFrom = UPDATE_FROM
                    selectedDateProduction?.saveInBackground{ e ->
                        if (e == null) {
                            CoroutineScope(Dispatchers.Main).launch {
                                binding.pbLoad.visibility = View.GONE
                                binding.btnSave.isClickable = true
                                binding.btnSave.backgroundTintList =
                                    ColorStateList.valueOf(
                                        ContextCompat.getColor(
                                            activity,
                                            R.color.green
                                        )
                                    )
                                Toast.makeText(
                                    activity,
                                    activity.resources.getString(R.string.updated_success),
                                    Toast.LENGTH_LONG
                                ).show()
                                dismiss()
                                delay(1000)
                            }
                        } else {
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(
                                    activity,
                                    activity.resources.getString(R.string.try_again),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                }

            }


//            CoroutineScope(Dispatchers.Main).launch {
//                dismiss()
//                delay(1000)
//                onSet.invoke(
//                    selectedDate,
//                    (binding.etProductionCount.text?.toString()?.trim() ?: "0").toInt()
//                )
//            }
        }
    }

    private fun fetchProductionCount(date: Date) {
        try {
            activity.runOnUiThread {
                selectedDateProduction = null
                binding.etProductionCount.setText("")
                binding.pbLoad.visibility = View.VISIBLE
                binding.btnSave.isClickable = false
                binding.btnSave.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.lightGrey))
            }
            GlobalScope.launch(IO) {
                val query: ParseQuery<BricksProduction> =
                    ParseQuery.getQuery(BricksProduction::class.java)
                query.whereEqualTo(BricksProduction.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksProduction.KEY_WORKING_DATE, date)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksProduction_GET", e.message.toString() + e.code)
                        Toast.makeText(
                            activity,
                            activity.resources.getString(R.string.try_again),
                            Toast.LENGTH_LONG
                        ).show()
                        dismiss()
                    } else if (results.isEmpty()) {
                        activity.runOnUiThread {
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(
                                    ContextCompat.getColor(
                                        activity,
                                        R.color.green
                                    )
                                )
                            binding.etProductionCount.setText("")
                        }
                    } else {
                        activity.runOnUiThread {
                            binding.pbLoad.visibility = View.GONE
                            binding.btnSave.isClickable = true
                            binding.btnSave.backgroundTintList =
                                ColorStateList.valueOf(
                                    ContextCompat.getColor(
                                        activity,
                                        R.color.green
                                    )
                                )
                            selectedDateProduction = results[0]
                            binding.etProductionCount.setText("${selectedDateProduction?.totalProduction ?: ""}")
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showKeyboard() {
        if (binding.etProductionCount.requestFocus()) {
            activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            val inputMethodManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
            inputMethodManager.showSoftInput(
                binding.etProductionCount,
                InputMethodManager.SHOW_IMPLICIT
            );
        }
    }

    override fun dismiss() {
        hideKeyBoard()
        binding.etProductionCount.clearFocus()
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


}