package com.gk.bricks.fragment.employee

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gk.bricks.R
import com.gk.bricks.databinding.FragmentEmployeeHomeBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class EmployeeHomeFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentEmployeeHomeBinding

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
        binding = FragmentEmployeeHomeBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            activity?.finish()
        }
        binding.llAddLabour.setOnClickListener {
            viewModel.navigate(R.id.addLabourFragment)
        }
        binding.llViewLabourWork.setOnClickListener {
            viewModel.navigate(R.id.employeeListFragment)
        }
        binding.llUpdateLabourWork.setOnClickListener {
            onShowDate()
        }
        binding.llViewAllLabours.setOnClickListener {
            viewModel.navigate(R.id.allEmployeeListFragment)
        }
        return binding.root
    }

    private fun onShowDate(){
        showDatePicker { selectedDate ->
            Log.d("GKBRICKS", "User selected: $selectedDate")
            val bundle = Bundle().apply {
                putString("selected_date", selectedDate)
            }
            findNavController().navigate(
                R.id.employeeWorkUpdateFragment,
                bundle
            )
        }
    }

    fun showDatePicker(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            /* context = */ mContext,
            { _, year, month, dayOfMonth ->
                val date = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                onDateSelected(date) // call the listener
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}