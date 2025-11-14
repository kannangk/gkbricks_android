package com.gk.bricks.fragment.delivery

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.R
import com.gk.bricks.adapter.ChamberBricksLogAdapter
import com.gk.bricks.databinding.FragmentChamberIndividualDataBinding
import com.gk.bricks.dialog.DialogAddChamberLoadBricks
import com.gk.bricks.dialog.DialogAddProductionBricks
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.model.parse.BricksChamberLoadingLogs
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class ChamberIndiviualFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentChamberIndividualDataBinding
    private lateinit var chamberBricksLogAdapter: ChamberBricksLogAdapter
    private var bricksChamberLoading: BricksChamberLoading? = null
    private val workLogList = mutableListOf<BricksChamberLoadingLogs>()
    private var chamberId = ""
    private var totalPaidSalary = 0

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
        binding = FragmentChamberIndividualDataBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        chamberId = arguments?.getString("chamber_id") ?: ""

        binding.tvTitle.text = chamberId

        chamberBricksLogAdapter = ChamberBricksLogAdapter(
            mContext, workLogList
        )
        binding.recyclerView.adapter = chamberBricksLogAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }


        binding.ivChamberStatus.setOnClickListener {
            bricksChamberLoading?.isCompleted = !(bricksChamberLoading?.isCompleted ?: false)
            bricksChamberLoading?.saveInBackground { e ->
                if (e == null) {
                    showToast(resources.getString(R.string.updated_success))
                    updateProductionList()
                }else{
                    showToast(resources.getString(R.string.updated_failed))
                }
            }
        }


        binding.ivPay.setOnClickListener {
            try {
                val dialog =
                    DialogAddChamberLoadBricks(requireActivity(), chamberId,{
                        updateProductionList()
                })
                dialog.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return binding.root
    }


    private fun updateProductionList() {
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.llsalary.visibility = View.GONE
        workLogList.clear()
        chamberBricksLogAdapter.notifyDataSetChanged()
        mainNavViewModel.getBricksChamberLoadingDataFromId(chamberId) { data ->
            if (data.isEmpty())
                return@getBricksChamberLoadingDataFromId
            bricksChamberLoading = data[0]

            if (bricksChamberLoading?.isCompleted ?: false) {
                binding.ivChamberStatus.setImageResource(R.drawable.ic_done)
//                binding.ivProfile.borderColor = ContextCompat.getColor(mContext, R.color.red)
            }else {
                binding.ivChamberStatus.setImageResource(R.drawable.ic_pending)
//                binding.ivProfile.borderColor = ContextCompat.getColor(mContext, R.color.green)
            }

            binding.tvTotalPaid.text = getRupeesFormat(bricksChamberLoading?.totalPaidAmount ?: 0)
            binding.tvBricksCount.text = getCommaFormat(bricksChamberLoading?.totalBricks ?: 0)
            totalPaidSalary = bricksChamberLoading?.totalPaidAmount ?: 0
            mainNavViewModel.getChamberBricksLog(chamberId) { workLogs ->
                binding.pbLoad.visibility = View.GONE
                binding.ivPay.isClickable = true
                binding.ivPay.isEnabled = true
                binding.shimmerLayout.visibility = View.GONE
                binding.llsalary.visibility = View.VISIBLE
                if (workLogs.isNotEmpty()) {
                    binding.tvNoData.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    workLogList.clear()
                    workLogList.addAll(workLogs)
                    chamberBricksLogAdapter.notifyDataSetChanged()
                } else {
                    binding.tvNoData.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        }

    }



//    private fun onSaveSalary(emp: Employee, salary: Int) {
//        try {
//            GlobalScope.launch(IO) {
//                val query: ParseQuery<EmployeeWorkLog> =
//                    ParseQuery.getQuery(EmployeeWorkLog::class.java)
//                query.whereEqualTo(EmployeeWorkLog.KEY_COMPANY_NAME, COMPANY_NAME)
//                query.whereEqualTo(EmployeeWorkLog.KEY_WORK_DATE, selectedDate)
//                query.whereEqualTo(EmployeeWorkLog.KEY_EMP_ID, emp.empId)
//                query.findInBackground { results, e ->
//                    if (e != null) {
//                        showToast(resources.getString(R.string.save_failed))
//                        Log.d("GKBRICKS_WORK_LOG_GET", e.message.toString() + e.code)
//                    } else if (results.isEmpty()) {
//                        Log.d("GKBRICKS_WORK_LOG_GET", "EMPTY")
//                        val work = EmployeeWorkLog()
//                        work.empId = emp.empId
//                        work.empSalary = salary
//                        work.empPhoto = emp.empPhoto
//                        work.empName = emp.empName
//                        work.isPaid = false
//                        work.workDate = selectedDate
//                        work.companyName = COMPANY_NAME
//                        work.updateFrom = UPDATE_FROM
//                        work.saveInBackground { e ->
//                            if (e == null) {
//                                Log.d("GK_BRICKS", "Employee Work log added successfully")
//                                showToast(resources.getString(R.string.saved_success))
//                                emp.isUpdated = true
//                                employeeWorkUpdateAdapter.notifyDataSetChanged()
//                            } else {
//                                Log.e("GK_BRICKS", "Employee to add Work log", e)
//                                showToast(resources.getString(R.string.save_failed))
//                            }
//                        }
//
//                    } else {
//                        Log.d("GKBRICKS_WORK_LOG_GET", results.size.toString())
//                        results.forEach { workLog ->
//                            if (salary != 0) {
//                                if(workLog.isPaid){
//                                    showToast(resources.getString(R.string.already_you_paid))
//                                }else {
//                                    workLog.empSalary = salary
//                                    workLog.saveInBackground { e ->
//                                        if (e == null) {
//                                            Log.d(
//                                                "GK_BRICKS",
//                                                "Employee Work log updated successfully"
//                                            )
//                                            emp.isUpdated = true
//                                            employeeWorkUpdateAdapter.notifyDataSetChanged()
//                                            showToast(resources.getString(R.string.updated_success))
//                                        } else {
//                                            Log.e("GK_BRICKS", "Employee to update Work log", e)
//                                            showToast(resources.getString(R.string.updated_failed))
//                                        }
//                                    }
//                                }
//                            } else {
//                                workLog.deleteInBackground { e ->
//                                    if (e == null) {
//                                        Log.d("GK_BRICKS", "Employee Work log deleted successfully")
//                                        emp.isUpdated = true
//                                        employeeWorkUpdateAdapter.notifyDataSetChanged()
//                                        showToast(resources.getString(R.string.deleted_success))
//                                    } else {
//                                        Log.e("GK_BRICKS", "Employee to delete Work log", e)
//                                        showToast(resources.getString(R.string.delete_failed))
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

    private external fun getApiKey(id: Int, isDebug: Boolean): String

}