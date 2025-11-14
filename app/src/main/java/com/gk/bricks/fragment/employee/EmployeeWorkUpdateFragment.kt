package com.gk.bricks.fragment.employee

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.R
import com.gk.bricks.adapter.EmployeeWorkUpdateAdapter
import com.gk.bricks.databinding.FragmentEmpWorkUpdateBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.UPDATE_FROM
import com.gk.bricks.viewmodel.MainNavViewModel
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@AndroidEntryPoint
class EmployeeWorkUpdateFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentEmpWorkUpdateBinding
    private lateinit var employeeWorkUpdateAdapter: EmployeeWorkUpdateAdapter
    private val empList = mutableListOf<Employee>()
    private var lastWorkLogs: List<EmployeeWorkLog> = listOf()
    private var selectedDate: Date? = null

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
        binding = FragmentEmpWorkUpdateBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        val date = arguments?.getString("selected_date") ?: ""
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        format.timeZone = TimeZone.getTimeZone("UTC")
        selectedDate = format.parse(date)
        employeeWorkUpdateAdapter = EmployeeWorkUpdateAdapter(
            this, empList, selectedDate,
            object : EmployeeWorkUpdateAdapter.OnEmployeeActionListener {
                override fun onEmployeeActionChanged(emp: Employee, salary: Int) {
                    onSaveSalary(emp, salary)
                }
            })
        binding.recyclerView.adapter = employeeWorkUpdateAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }

        return binding.root
    }

    private fun updateProductionList() {
        mainNavViewModel.getEmployeeList(mContext) { updatedData ->
            mainNavViewModel.getEmployeeWorkLogUsingDate(selectedDate!!) { workLogs ->
                lastWorkLogs = workLogs
                binding.pbLoad.visibility = View.GONE
                if (updatedData.isNotEmpty()) {
                    binding.tvNoData.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    empList.clear()
                    empList.addAll(updatedData)
                    employeeWorkUpdateAdapter.updateWorkLog(workLogs)
                    employeeWorkUpdateAdapter.notifyDataSetChanged()
                } else {
                    binding.tvNoData.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        }

    }

    private fun onSaveSalary(emp: Employee, salary: Int) {
        try {
            GlobalScope.launch(IO) {
                val query: ParseQuery<EmployeeWorkLog> =
                    ParseQuery.getQuery(EmployeeWorkLog::class.java)
                query.whereEqualTo(EmployeeWorkLog.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(EmployeeWorkLog.KEY_WORK_DATE, selectedDate)
                query.whereEqualTo(EmployeeWorkLog.KEY_IS_PAYABLE, false)
                query.whereEqualTo(EmployeeWorkLog.KEY_EMP_ID, emp.empId)
                query.findInBackground { results, e ->
                    if (e != null) {
                        showToast(resources.getString(R.string.save_failed))
                        Log.d("GKBRICKS_WORK_LOG_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_WORK_LOG_GET", "EMPTY")
                        val work = EmployeeWorkLog()
                        work.empId = emp.empId
                        work.empSalary = salary
                        work.empName = emp.empName
                        work.isPaid = false
                        work.isPayable = false
                        work.totalPaidAmount = 0
                        work.workDate = selectedDate!!
                        work.companyName = COMPANY_NAME
                        work.updateFrom = UPDATE_FROM
                        work.saveInBackground { e ->
                            if (e == null) {
                                Log.d("GK_BRICKS", "Employee Work log added successfully")
                                showToast(resources.getString(R.string.saved_success))
                                emp.isUpdated = true
                                employeeWorkUpdateAdapter.notifyDataSetChanged()
                            } else {
                                Log.e("GK_BRICKS", "Employee to add Work log", e)
                                showToast(resources.getString(R.string.save_failed))
                            }
                        }

                    } else {
                        Log.d("GKBRICKS_WORK_LOG_GET", results.size.toString())
                        results.forEach { workLog ->
                            if (salary != 0) {
                                if(workLog.isPaid){
                                    showToast(resources.getString(R.string.already_you_paid))
                                }else {
                                    workLog.empSalary = salary
                                    workLog.saveInBackground { e ->
                                        if (e == null) {
                                            Log.d(
                                                "GK_BRICKS",
                                                "Employee Work log updated successfully"
                                            )
                                            emp.isUpdated = true
                                            employeeWorkUpdateAdapter.notifyDataSetChanged()
                                            showToast(resources.getString(R.string.updated_success))
                                        } else {
                                            Log.e("GK_BRICKS", "Employee to update Work log", e)
                                            showToast(resources.getString(R.string.updated_failed))
                                        }
                                    }
                                }
                            } else {
                                workLog.deleteInBackground { e ->
                                    if (e == null) {
                                        Log.d("GK_BRICKS", "Employee Work log deleted successfully")
                                        emp.isUpdated = true
                                        employeeWorkUpdateAdapter.notifyDataSetChanged()
                                        showToast(resources.getString(R.string.deleted_success))
                                    } else {
                                        Log.e("GK_BRICKS", "Employee to delete Work log", e)
                                        showToast(resources.getString(R.string.delete_failed))
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}