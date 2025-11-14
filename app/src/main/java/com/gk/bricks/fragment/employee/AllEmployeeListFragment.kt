package com.gk.bricks.fragment.employee

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.R
import com.gk.bricks.adapter.AllEmployeeAdapter
import com.gk.bricks.databinding.FragmentAllEmployeeBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllEmployeeListFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentAllEmployeeBinding
    private lateinit var employeeAdapter: AllEmployeeAdapter
    private val empList = mutableListOf<Employee>()

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
        binding = FragmentAllEmployeeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        employeeAdapter =
            AllEmployeeAdapter(
                mContext,
                empList,
                object : AllEmployeeAdapter.OnEmployeeActionListener {
                    override fun onEmployeeActionChanged(emp: Employee) {
                        val bundle = Bundle().apply {
                            putString("emp_id", emp.empId)
                            putString("emp_Name", emp.empName)
                            putString("emp_Photo_Url", emp.empPhoto)
                            putBoolean("is_salary_screen", false)
                        }
                        findNavController().navigate(
                            R.id.employeeSalaryIndiviualFragment,
                            bundle
                        )
                    }
                })
        binding.recyclerView.adapter = employeeAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }
        return binding.root
    }

    private fun updateProductionList() {
        mainNavViewModel.getAllEmployeeList(mContext) { updatedData ->
            binding.pbLoad.visibility = View.GONE
            if (updatedData.isNotEmpty()) {
                binding.tvNoData.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                empList.clear()
                empList.addAll(updatedData)
                employeeAdapter.notifyDataSetChanged()
            } else {
                binding.tvNoData.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }

    }


}