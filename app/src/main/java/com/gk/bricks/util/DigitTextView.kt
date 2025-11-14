package com.gk.bricks.util

import android.animation.Animator
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.gk.bricks.R
import java.util.Locale

class DigitTextView : FrameLayout {
    var currentTextView: TextView? = null
    private var nextTextView: TextView? = null

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    private fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.floor_counter, this)
        currentTextView = rootView.findViewById(R.id.currentTextView)
//        currentTextView!!.setTextColor(rootView.context.resources.getColor(R.color.app_primary))
        nextTextView = rootView.findViewById(R.id.nextTextView)

        nextTextView?.translationY = height.toFloat()
        setValue(0)
    }

    fun updateCurrentFloor(
        isDownCall: Boolean,
        progress: Float,
        totalFloors: Int,
    ) {
        val visiblePercentage =
            when (totalFloors) {
                2 -> {
                    if (progress > 0.50f) {
                        currentTextView!!.text = "G"
                        progress
                    } else {
                        currentTextView!!.text = "G"
                        progress
                    }
                }

                3 -> {
                    if (progress > 0.50f) {
                        currentTextView!!.text = "G"
                        (progress - 0.50f) / 0.50f
                    } else {
                        currentTextView!!.text = "1"
                        progress / 0.50f
                    }
                }

                4 -> {
                    if (progress > 0.66f) {
                        currentTextView!!.text = "G"
                        (progress - 0.66f) / 0.33f
                    } else if (progress > 0.33f) {
                        currentTextView!!.text = "1"
                        (progress - 0.33f) / 0.33f
                    } else {
                        currentTextView!!.text = "2"
                        progress / 0.33f
                    }
                }

                else -> {
                    1f
                }
            }
        val oldValue =
            if (currentTextView!!.text.toString() == "G") 0 else currentTextView!!.text.toString()
                .toInt()

        if (isDownCall) {

        } else {
            nextTextView!!.text = String.format(Locale.getDefault(), "%d", oldValue + 1)
            currentTextView!!.animate()
                .translationY(height.toFloat() - (height.toFloat() * visiblePercentage))
                .setDuration(
                    SPEED_ANIMATION_DURATION.toLong()
                ).start()

            val tvTextHeight = nextTextView!!.height.toFloat()
            /* nextTextView!!.translationY =
                 (tvTextHeight - (tvTextHeight * visiblePercentage))      */       // 1
            nextTextView!!.animate().translationY(-((tvTextHeight * visiblePercentage)))   // 0
                .setDuration(SPEED_ANIMATION_DURATION.toLong())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationEnd(animation: Animator) {
                        /*currentTextView!!.text =
                            String.format(Locale.getDefault(), "%d", oldValue + 1)
                        currentTextView!!.translationY = 0f*/
                        /* currentTextView!!.text = if (currentFloor == 0) "G" else
                             String.format(Locale.getDefault(), "%d", currentFloor)*/
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                }).start()
        }

    }

    fun setOldValue(oldVal: Int){
        currentTextView!!.text =
            String.format(Locale.getDefault(), "%d", oldVal)
    }


    fun setValue(desiredValue: Int) {
        if (currentTextView!!.text == null || currentTextView!!.text.isEmpty()) {
            if (desiredValue == 0)
                currentTextView!!.text = "G"
            else
                currentTextView!!.text = String.format(Locale.getDefault(), "%d", desiredValue)
        }
        val oldValue =
            if (currentTextView!!.text.toString() == "G") 0 else currentTextView!!.text.toString()
                .toInt()
        if (oldValue > desiredValue) {
            nextTextView!!.text = if ((oldValue - 1) == 0) "G" else String.format(
                Locale.getDefault(),
                "%d",
                oldValue - 1
            )
            currentTextView!!.animate().translationY(-height.toFloat()).setDuration(
                ANIMATION_DURATION.toLong()
            ).start()
            nextTextView!!.translationY = nextTextView!!.height.toFloat()
            nextTextView!!.animate().translationY(0f).setDuration(ANIMATION_DURATION.toLong())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationEnd(animation: Animator) {
                        currentTextView!!.text = if ((oldValue - 1) == 0) "G" else
                            String.format(Locale.getDefault(), "%d", oldValue - 1)
                        currentTextView!!.translationY = 0f
                        if (oldValue - 1 != desiredValue) {
                            setValue(desiredValue)
                        }
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                }).start()
        } else if (oldValue < desiredValue) {
            nextTextView!!.text = String.format(Locale.getDefault(), "%d", oldValue + 1)
            currentTextView!!.animate().translationY(height.toFloat()).setDuration(
                ANIMATION_DURATION.toLong()
            ).start()
            nextTextView!!.translationY = -nextTextView!!.height.toFloat()
            nextTextView!!.animate().translationY(0f).setDuration(ANIMATION_DURATION.toLong())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {}
                    override fun onAnimationEnd(animation: Animator) {
                        currentTextView!!.text =
                            String.format(Locale.getDefault(), "%d", oldValue + 1)
                        currentTextView!!.translationY = 0f
                        if (oldValue + 1 != desiredValue) {
                            setValue(desiredValue)
                        }
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                }).start()
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 100
        private const val SPEED_ANIMATION_DURATION = 0
    }
}