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
import com.gk.bricks.adapter.ChamberUnLoadingAdapter
import com.gk.bricks.databinding.FragmentChamberListBinding
import com.gk.bricks.databinding.FragmentChamberUnloadingListBinding
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
class ChamberUnLoadingListFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentChamberUnloadingListBinding
    private lateinit var chamberUnLoadingAdapter: ChamberUnLoadingAdapter
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
        binding = FragmentChamberUnloadingListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        chamberUnLoadingAdapter =
            ChamberUnLoadingAdapter(
                mContext,
                empList,
                object : ChamberUnLoadingAdapter.OnChamberActionListener {
                    override fun onChamberActionChanged(bricksChamberLoading: BricksChamberLoading) {
                        val bundle = Bundle().apply {
                            putString("chamber_id", bricksChamberLoading.chamberId)
                        }
                        findNavController().navigate(
                            R.id.chamberUnloadingIndiviualFragment,
                            bundle
                        )
                    }
                })
        binding.recyclerView.adapter = chamberUnLoadingAdapter
        updateChamberLoadedList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }
        binding.ivVehicleOwners.setOnClickListener {

        }
        return binding.root
    }

    private fun updateChamberLoadedList() {
        binding.recyclerView.visibility = View.GONE
        binding.pbLoad.visibility = View.VISIBLE
        empList.clear()
        chamberUnLoadingAdapter.notifyDataSetChanged()
        mainNavViewModel.getBricksChamberCompletedList(mContext) { updatedData ->
            binding.pbLoad.visibility = View.GONE
            if (updatedData.isNotEmpty()) {
                binding.tvNoData.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                empList.clear()
                empList.addAll(updatedData)
                chamberUnLoadingAdapter.notifyDataSetChanged()
            } else {
                binding.tvNoData.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }

    }



}