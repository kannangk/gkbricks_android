package com.gk.bricks

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.gk.bricks.databinding.ActivityEmployeeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeMainActivity : BaseActivity() {
    private lateinit var binding: ActivityEmployeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.status_bar)

    }

}