package com.gk.bricks.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gk.bricks.R
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import java.text.SimpleDateFormat
import java.util.Locale

class EmployeeSalaryAdapter(
    private val mContext: Context,
    private val list: List<EmployeeWorkLog>
) :
    RecyclerView.Adapter<EmployeeSalaryAdapter.ViewHolder>() {

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvSalary: TextView = view.findViewById(R.id.tvSalary)
        val tvTotal: TextView = view.findViewById(R.id.tvTotal)
        val tvPaid: TextView = view.findViewById(R.id.tvPaid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emp_salary_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.workDate)
        holder.tvDate.text = formattedDate
        holder.tvTotal.text = getRupeesFormat(item.totalAmount)
        if (item.isPayable) {
            holder.tvSalary.text = "-"
            holder.tvPaid.text = getRupeesFormat(item.totalPaidAmount)
            holder.tvDate.paintFlags =
                holder.tvTotal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            holder.tvSalary.paintFlags =
                holder.tvTotal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            holder.tvPaid.isClickable = true
            holder.tvPaid.isEnabled = true
        } else {
            holder.tvPaid.isClickable = false
            holder.tvPaid.isEnabled = false
            holder.tvSalary.text = getRupeesFormat(item.empSalary)
            holder.tvPaid.text = ""
            if (item.isPaid) {
                holder.tvDate.paintFlags = holder.tvTotal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                holder.tvSalary.paintFlags =
                    holder.tvTotal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//                holder.tvTotal.paintFlags = holder.tvTotal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.tvDate.paintFlags =
                    holder.tvTotal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                holder.tvSalary.paintFlags =
                    holder.tvTotal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
//                holder.tvTotal.paintFlags =
//                    holder.tvTotal.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
        holder.tvPaid.setOnClickListener {
            if (item.isPayable) {
                showLogPopup(it, item)
            }
        }

    }

    private fun showLogPopup(view: View, data: EmployeeWorkLog) {
        val context = view.context
        val dialogView =
            LayoutInflater.from(context).inflate(R.layout.dialog_emp_paid_details, null)
        val tvTotalWorkingSalary = dialogView.findViewById<TextView>(R.id.tvTotalWorkingSalary)
        val tvTotalPaidSalary = dialogView.findViewById<TextView>(R.id.tvTotalPaidSalary)
//        val tvFirstStatus = dialogView.findViewById<TextView>(R.id.tvFirstStatus)
        val tvSecondStatus = dialogView.findViewById<TextView>(R.id.tvSecondStatus)
        val tvTotalRemainingBalance =
            dialogView.findViewById<TextView>(R.id.tvTotalRemainingBalance)
        val tvPreviousAdvance = dialogView.findViewById<TextView>(R.id.tvPreviousAdvance)
        val tvTotalRemainingBalance1 =
            dialogView.findViewById<TextView>(R.id.tvTotalRemainingBalance1)
        val tvTotalRemainingAdvance =
            dialogView.findViewById<TextView>(R.id.tvTotalRemainingAdvance)
        val btnClose = dialogView.findViewById<TextView>(R.id.btnClose)
        tvTotalWorkingSalary.text = getCommaFormat(data.totalWorkingSalary)
        tvTotalPaidSalary.text = getCommaFormat(data.totalPaidAmount)
        var totalRemainingBalance = data.totalWorkingSalary - data.totalPaidAmount
        tvTotalRemainingBalance.text = getCommaFormat(totalRemainingBalance)
        tvPreviousAdvance.text = getCommaFormat(data.previousAdvanceAmount)
        tvTotalRemainingAdvance.text = getCommaFormat(data.afterAdvanceAmount)

        if (totalRemainingBalance < 0) {
            tvSecondStatus.text = "+"
            totalRemainingBalance = (-1*totalRemainingBalance)
            tvTotalRemainingBalance1.text = getCommaFormat(totalRemainingBalance)
        }else{
            tvSecondStatus.text = "-"
            tvTotalRemainingBalance1.text = getCommaFormat(totalRemainingBalance)
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


    override fun getItemCount(): Int = list.size
}