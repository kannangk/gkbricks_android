package com.gk.bricks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gk.bricks.R
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.util.getCommaFormat
import com.gk.bricks.util.getRupeesFormat
import java.text.SimpleDateFormat
import java.util.Locale

class ChamberUnLoadingAdapter(
    private val mContext: Context,
    private val list: List<BricksChamberLoading>,
    private val listener: OnChamberActionListener
) :
    RecyclerView.Adapter<ChamberUnLoadingAdapter.ViewHolder>() {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    interface OnChamberActionListener {
        fun onChamberActionChanged(bricksChamberLoading: BricksChamberLoading)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvChamberId: TextView = view.findViewById(R.id.tvChamberId)
        val tvBricksCount: TextView = view.findViewById(R.id.tvBricksCount)
        val tvTakenCount: TextView = view.findViewById(R.id.tvTakenCount)
        val tvReceived: TextView = view.findViewById(R.id.tvReceived)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chamber_unloading_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.chamberCreateDate)
        holder.tvDate.text = formattedDate
        holder.tvChamberId.text = item.chamberId
        holder.tvBricksCount.text = getCommaFormat(item.totalBricks)
        holder.tvTakenCount.text = getCommaFormat(item.totalTakenBricks)
        holder.tvReceived.text = getRupeesFormat(item.totalReceivedAmount)

        holder.itemView.setOnClickListener {
            listener.onChamberActionChanged(item)
        }
    }


    override fun getItemCount(): Int = list.size
}