package com.gk.bricks.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.gk.bricks.R
import com.gk.bricks.databinding.DialogConfirmationBinding

class ConfirmationDialog(
    private val activity: FragmentActivity,
    val title: String,
    val message: String,
    private val onConfirm: () -> Unit,
    private val onCancel: () -> Unit,
) : Dialog(activity) {

    private lateinit var binding: DialogConfirmationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogConfirmationBinding.inflate(
            layoutInflater,
            LinearLayoutCompat(context), false
        )


        setContentView(binding.root)
        window?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(context, R.color.light_grey))
        )

        binding.btnClose.setOnClickListener { view1 ->
            dismiss()
            onCancel.invoke()
        }
        binding.btnConfirm.setOnClickListener {
            dismiss()
            onConfirm.invoke()
        }

        binding.title.text = title
        binding.message.text = message

        adjustDialogWidth(activity, window, 1f)


    }

    fun adjustDialogWidth(context: Context, window: Window?, default: Float = 0.95f) {
        val width = (context.resources.displayMetrics.widthPixels * default)
        val height = (context.resources.displayMetrics.heightPixels * default)
        window?.setLayout(width.toInt(), height.toInt())
    }

}