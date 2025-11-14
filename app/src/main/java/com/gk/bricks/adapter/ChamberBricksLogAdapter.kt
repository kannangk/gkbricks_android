package com.gk.bricks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gk.bricks.R
import com.gk.bricks.model.parse.BricksChamberLoadingLogs
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import java.text.SimpleDateFormat
import java.util.Locale

class ChamberBricksLogAdapter(
    private val mContext: Context,
    private val list: List<BricksChamberLoadingLogs>
) :
    RecyclerView.Adapter<ChamberBricksLogAdapter.ViewHolder>() {

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvBricksCount: TextView = view.findViewById(R.id.tvBricksCount)
        val tvPaid: TextView = view.findViewById(R.id.tvPaid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chamber_log_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.paidDate)
        holder.tvDate.text = formattedDate
        holder.tvPaid.text = getRupeesFormat(item.paidAmount)
        holder.tvBricksCount.text = getCommaFormat(item.loadedBricks)
    }


    override fun getItemCount(): Int = list.size
}