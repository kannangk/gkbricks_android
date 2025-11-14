package com.gk.bricks.fragment.production

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gk.bricks.R
import com.gk.bricks.databinding.FragmentSettingsBinding
import com.gk.bricks.dialog.ConfirmationDialog
import com.gk.bricks.dialog.DialogAddProductionBricks
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.util.AppSingleton.socketReceivedData
import com.gk.bricks.util.Constants.REQUEST_RESET
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentSettingsBinding
    private var currentCount = 0


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
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.rlSaveProduction.setOnClickListener {
            onShowProductionCountDialog()
        }
        socketReceivedData.observe(viewLifecycleOwner) { data ->
            currentCount = ((data[2].toInt() and 0xFF) shl 8) or (data[1].toInt() and 0xFF) * 2
        }
        binding.rlResetCount.setOnClickListener {
            onShowConfirmation()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun onShowProductionCountDialog() {
        try {
            val dialog =
                DialogAddProductionBricks(requireActivity(), currentCount)
            dialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun onShowConfirmation(){
        val d = ConfirmationDialog(
            requireActivity(),
            resources.getString(R.string.reset_production_count),
            resources.getString(R.string.reset_msg),
            onCancel = {

            },
            onConfirm = {
//                (requireActivity() as MainActivity).resetCount()
                mainNavViewModel.sendWifiData(REQUEST_RESET)
            }
        )
        d.show()
    }

}