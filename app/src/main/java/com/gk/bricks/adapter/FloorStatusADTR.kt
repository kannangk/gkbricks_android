package com.gk.bricks.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gk.bricks.R
import com.gk.bricks.databinding.FloorItemLlBinding
import com.gk.bricks.util.Constants

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FloorStatusADTR(val list: ArrayList<Constants.FloorData>, private val mContext : Context) :
    RecyclerView.Adapter<FloorStatusADTR.FloorStatusViewHolder>() {

    data class Value(
        var selectedFloor: Int = 0,
        var nextFloor: Int = 0,
        val isAnimation: Boolean = false,
        val isAnimationCompleted: Boolean = false
    )

    companion object {
        const val TAG = "FloorStatusADTR"
    }

    private val floorLocalData: ArrayList<Value> = arrayListOf()
    private val isAnimating: Boolean = true
    private var previousSelectedFloor: Int? = null
    var job: Job? = null

    class FloorStatusViewHolder(val binding: FloorItemLlBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FloorStatusViewHolder {
        return FloorStatusViewHolder(
            FloorItemLlBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(
        holder: FloorStatusViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {

        holder.binding.groundFloorTV.text = list[position].floor
        val baseColor = Color.parseColor("#FFFFFF") // Replace with your base color
        val alphaColor = ColorUtils.setAlphaComponent(
            baseColor, (0.1f * 255).toInt()
        )
        floorLocalData.forEach {
            Log.d(
                TAG,
                "selectedFloor -> ${it.selectedFloor},nextFloor -> ${it.nextFloor}"
            )
        }
        if (floorLocalData.isNotEmpty() && position == floorLocalData.first().selectedFloor) {
            startAnimation(holder.binding.currentStateFloorTV,holder)
        }else{
            holder.binding.currentStateFloorTV.visibility = View.VISIBLE
        }

        if (floorLocalData.isNotEmpty() && position == floorLocalData.first().nextFloor) {
            goneAnimation(holder.binding.currentStateFloorTV,holder)
        }else{
            holder.binding.currentStateFloorTV.visibility = View.GONE
        }
        holder.binding.currentStateFloorTV.visibility =
            if (list[position].currentFloor == position) View.VISIBLE else View.GONE
        holder.binding.groundFloorTV.backgroundTintList = ColorStateList.valueOf(alphaColor)
        holder.binding.root.setOnClickListener {
            selectFloor(
                position,
                previousSelectedFloor ?: list[position].currentFloor,
                list[position].currentFloor
            )
            previousSelectedFloor = position
        }
        holder.binding.root.setOnLongClickListener {
            unSelectFloor(position)
            return@setOnLongClickListener true
        }
    }

    private fun unSelectFloor(floor: Int) {
        if (floorLocalData.map { it.selectedFloor }.contains(floor)) {
            floorLocalData.remove(floorLocalData.find { it.selectedFloor == floor })
            floorLocalData.sortBy { it.selectedFloor }
            Log.d(
                TAG,
                "floorLocalData -> ${floorLocalData.size}"
            )
//            list[floor].partiallySelectedFloor = false
        } else {
            return
        }
        notifyDataSetChanged()
    }

    private fun selectFloor(floor: Int, previousFloor: Int, current: Int) {
        val value = Value()
        if (floor == current) {
            return
        }
        if (!floorLocalData.map { it.selectedFloor }
                .contains(floor) && !floorLocalData.map { it.nextFloor }
                .contains(previousFloor)) {
            value.selectedFloor = floor
            value.nextFloor = current
            floorLocalData.add(value)
            floorLocalData.sortBy { it.selectedFloor }
        }
        list.forEachIndexed { index, data ->
            if (floor == index) {
//                list[index].partiallySelectedFloor = true
            }
        }
        notifyDataSetChanged()
    }

    private fun startAnimation(
        visibleItemView: TextView,
        holder: FloorStatusViewHolder,

    ) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            if (visibleItemView.isVisible) return@launch
            visibleItemView.visibility = View.VISIBLE
            val alphaColor = ColorUtils.setAlphaComponent(
                Color.parseColor("#FFFFFF"),
                (0.1f * 255).toInt()
            )
            val anim = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    Log.d(TAG, "onAnimationStart_visible_Start: true")
                }
                override fun onAnimationEnd(animation: Animation?) {
                    Log.d(TAG, "onAnimationEnd_visible_End: true")
                    holder.binding.groundFloorTV.backgroundTintList = ColorStateList.valueOf(alphaColor)
                    list.forEach {

                    }
                    if (floorLocalData.isNotEmpty()){
                        floorLocalData.removeAt(0)
                    }
                    notifyDataSetChanged()
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
            visibleItemView.startAnimation(anim)
        }
    }

    private fun goneAnimation(
        goneItem: TextView,
        holder: FloorStatusViewHolder,

    ) {
        //gone
        CoroutineScope(Main).launch {
            if (!goneItem.isVisible) return@launch
            val animGone =
                AnimationUtils.loadAnimation(mContext, R.anim.slide_out_right)
            animGone.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    Log.d(TAG, "onAnimationStart_GONE_Start: true")
                }
                override fun onAnimationEnd(animation: Animation?) {
                    Log.d(TAG, "onAnimationEnd_GONE_End: true")
                    holder.binding.currentStateFloorTV.visibility = View.GONE
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
            goneItem.startAnimation(animGone)
        }
    }

}