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
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gk.bricks.R
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.util.getRupeesFormat
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class AllEmployeeAdapter(private val mContext: Context,
                         private val list: List<Employee>,
                         private val listener: OnEmployeeActionListener) :
    RecyclerView.Adapter<AllEmployeeAdapter.ViewHolder>() {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    interface OnEmployeeActionListener {
        fun onEmployeeActionChanged(emp: Employee)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvSalary: TextView = view.findViewById(R.id.tvSalaryValue)
        val tvAdvance: TextView = view.findViewById(R.id.tvAdvanceValue)
        val ivProfile: ImageView = view.findViewById(R.id.ivProfile)
        val listRow: LinearLayout = view.findViewById(R.id.listRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emp_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.createdAt)
        holder.tvDate.text = formattedDate
        holder.tvName.text = item.empName
        holder.tvSalary.text = getRupeesFormat(item.empSalary)
        holder.tvAdvance.text = getRupeesFormat(item.empAdvance)
        loadProfileImageFromS3(item.empPhoto, holder.ivProfile)
        if(item.isBlocked)
            holder.listRow.setBackgroundColor(mContext.resources.getColor(R.color.lightGrey))
        else
            holder.listRow.setBackgroundColor(mContext.resources.getColor(R.color.emp_list_row))

        holder.itemView.setOnClickListener {
            listener.onEmployeeActionChanged(item)
        }
        holder.ivProfile.setOnClickListener {
            showProfilePopupWithAnimation(it,item.empPhoto)
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