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
import com.gk.bricks.adapter.VendorPaidLogAdapter
import com.gk.bricks.databinding.FragmentVendorIndividualDataBinding
import com.gk.bricks.dialog.DialogAddVendorPayment
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.model.parse.VendorPaidLog
import com.gk.bricks.util.Constants.VENDOR_FIRE_WOOD_TYPE
import com.gk.bricks.util.getRupeesFormat
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VendorIndiviualFragment : BaseFragment() {
    private lateinit var mContext: Context
    private lateinit var binding: FragmentVendorIndividualDataBinding
    private lateinit var vendorPaidLogAdapter: VendorPaidLogAdapter
    private var vendorDetails: Vendor? = null
    private val vendorPaidLogList = mutableListOf<VendorPaidLog>()
    private var vendorId = ""
    private var vendorName = ""
    private var vendorType = VENDOR_FIRE_WOOD_TYPE
    private var vendorPhotoUrl = ""

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
        binding = FragmentVendorIndividualDataBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        vendorId = arguments?.getString("vendor_id") ?: ""
        vendorType = arguments?.getString("vendor_type") ?: VENDOR_FIRE_WOOD_TYPE
        vendorName = arguments?.getString("vendor_name") ?: ""

        binding.tvTitle.text = vendorName

        if (vendorType == VENDOR_FIRE_WOOD_TYPE) {
            binding.tvLoadNameLabel.text = mContext.getString(R.string.firewood_name_label)
            binding.tvLoadAmountLabel.text = mContext.getString(R.string.firewood_price_label)
        } else {
            binding.tvLoadNameLabel.text = mContext.getString(R.string.sand_name_label)
            binding.tvLoadAmountLabel.text = mContext.getString(R.string.sand_price_label)
        }
        vendorPaidLogAdapter = VendorPaidLogAdapter(
            mContext, vendorPaidLogList
        )
        binding.recyclerView.adapter = vendorPaidLogAdapter
        updateProductionList()
        binding.ivBack.setOnClickListener {
            viewModel.navigateBack()
        }

        binding.ivAdd.setOnClickListener {
            val bundle = Bundle().apply {
                putString("vendor_id", vendorId)
                putString("vendor_name", vendorName)
                putString("vendor_type", vendorType)
            }
            findNavController().navigate(
                R.id.addVendorLogsFragment,
                bundle
            )
        }

        binding.ivProfile.setOnClickListener {
            showProfilePopupWithAnimation(it, vendorPhotoUrl)
        }

        binding.ivPay.setOnClickListener {
            try {
                val dialog = DialogAddVendorPayment(vendorId, vendorType) {
                    updateProductionList()
                }
                dialog.show(parentFragmentManager, "VendorPaymentDialog")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return binding.root
    }


    private fun updateProductionList() {
        binding.shimmerLayout.visibility = View.VISIBLE
        binding.llsalary.visibility = View.GONE
        vendorPaidLogList.clear()
        vendorPaidLogAdapter.notifyDataSetChanged()
        mainNavViewModel.getVendorFromId(vendorId) { data ->
            if (data.isEmpty())
                return@getVendorFromId
            vendorDetails = data[0]
            vendorPhotoUrl = vendorDetails?.vendorPhoto ?: ""
            loadProfileImageFromS3(vendorPhotoUrl, binding.ivProfile)
            binding.tvTotalRemainingBalance.text =
                getRupeesFormat(vendorDetails?.vendorBalance ?: 0)
            mainNavViewModel.getVendorPaidLog(vendorId) { workLogs ->
                binding.pbLoad.visibility = View.GONE
                binding.ivPay.isClickable = true
                binding.ivPay.isEnabled = true
                binding.shimmerLayout.visibility = View.GONE
                binding.llsalary.visibility = View.VISIBLE
                if (workLogs.isNotEmpty()) {
                    binding.tvNoData.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    vendorPaidLogList.clear()
                    vendorPaidLogList.addAll(workLogs)
                    vendorPaidLogAdapter.notifyDataSetChanged()
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