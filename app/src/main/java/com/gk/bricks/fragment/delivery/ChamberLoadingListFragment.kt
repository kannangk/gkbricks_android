package com.gk.bricks.fragment.delivery

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.R
import com.gk.bricks.adapter.ChamberLoadingAdapter
import com.gk.bricks.databinding.FragmentChamberListBinding
import com.gk.bricks.dialog.ConfirmationDialog
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.Constants.UPDATE_FROM
import com.gk.bricks.util.generateRandomText
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

@AndroidEntryPoint
class ChamberLoadingListFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentChamberListBinding
    private lateinit var chamberLoadingAdapter: ChamberLoadingAdapter
    private val empList = mutableListOf<BricksChamberLoading>()

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
        binding = FragmentChamberListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        chamberLoadingAdapter =
            ChamberLoadingAdapter(
                mContext,
                empList,
                object : ChamberLoadingAdapter.OnChamberActionListener {
                    override fun onChamberActionChanged(bricksChamberLoading: BricksChamberLoading) {
                        val bundle = Bundle().apply {
                            putString("chamber_id", bricksChamberLoading.chamberId)
                        }
                        findNavController().navigate(
                            R.id.chamberIndiviualFragment,
                            bundle
                        )
                    }
                })
        binding.recyclerView.adapter = chamberLoadingAdapter
        updateChamberLoadedList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }
        binding.ivPlus.setOnClickListener {
            onShowDate()
        }
        return binding.root
    }

    private fun updateChamberLoadedList() {
        binding.recyclerView.visibility = View.GONE
        binding.pbLoad.visibility = View.VISIBLE
        empList.clear()
        chamberLoadingAdapter.notifyDataSetChanged()
        mainNavViewModel.getBricksChamberLoadingList(mContext) { updatedData ->
            binding.pbLoad.visibility = View.GONE
            if (updatedData.isNotEmpty()) {
                binding.tvNoData.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                empList.clear()
                empList.addAll(updatedData)
                chamberLoadingAdapter.notifyDataSetChanged()
            } else {
                binding.tvNoData.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }

    }

    private fun onShowDate() {
        showDatePicker { selectedDate, chamberId ->
            Log.d("GKBRICKS", "User selected: $selectedDate")
            onShowConfirmation(selectedDate, chamberId)
        }
    }

    private fun onShowConfirmation(date: String, chamberId: String) {
        val d = ConfirmationDialog(
            requireActivity(),
            resources.getString(R.string.add_chamber),
            resources.getString(R.string.add_chamber_msg),
            onCancel = {

            },
            onConfirm = {
                GlobalScope.launch(IO) {
                    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    format.timeZone = TimeZone.getTimeZone("UTC")
                    val selectedDate = format.parse(date)
                    val bricksChamberLoading = BricksChamberLoading()
                    bricksChamberLoading.chamberId = chamberId
                    bricksChamberLoading.totalBricks = 0
                    bricksChamberLoading.totalPaidAmount = 0
                    bricksChamberLoading.totalReceivedAmount = 0
                    bricksChamberLoading.totalTakenBricks = 0
                    bricksChamberLoading.isCompleted = false
                    bricksChamberLoading.chamberCreateDate = selectedDate
                    bricksChamberLoading.companyName = COMPANY_NAME
                    bricksChamberLoading.updateFrom = UPDATE_FROM
                    bricksChamberLoading.saveInBackground { e ->
                        if (e == null) {
                            activity?.runOnUiThread {
                                showToast(resources.getString(R.string.saved_success))
                            }
                            updateChamberLoadedList()
                        } else {
                            activity?.runOnUiThread {
                                showToast(resources.getString(R.string.try_again))
                            }
                        }
                    }

                }

            }
        )
        d.show()
    }

    fun showDatePicker(onDateSelected: (String, String) -> Unit) {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            /* context = */ mContext,
            { _, year, month, dayOfMonth ->
                val date = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                val chamberId = "GK_${dayOfMonth}_${month + 1}_${year}_${generateRandomText(3)}"
                onDateSelected(date, chamberId) // call the listener
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }


}