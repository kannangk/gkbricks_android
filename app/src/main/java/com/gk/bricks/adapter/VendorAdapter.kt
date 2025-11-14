package com.gk.bricks.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gk.bricks.R
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.util.getRupeesFormat
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class VendorAdapter(private val mContext: Context,
                    private val list: List<Vendor>,
                    private val listener: OnVendorActionListener) :
    RecyclerView.Adapter<VendorAdapter.ViewHolder>() {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    interface OnVendorActionListener {
        fun onVendorActionChanged(vendor: Vendor)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvRemainingBalance: TextView = view.findViewById(R.id.tvRemainingBalance)
        val ivProfile: ImageView = view.findViewById(R.id.ivProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vendor_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.createdAt)
        holder.tvDate.text = formattedDate
        holder.tvName.text = item.vendorName
        holder.tvRemainingBalance.text = getRupeesFormat(item.vendorBalance)
        loadProfileImageFromS3(item.vendorPhoto, holder.ivProfile)
        holder.itemView.setOnClickListener {
            listener.onVendorActionChanged(item)
        }
        holder.ivProfile.setOnClickListener {
            showProfilePopupWithAnimation(it,item.vendorPhoto)
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


    override fun getItemCount(): Int = list.size
}