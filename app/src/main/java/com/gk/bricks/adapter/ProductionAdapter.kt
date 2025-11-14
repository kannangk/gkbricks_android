package com.gk.bricks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gk.bricks.R
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.util.getCommaFormat
import java.text.SimpleDateFormat
import java.util.Locale

class ProductionAdapter(private val mContext: Context, private val list: List<BricksProduction>) :
    RecyclerView.Adapter<ProductionAdapter.ViewHolder>() {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvProduction: TextView = view.findViewById(R.id.tvProductionValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_production, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val formattedDate = formatter.format(item.workingDate)
        holder.tvDate.text = formattedDate
        holder.tvProduction.text = "${getCommaFormat(item.totalProduction)} ${mContext.getString(R.string.brick)}"
    }

    override fun getItemCount(): Int = list.size
}