package com.gk.bricks.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.gk.bricks.R
import com.gk.bricks.model.parse.BricksUnloadingLogs
import com.gk.bricks.model.parse.VendorPaidLog
import com.gk.bricks.util.Constants.VENDOR_FIRE_WOOD_TYPE
import com.gk.bricks.util.bricksItemMap
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Locale

class ChamberUnloadingLogAdapter(
    private val mContext: Context,
    private val list: List<BricksUnloadingLogs>
) :
    RecyclerView.Adapter<ChamberUnloadingLogAdapter.ViewHolder>() {

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvLoadCount: TextView = view.findViewById(R.id.tvLoadCount)
        val tvReceived: TextView = view.findViewById(R.id.tvReceived)
        val tvLoadType: TextView = view.findViewById(R.id.tvLoadType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chamber_unloading_log_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.workDate)
        holder.tvDate.text = formattedDate

        holder.tvReceived.text = getRupeesFormat(item.paidAmount)
        holder.tvName.text = item.customerName


        if(item.bricksCount>0){
            val itemValues = bricksItemMap(mContext)
            holder.tvLoadType.text = item.bricksType
            if (itemValues.contains(item.bricksType)) {
                holder.tvLoadType.text = itemValues.get(item.bricksType)?:""
            }
            holder.tvLoadCount.text = getCommaFormat(item.bricksCount)
        }else{
            holder.tvLoadType.text = ""
            holder.tvLoadCount.text = "-"
        }



//        if (item.isPaid) {
//            holder.tvReceived.text = getRupeesFormat(item.paidAmount)
//            holder.tvLoadName.text = "-"
//            holder.tvLoadAmount.text = "-"
//            holder.tvPaid.isClickable = true
//            holder.tvPaid.isEnabled = true
//            holder.tvLoadAmount.isClickable = false
//            holder.tvLoadAmount.isEnabled = false
//            holder.tvLoadName.isClickable = false
//            holder.tvLoadName.isEnabled = false
//        } else {
//            holder.tvPaid.isClickable = false
//            holder.tvPaid.isEnabled = false
//            holder.tvLoadAmount.isClickable = true
//            holder.tvLoadAmount.isEnabled = true
//            holder.tvLoadName.isClickable = true
//            holder.tvLoadName.isEnabled = true
//            holder.tvPaid.text = "-"
//            holder.tvLoadAmount.text = getRupeesFormat(item.totalLoadAmount)
//            holder.tvLoadName.text = item.loadName
//            val itemValues = vendorLoadItemMap(mContext)
//            if (itemValues.contains(item.loadName)) {
//                holder.tvLoadName.text = itemValues.get(item.loadName)
//            }
//        }
//        holder.tvPaid.setOnClickListener {
//            if (item.isPaid) {
//                showLogPopup(it, item)
//            }
//        }
//
//        holder.tvLoadAmount.setOnClickListener {
//            if (!item.isPaid) {
//                showLoadPopup(
//                    it,
//                    item,
//                    holder.tvLoadName.text.toString(),
//                    holder.tvDate.text.toString()
//                )
//            }
//        }
//
//        holder.tvLoadName.setOnClickListener {
//            if (!item.isPaid) {
//                showLoadPopup(
//                    it,
//                    item,
//                    holder.tvLoadName.text.toString(),
//                    holder.tvDate.text.toString()
//                )
//            }
//        }

    }

    private fun showLoadPopup(view: View, data: VendorPaidLog, loadName: String, date: String) {
        val context = view.context
        val dialogView =
            LayoutInflater.from(context).inflate(R.layout.dialog_vendor_load_details, null)
        val tvTitle = dialogView.findViewById<TextView>(R.id.tvTitle)
        val tvDate = dialogView.findViewById<TextView>(R.id.tvDate)
        val tvLoadNameLabel = dialogView.findViewById<TextView>(R.id.tvLoadNameLabel)
        val tvLoadCount = dialogView.findViewById<TextView>(R.id.tvLoadCount)
        val tvLoadName = dialogView.findViewById<TextView>(R.id.tvLoadName)
        val tvPreviousBalance = dialogView.findViewById<TextView>(R.id.tvPreviousBalance)
        val tvLoadAmount = dialogView.findViewById<TextView>(R.id.tvLoadAmount)
        val llDocuments = dialogView.findViewById<LinearLayout>(R.id.llDocuments)
        val ivDocument1 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument1)
        val ivDocument2 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument2)
        val ivDocument3 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument3)
        val tvTotalRemainingBalance =
            dialogView.findViewById<TextView>(R.id.tvTotalRemainingBalance)

        if (data.vendorType == VENDOR_FIRE_WOOD_TYPE) {
            tvTitle.text = view.context.getString(R.string.firewood_log_details)
            tvLoadNameLabel.text = view.context.getString(R.string.firewood_name_label)
        } else {
            tvTitle.text = view.context.getString(R.string.sand_log_details)
            tvLoadNameLabel.text = view.context.getString(R.string.sand_name_label)
        }
        tvDate.text = date
        tvLoadName.text = loadName
        tvLoadCount.text = data.loadCount.toString()
        val btnClose = dialogView.findViewById<TextView>(R.id.btnClose)
        tvPreviousBalance.text = getCommaFormat(data.previousRemainingAmount)
        tvLoadAmount.text = getCommaFormat(data.totalLoadAmount)
        tvTotalRemainingBalance.text = getCommaFormat(data.afterRemainingAmount)

        if (data.documentOne.isNotEmpty() || data.documentTwo.isNotEmpty() || data.documentThree.isNotEmpty()) {
            llDocuments.visibility = View.VISIBLE
            if (data.documentOne.isNotEmpty()) {
                ivDocument1.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentOne, ivDocument1)
                ivDocument1.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument1, data.documentOne)
                }
            }
            if (data.documentTwo.isNotEmpty()) {
                ivDocument2.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentTwo, ivDocument2)
                ivDocument2.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument2, data.documentTwo)
                }
            }
            if (data.documentThree.isNotEmpty()) {
                ivDocument3.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentThree, ivDocument3)
                ivDocument3.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument3, data.documentThree)
                }
            }
        }

        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        btnClose.setOnClickListener {
            alertDialog.dismiss()
        }

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

    private fun showLogPopup(view: View, data: VendorPaidLog) {
        val context = view.context
        val dialogView =
            LayoutInflater.from(context).inflate(R.layout.dialog_vendor_paid_details, null)
        val tvPreviousBalance = dialogView.findViewById<TextView>(R.id.tvPreviousBalance)
        val tvPaid = dialogView.findViewById<TextView>(R.id.tvPaid)
        val tvTotalRemainingBalance =
            dialogView.findViewById<TextView>(R.id.tvTotalRemainingBalance)
        val llDocuments = dialogView.findViewById<LinearLayout>(R.id.llDocuments)
        val ivDocument1 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument1)
        val ivDocument2 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument2)
        val ivDocument3 = dialogView.findViewById<AppCompatImageView>(R.id.ivDocument3)

        val btnClose = dialogView.findViewById<TextView>(R.id.btnClose)
        tvPreviousBalance.text = getCommaFormat(data.previousRemainingAmount)
        tvPaid.text = getCommaFormat(data.paidAmount)
        tvTotalRemainingBalance.text = getCommaFormat(data.afterRemainingAmount)
        if (data.documentOne.isNotEmpty() || data.documentTwo.isNotEmpty() || data.documentThree.isNotEmpty()) {
            llDocuments.visibility = View.VISIBLE
            if (data.documentOne.isNotEmpty()) {
                ivDocument1.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentOne, ivDocument1)
                ivDocument1.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument1, data.documentOne)
                }
            }
            if (data.documentTwo.isNotEmpty()) {
                ivDocument2.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentTwo, ivDocument2)
                ivDocument2.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument2, data.documentTwo)
                }
            }
            if (data.documentThree.isNotEmpty()) {
                ivDocument3.visibility = View.VISIBLE
                loadProfileImageFromS3(data.documentThree, ivDocument3)
                ivDocument3.setOnClickListener {
                    showDocumentPopupWithAnimation(ivDocument3, data.documentThree)
                }
            }
        }

        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        btnClose.setOnClickListener {
            alertDialog.dismiss()
        }

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

    private fun loadProfileImageFromS3(url: String, ivView: ImageView) {
        GlobalScope.launch(Main) {
            Glide.with(ivView)
                .load(url)
                .placeholder(R.drawable.ic_profile) // optional
                .error(R.drawable.ic_profile)             // optional
                .into(ivView)
        }
    }

    private fun showDocumentPopupWithAnimation(view: View, url: String) {
        val context = view.context
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_document_popup, null)
        val imageView = dialogView.findViewById<PhotoView>(R.id.popupImageView)
        val ivClose = dialogView.findViewById<ImageView>(R.id.ivClose)
        val ivDownload = dialogView.findViewById<ImageView>(R.id.ivDownload)
        Glide.with(imageView)
            .load(url)
            .placeholder(R.drawable.ic_no_image) // optional
            .error(R.drawable.ic_no_image)             // optional
            .into(imageView)

        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
        ivClose.setOnClickListener {
            alertDialog.dismiss()
        }

        ivDownload.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    withContext(Main) {
                        Toast.makeText(context, "Downloading...", Toast.LENGTH_LONG).show()
                        alertDialog.dismiss()
                    }
                    val fileName = "document_${System.currentTimeMillis()}.jpg"
                    val resolver = context.contentResolver

                    val contentValues = ContentValues().apply {
                        put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                        put(
                            MediaStore.MediaColumns.RELATIVE_PATH,
                            Environment.DIRECTORY_PICTURES + "/VendorDocs"
                        )
                    }

                    val imageUri =
                        resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                    val input = URL(url).openStream()
                    val output = resolver.openOutputStream(imageUri!!)

                    input.use { inputStream ->
                        output.use { outputStream ->
                            inputStream.copyTo(outputStream!!)
                        }
                    }

                    withContext(Main) {
                        Toast.makeText(
                            context,
                            "Downloaded to Pictures/VendorDocs",
                            Toast.LENGTH_LONG
                        ).show()
                        alertDialog.dismiss()
                    }
                } catch (e: Exception) {
                    withContext(Main) {
                        Toast.makeText(context, "Download failed: ${e.message}", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

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