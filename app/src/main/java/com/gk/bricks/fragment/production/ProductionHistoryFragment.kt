package com.gk.bricks.fragment.production

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gk.bricks.adapter.ProductionAdapter
import com.gk.bricks.databinding.FragmentProductionHistoryBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.ProductionModel
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductionHistoryFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentProductionHistoryBinding
    private lateinit var productionAdapter: ProductionAdapter
    private val productionList = mutableListOf<BricksProduction>()

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
        binding = FragmentProductionHistoryBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        productionAdapter = ProductionAdapter(mContext,productionList)
        binding.recyclerView.adapter = productionAdapter

        updateProductionList()
        return binding.root
    }

    private fun updateProductionList() {
        mainNavViewModel.getAllProductionList(mContext) { updatedData ->
            binding.pbLoad.visibility = View.GONE
            if (updatedData.isNotEmpty()) {
                binding.tvNoData.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                productionList.clear()
                productionList.addAll(updatedData)
                productionAdapter.notifyDataSetChanged()
            } else {
                binding.tvNoData.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }

    }


}