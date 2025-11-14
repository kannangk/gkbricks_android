package com.gk.bricks.util

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.gk.bricks.R

object ViewAnimationUtils {

    enum class AnimationStatus{
        START,
        END
    }

    fun View.slideInLeftVisible(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (this.isVisible) return
        this.visibility = View.VISIBLE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideInLeftGone(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (!this.isVisible) return
        this.visibility = View.GONE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideInRightVisible(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (this.isVisible) return
        this.visibility = View.VISIBLE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_right)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideInRightGone(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (!this.isVisible) return
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_right)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideOutLeftVisible(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (this.isVisible) return
        this.visibility = View.VISIBLE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_out_left)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideOutLeftGone(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (!this.isVisible) return
        this.visibility = View.GONE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_out_left)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideOutRightVisible(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (this.isVisible) return
        this.visibility = View.VISIBLE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_out_right)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }

    fun View.slideOutRightGone(context : Context,animStatus : (AnimationStatus)-> Unit){
        if (!this.isVisible) return
        this.visibility = View.GONE
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_out_right)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animStatus(AnimationStatus.START)
            }

            override fun onAnimationEnd(animation: Animation?) {
                animStatus(AnimationStatus.END)
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        this.startAnimation(anim)
    }


}