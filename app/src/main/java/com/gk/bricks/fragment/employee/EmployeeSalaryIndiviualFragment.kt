package com.gk.bricks.fragment.employee

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gk.bricks.BuildConfig
import com.gk.bricks.R
import com.gk.bricks.adapter.EmployeeSalaryAdapter
import com.gk.bricks.api.EmployeePayRequest
import com.gk.bricks.api.ApiResponse
import com.gk.bricks.api.RetrofitClient
import com.gk.bricks.databinding.FragmentEmpIndividualDataBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.getRupeesFormat
import com.gk.bricks.viewmodel.MainNavViewModel
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import java.util.Calendar

@AndroidEntryPoint
class EmployeeSalaryIndiviualFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentEmpIndividualDataBinding
    private lateinit var employeeSalaryAdapter: EmployeeSalaryAdapter
    private var empData: Employee? = null
    private val empList = mutableListOf<EmployeeWorkLog>()
    private var lastWorkLogs: List<EmployeeWorkLog> = listOf()
    private var empId = ""
    private var isSalaryScreen = false
    private var empName = ""
    private var empPhotoUrl = ""
    private var totalWorkingSalary = 0
    private var totalAdvanceSalary = 0

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
        binding = FragmentEmpIndividualDataBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        empId = arguments?.getString("emp_id") ?: ""
        empName = arguments?.getString("emp_Name") ?: ""
        empPhotoUrl = arguments?.getString("emp_Photo_Url") ?: ""
        isSalaryScreen = arguments?.getBoolean("is_salary_screen") ?: false
        binding.tvTitle.text = empName
        if (isSalaryScreen) {
            binding.btnPay.visibility = View.VISIBLE
            binding.ivEmpAction.visibility = View.GONE
        } else {
            binding.btnPay.visibility = View.GONE
            binding.ivEmpAction.visibility = View.VISIBLE
        }
        employeeSalaryAdapter = EmployeeSalaryAdapter(
            mContext, empList
        )
        binding.recyclerView.adapter = employeeSalaryAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }
        binding.ivProfile.setOnClickListener {
            showProfilePopupWithAnimation(it, empPhotoUrl)
        }

        binding.ivEmpAction.setOnClickListener {
            empData?.isBlocked = !(empData?.isBlocked ?: false)
            empData?.saveInBackground { e ->
                if (e == null) {
                    showToast(resources.getString(R.string.updated_success))
                    updateProductionList()
                }else{
                    showToast(resources.getString(R.string.updated_failed))
                }
            }
        }


        binding.btnPay.setOnClickListener {
            onShowDate()
        }

        return binding.root
    }

    private fun onShowDate(){
        showDatePicker { selectedDate ->
            showEditTextDialog(
                mContext,
                mContext.resources.getString(R.string.paid_salary),
                totalWorkingSalary.toString()
            ) { newText ->
                try {
                    val paidSalary = newText.trim().toInt()
                    if (paidSalary > 0) {
                        val parseUser = ParseUser.getCurrentUser()
                        Log.d("GKBRICKS_SESSION_TOKEN", "${parseUser.sessionToken}")
                        RetrofitClient.instance.paidSalary(
                            getApiKey(2, BuildConfig.DEBUG), EmployeePayRequest(
                                parseUser.sessionToken, COMPANY_NAME, empId, paidSalary, selectedDate
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
                                            "GKBRICKS_EMP_SALARY",
                                            "Payment updated: ${result?.message}"
                                        )
                                        showToast(result?.message ?: "Updated")
                                        updateProductionList()
                                    } else {
                                        Log.e(
                                            "GKBRICKS_EMP_SALARY",
                                            "Payment failed: ${response.code()}"
                                        )
                                        showToast("Updated Failed")
                                    }
                                }

                                override fun onFailure(
                                    call: Call<ApiResponse>,
                                    t: Throwable
                                ) {
                                    Log.e("GKBRICKS_EMP_SALARY", "Payment Error: ${t.message}")
                                    showToast("Updated Failed")
                                }
                            })

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
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

    fun showEditTextDialog(
        context: Context,
        title: String = "Enter text",
        initialValue: String = "",
        onSave: (String) -> Unit
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_salary_update, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextInput)
        val btnSave = dialogView.findViewById<Button>(R.id.btnSave)
        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)

        editText.setText(initialValue)

        val dialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setView(dialogView)
            .create()

        btnSave.setOnClickListener {
            onSave(editText.text.toString())
            dialog.dismiss()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showProfilePopupWithAnimation(view: View, url: String) {
        val context = view.context
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_profile_popup, null)
        val imageView = dialogView.findViewById<ImageView>(R.id.popupImageView)
        Glide.with(imageView)
            .load(url)
            .placeholder(R.drawable.ic_profile) // optional
            .error(R.drawable.ic_profile)             // optional
            .into(imageView)

        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()

        // Add animation after showing dialog
        val scaleX = ObjectAnimator.ofFloat(dialogView, "scaleX", 0.8f, 1f)
        val scaleY = ObjectAnimator.ofFloat(dialogView, "scaleY", 0.8f, 1f)
        val fadeIn = ObjectAnimator.ofFloat(dialogView, "alpha", 0f, 1f)

        AnimatorSet().apply {
            playTogether(scaleX, scaleY, fadeIn)
            duration = 300
            interpolator = OvershootInterpolator()
            start()
        }
    }

    private fun updateProductionList() {
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.llsalary.visibility = View.GONE
        empList.clear()
        employeeSalaryAdapter.notifyDataSetChanged()
        mainNavViewModel.getEmployee(empId) { data ->
            if (data.isEmpty())
                return@getEmployee
            empData = data[0]

            if (empData?.isBlocked ?: false) {
                binding.ivEmpAction.setImageResource(R.drawable.ic_emp_block)
                binding.ivProfile.borderColor = ContextCompat.getColor(mContext, R.color.red)
            }else {
                binding.ivEmpAction.setImageResource(R.drawable.ic_emp_unblock)
                binding.ivProfile.borderColor = ContextCompat.getColor(mContext, R.color.green)
            }

            loadProfileImageFromS3(empData?.empPhoto ?: "", binding.ivProfile)
            binding.tvSalaryValue.text = getRupeesFormat(empData?.empSalary ?: 0)
            binding.tvAdvanceValue.text = getRupeesFormat(empData?.empAdvance ?: 0)
            totalAdvanceSalary = empData?.empAdvance ?: 0
            mainNavViewModel.getEmployeeWorkLogUsingEmpId(empId) { workLogs ->
                lastWorkLogs = workLogs
                binding.pbLoad.visibility = View.GONE
                binding.btnPay.isClickable = true
                binding.btnPay.isEnabled = true
                binding.shimmerLayout.visibility = View.GONE
                binding.llsalary.visibility = View.VISIBLE
                if (workLogs.isNotEmpty()) {
                    totalWorkingSalary = workLogs[0].totalAmount
                    binding.tvTotalWorkingSalary.text = getRupeesFormat(workLogs[0].totalAmount)
                    binding.tvNoData.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    empList.clear()
                    empList.addAll(workLogs)
                    employeeSalaryAdapter.notifyDataSetChanged()
                } else {
                    binding.tvTotalWorkingSalary.text = getRupeesFormat(0)
                    binding.tvNoData.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        }

    }

    private fun loadProfileImageFromS3(url: String, ivView: ImageView) {
        GlobalScope.launch(Main) {
            Glide.with(ivView)
                .load(url)
                .placeholder(R.drawable.ic_profile) // optional
                .error(R.drawable.ic_profile)             // optional
                .into(ivView)
        }
    }


    private external fun getApiKey(id: Int, isDebug: Boolean): String

}