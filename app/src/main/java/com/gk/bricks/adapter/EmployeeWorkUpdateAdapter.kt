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
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gk.bricks.R
import com.gk.bricks.dialog.ConfirmationDialog
import com.gk.bricks.fragment.employee.EmployeeWorkUpdateFragment
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.util.Constants.REQUEST_RESET
import com.gk.bricks.util.getRupeesFormat
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EmployeeWorkUpdateAdapter(
    private val employeeWorkUpdateFragment: EmployeeWorkUpdateFragment,
    private val list: List<Employee>,
    private val selectedDate: Date?,
    private val listener: OnEmployeeActionListener? = null
) :
    RecyclerView.Adapter<EmployeeWorkUpdateAdapter.ViewHolder>() {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    var updatedDetails = HashMap<String, Int>()
    var updatedPaidDetails = HashMap<String, Boolean>()

    interface OnEmployeeActionListener {
        fun onEmployeeActionChanged(workLog: Employee, salary: Int)
    }

    fun updateWorkLog(workLogs: List<EmployeeWorkLog>) {
        workLogs.forEach { workLog ->
            updatedDetails.put(workLog.empId, workLog.empSalary)
            updatedPaidDetails.put(workLog.empId, workLog.isPaid)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvSalary: TextView = view.findViewById(R.id.tvSalaryValue)
        val tvCurrentSalary: TextView = view.findViewById(R.id.tvCurrentSalary)
        val ivProfile: ImageView = view.findViewById(R.id.ivProfile)
        val ivAddStatus: ImageView = view.findViewById(R.id.ivAddStatus)
        val llAddView: FrameLayout = view.findViewById(R.id.llAddView)
        val llPopupView: LinearLayout = view.findViewById(R.id.llPopupView)
        val pbLoading: ProgressBar = view.findViewById(R.id.pbLoading)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emp_work_update_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(selectedDate)
        holder.tvDate.text = formattedDate
        holder.tvName.text = item.empName
        holder.tvCurrentSalary.text = "-"
        holder.tvSalary.text = getRupeesFormat(item.empSalary)
        loadProfileImageFromS3(item.empPhoto, holder.ivProfile)
        holder.tvCurrentSalary.paintFlags =
            holder.tvCurrentSalary.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        holder.tvDate.paintFlags = holder.tvDate.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        if (item.isUpdated)
            holder.pbLoading.visibility = View.GONE
        else
            holder.pbLoading.visibility = View.VISIBLE

        holder.llPopupView.isClickable = true
        holder.llPopupView.isEnabled = true

        if (updatedDetails.contains(item.empId)) {
            if (updatedPaidDetails.get(item.empId) ?: false) {
                holder.tvCurrentSalary.text = getRupeesFormat(updatedDetails.get(item.empId) ?: 0)
                holder.llAddView.setBackgroundColor(
                    ContextCompat.getColor(employeeWorkUpdateFragment.requireActivity(), R.color.lightGrey)
                )
                holder.ivAddStatus.setImageDrawable(
                    ContextCompat.getDrawable(employeeWorkUpdateFragment.requireActivity(), R.drawable.ic_calender_minus)
                )
                holder.tvCurrentSalary.paintFlags =
                    holder.tvCurrentSalary.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                holder.tvDate.paintFlags = holder.tvDate.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                holder.llPopupView.isClickable = false
                holder.llPopupView.isEnabled = false
            } else {
                holder.tvCurrentSalary.text = getRupeesFormat(updatedDetails.get(item.empId) ?: 0)
                holder.llAddView.setBackgroundColor(
                    ContextCompat.getColor(employeeWorkUpdateFragment.requireActivity(), R.color.green)
                )
                holder.ivAddStatus.setImageDrawable(
                    ContextCompat.getDrawable(employeeWorkUpdateFragment.requireActivity(), R.drawable.ic_calender_minus)
                )
            }
        } else {
            holder.tvCurrentSalary.text = "-"
            holder.llAddView.setBackgroundColor(
                ContextCompat.getColor(employeeWorkUpdateFragment.requireActivity(), R.color.orange)
            )
            holder.ivAddStatus.setImageDrawable(
                ContextCompat.getDrawable(employeeWorkUpdateFragment.requireActivity(), R.drawable.ic_calender_plus)
            )
        }

        holder.llPopupView.setOnClickListener {
            if (updatedDetails.contains(item.empId)) {
                val d = ConfirmationDialog(
                    employeeWorkUpdateFragment.requireActivity(),
                    employeeWorkUpdateFragment.resources.getString(R.string.salary_delete_title),
                    employeeWorkUpdateFragment.resources.getString(R.string.salary_delete_msg),
                    onCancel = {

                    },
                    onConfirm = {
                        updatedDetails.remove(item.empId)
                        holder.llAddView.setBackgroundColor(
                            ContextCompat.getColor(employeeWorkUpdateFragment.requireActivity(), R.color.orange)
                        )
                        holder.tvCurrentSalary.text = "-"
                        holder.ivAddStatus.setImageDrawable(
                            ContextCompat.getDrawable(employeeWorkUpdateFragment.requireActivity(), R.drawable.ic_calender_plus)
                        )
                        item.isUpdated = false
                        holder.pbLoading.visibility = View.VISIBLE
                        listener?.onEmployeeActionChanged(item, 0)
                    }
                )
                d.show()

            } else {
                showEditTextDialog(
                    employeeWorkUpdateFragment.requireActivity(),
                    "${item.empName} ${employeeWorkUpdateFragment.requireActivity().resources.getString(R.string.salary)}",
                    item.empSalary.toString()
                ) { newText ->
                    try {
                        val updateSalary = newText.trim().toInt()
                        if (updateSalary > 0) {
                            updatedDetails.put(item.empId, updateSalary)
                            holder.tvCurrentSalary.text = getRupeesFormat(updateSalary)
                            holder.llAddView.setBackgroundColor(
                                ContextCompat.getColor(employeeWorkUpdateFragment.requireActivity(), R.color.green)
                            )
                            holder.ivAddStatus.setImageDrawable(
                                ContextCompat.getDrawable(employeeWorkUpdateFragment.requireActivity(), R.drawable.ic_calender_minus)
                            )
                            item.isUpdated = false
                            holder.pbLoading.visibility = View.VISIBLE
                            listener?.onEmployeeActionChanged(item, updateSalary)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            }
        }
        holder.ivProfile.setOnClickListener {
            showProfilePopupWithAnimation(it, item.empPhoto)
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

    private fun loadProfileImageFromS3(url: String, ivView: ImageView) {
        GlobalScope.launch(Main) {
            Glide.with(ivView)
                .load(url)
                .placeholder(R.drawable.ic_profile) // optional
                .error(R.drawable.ic_profile)             // optional
                .into(ivView)
        }
    }

    fun showEditTextDialog(
        context: Context,
        title: String = "Enter text",
        initialValue: String = "",
        onSave: (String) -> Unit
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_salary_update, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextInput)
        val btnSave = dialogView.findViewById<Button>(R.id.btnSave)
        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)

        editText.setText(initialValue)

        val dialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setView(dialogView)
            .create()

        btnSave.setOnClickListener {
            onSave(editText.text.toString())
            dialog.dismiss()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


    override fun getItemCount(): Int = list.size
}