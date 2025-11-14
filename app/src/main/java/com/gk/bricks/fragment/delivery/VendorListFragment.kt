package com.gk.bricks.fragment.delivery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.R
import com.gk.bricks.adapter.VendorAdapter
import com.gk.bricks.databinding.FragmentVendorListBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.util.Constants.VENDOR_FIRE_WOOD_TYPE
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VendorListFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentVendorListBinding
    private lateinit var vendorAdapter: VendorAdapter
    private val vendorList = mutableListOf<Vendor>()
    private var vendorType = VENDOR_FIRE_WOOD_TYPE

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
        binding = FragmentVendorListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        vendorType = arguments?.getString("vendor_type") ?: VENDOR_FIRE_WOOD_TYPE
        if (vendorType == VENDOR_FIRE_WOOD_TYPE)
            binding.tvTitle.text = mContext.getString(R.string.firewood_loading)
        else
            binding.tvTitle.text = mContext.getString(R.string.sand_loading)
        vendorAdapter =
            VendorAdapter(
                mContext,
                vendorList,
                object : VendorAdapter.OnVendorActionListener {
                    override fun onVendorActionChanged(vendor: Vendor) {
                        val bundle = Bundle().apply {
                            putString("vendor_id", vendor.vendorId)
                            putString("vendor_name", vendor.vendorName)
                            putString("vendor_type", vendorType)
                        }
                        findNavController().navigate(
                            R.id.vendorIndiviualFragment,
                            bundle
                        )
                    }
                })
        binding.recyclerView.adapter = vendorAdapter
        updateChamberLoadedList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }
        binding.ivPlus.setOnClickListener {
            val bundle = Bundle().apply {
                putString("vendor_type", vendorType)
            }
            findNavController().navigate(
                R.id.addVendorFragment,
                bundle
            )
        }
        return binding.root
    }

    private fun updateChamberLoadedList() {
        binding.recyclerView.visibility = View.GONE
        binding.pbLoad.visibility = View.VISIBLE
        vendorList.clear()
        vendorAdapter.notifyDataSetChanged()
        mainNavViewModel.getVendorList(vendorType) { updatedData ->
            binding.pbLoad.visibility = View.GONE
            if (updatedData.isNotEmpty()) {
                binding.tvNoData.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                vendorList.clear()
                vendorList.addAll(updatedData)
                vendorAdapter.notifyDataSetChanged()
            } else {
                binding.tvNoData.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }

    }

}