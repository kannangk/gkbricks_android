package com.gk.bricks.fragment.delivery

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gk.bricks.R
import com.gk.bricks.adapter.ChamberUnloadingLogAdapter
import com.gk.bricks.databinding.FragmentChamberUnloadingIndividualDataBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.model.parse.BricksUnloadingLogs
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChamberUnloadingIndiviualFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentChamberUnloadingIndividualDataBinding
    private lateinit var chamberUnloadingLogAdapter: ChamberUnloadingLogAdapter
    private var bricksChamberLoading: BricksChamberLoading? = null
    private val bricksUnloadingLogList = mutableListOf<BricksUnloadingLogs>()
    private var chamberId = ""

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
        binding = FragmentChamberUnloadingIndividualDataBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        chamberId = arguments?.getString("chamber_id") ?: ""

        binding.tvTitle.text = chamberId

        chamberUnloadingLogAdapter = ChamberUnloadingLogAdapter(
            mContext, bricksUnloadingLogList
        )
        binding.recyclerView.adapter = chamberUnloadingLogAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.ivSend.setOnClickListener {
            val bundle = Bundle().apply {
                putString("chamber_id", chamberId)
            }
            findNavController().navigate(
                R.id.addChamberUnloadingLogsFragment,
                bundle
            )
        }
//
//
//        binding.ivPay.setOnClickListener {
//            try {
//                val dialog = DialogAddVendorPayment(vendorId, vendorType) {
//                    updateProductionList()
//                }
//                dialog.show(parentFragmentManager, "VendorPaymentDialog")
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }

        return binding.root
    }


    private fun updateProductionList() {
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.llsalary.visibility = View.GONE
        bricksUnloadingLogList.clear()
        chamberUnloadingLogAdapter.notifyDataSetChanged()
        mainNavViewModel.getChamberFromId(chamberId) { data ->
            if (data.isEmpty())
                return@getChamberFromId
            bricksChamberLoading = data[0]

            binding.tvBricksCount.text =
                getCommaFormat(bricksChamberLoading?.totalBricks ?: 0)

            binding.tvReceived.text =
                getRupeesFormat(bricksChamberLoading?.totalReceivedAmount ?: 0)

            binding.tvTakenCount.text =
                getCommaFormat(bricksChamberLoading?.totalTakenBricks ?: 0)

            mainNavViewModel.getChamberUnloadingLog(chamberId) { workLogs ->
                binding.pbLoad.visibility = View.GONE
                binding.shimmerLayout.visibility = View.GONE
                binding.llsalary.visibility = View.VISIBLE
                if (workLogs.isNotEmpty()) {
                    binding.tvNoData.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    bricksUnloadingLogList.clear()
                    bricksUnloadingLogList.addAll(workLogs)
                    chamberUnloadingLogAdapter.notifyDataSetChanged()
                } else {
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


}