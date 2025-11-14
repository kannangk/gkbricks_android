package com.gk.bricks

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.gk.bricks.databinding.ActivityDeliveryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliveryMainActivity : BaseActivity() {
    private lateinit var binding: ActivityDeliveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.status_bar)

    }

}