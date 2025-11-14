package com.gk.bricks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gk.bricks.databinding.SettingListItemBinding
import com.gk.bricks.util.SettingData

class SettingADTR(private val settingList : ArrayList<SettingData>) : RecyclerView.Adapter<SettingADTR.SettingVH>() {
    class SettingVH(val binding : SettingListItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingVH {
       return SettingVH(SettingListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()= settingList.size

    override fun onBindViewHolder(holder: SettingVH, position: Int) {
        holder.binding.iconIv.setImageResource(settingList[position].icon)
        holder.binding.titleTV.text = settingList[position].title
    }
}