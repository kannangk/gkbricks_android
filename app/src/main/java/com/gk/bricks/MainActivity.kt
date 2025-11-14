package com.gk.bricks

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.gk.bricks.databinding.ActivityMainBinding
import com.gk.bricks.util.AppSingleton.simSignalStrength
import com.gk.bricks.util.LocaleManager
import com.gk.bricks.util.SimStatus
import com.gk.bricks.util.mapSimStateIntToString
import com.gk.bricks.util.parseLteSignalLevelFromString
import com.gk.bricks.viewmodel.MainViewModel
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var telephonyManager: TelephonyManager? = null
    private var then: Long = 0
    private var isAuthorized = false

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.status_bar)
        observe()
        checkSimRelatedData()
        setupTelephonyManager()
        listenToPermissionResponse()
        onClickListener()
        initCheckUser()
    }

    private fun onClickListener() {
        binding.productionView.setOnClickListener {
            if (isAuthorized) {
                val intent = Intent(this, ProductionMainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.employeeView.setOnClickListener {
            if (isAuthorized) {
                val intent = Intent(this, EmployeeMainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.deliveryView.setOnClickListener {
            if (isAuthorized) {
                val intent = Intent(this, DeliveryMainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.logoIV.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                then = System.currentTimeMillis()
            } else if (event.action == MotionEvent.ACTION_UP) {
                if ((System.currentTimeMillis() - then) > 10000) {
                    checkUser()
                    return@setOnTouchListener true
                } else if ((System.currentTimeMillis() - then) > 500) {
                    showLanguagePopup()
                }
            }
            return@setOnTouchListener true
        }
    }

    private fun initCheckUser() {
        GlobalScope.launch {
            val parseUser = ParseUser.getCurrentUser()
            Log.d("ELITE_PARSE", "checkUser: $parseUser")
            if (parseUser != null) {
                if (!parseUser.isAuthenticated) {
                    isAuthorized = false
                    runOnUiThread {
                        binding.pbLoading.visibility = View.GONE
                        binding.tvVersion.text = "Please Login"
                    }
                } else {
                    isAuthorized = true
                    runOnUiThread {
                        binding.pbLoading.visibility = View.GONE
                        binding.tvVersion.text = "www.gkbricks.com"
                    }
                }
            } else {
                isAuthorized = false
                runOnUiThread {
                    binding.pbLoading.visibility = View.GONE
                    binding.tvVersion.text = "Please Login"
                }
            }
        }
    }

    private fun checkUser() {
        GlobalScope.launch {
            runOnUiThread {
                binding.pbLoading.visibility = View.VISIBLE
                binding.tvVersion.text = "Loading..."
            }
            val parseUser = ParseUser.getCurrentUser()
            Log.d("GK_BRICKS", "checkUser: $parseUser")
            if (parseUser != null) {
                if (!parseUser.isAuthenticated) {
                    signIn()
                } else {
                    isAuthorized = true
                    runOnUiThread {
                        binding.pbLoading.visibility = View.GONE
                        binding.tvVersion.text = "www.gkbricks.com"
                    }
                }
            } else {
                signUpParse()
            }
        }
    }

    private fun signIn() {
        GlobalScope.launch(IO) {
            ParseUser.logInInBackground(
                "gkbricks_pkm",
                "gkbricks_pkm@123"
            ) { user, e ->
                Log.d("GK_BRICKS", "signIn: $e")
                if (user != null) {
                    isAuthorized = true
                    runOnUiThread {
                        binding.pbLoading.visibility = View.GONE
                        binding.tvVersion.text = "www.gkbricks.com"
                    }
                } else if (e != null) {
                    if (e.code == 101) signUpParse()
                }
            }
        }
    }

    private fun signUpParse() {
        GlobalScope.launch(IO) {
            val user = ParseUser()
            user.username = "gkbricks_pkm"
            user.setPassword("gkbricks_pkm@123")
            user.signUpInBackground { e ->
                if (e == null) {
                    isAuthorized = true
                    runOnUiThread {
                        binding.pbLoading.visibility = View.GONE
                        binding.tvVersion.text = "www.gkbricks.com"
                    }
                } else {
                    Log.d("GK_BRICKS_PARSE_ERROR", e.code.toString())
                    if (e.code == 202 || e.code == 208) signIn()
                }
            }
        }
    }

    private fun showLanguagePopup() {
        val languages = arrayOf("English", "தமிழ்")
        val langCodes = arrayOf("en", "ta")

        val currentLang = LocaleManager.getLanguage(this)
        val checkedItem = langCodes.indexOf(currentLang).takeIf { it >= 0 } ?: 0

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Language")
        builder.setSingleChoiceItems(languages, checkedItem) { dialog, which ->
            if (langCodes[which] != currentLang) {
                LocaleManager.setLocale(this, langCodes[which])
                recreate() // Reload the UI with new language
            }
            dialog.dismiss()
        }
        builder.setNegativeButton(android.R.string.cancel, null)
        builder.show()
    }


    private fun setupTelephonyManager() {
        telephonyManager?.simState?.let { setSimUIState(mapSimStateIntToString(it)) }
    }

    private fun checkSimRelatedData() {
        telephonyManager?.simState?.let {
            setSimUIState(mapSimStateIntToString(it))
        }
    }


    private fun observe() {
        viewModel.isAllPermissionsGranted.observe(this) {

        }
    }

    private fun listenToPermissionResponse() {
        handleRequiredPermissions {
            viewModel.isAllPermissionsGranted.postValue(it)
        }
    }


    private fun setSimUIState(simState: String) {
        telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        when (SimStatus.valueOf(simState)) {
            SimStatus.ABSENT -> {
                Log.d(TAG, "SimStateReceiver: SIM card removed")
                simSignalStrength.postValue(null)
            }

            SimStatus.READY -> {
                val signalLevel =
                    parseLteSignalLevelFromString(telephonyManager?.signalStrength.toString())
                Log.d(TAG, "SimStateReceiver: SIM card ready with signal level: $signalLevel")
                simSignalStrength.postValue(signalLevel)
            }

            SimStatus.LOCKED -> {
                Log.d(TAG, "SimStateReceiver: SIM card locked")
                simSignalStrength.postValue(null)
            }

            SimStatus.LOADED -> {
                val signalLevel =
                    parseLteSignalLevelFromString(telephonyManager?.signalStrength.toString())
                Log.d(TAG, "SimStateReceiver: IM card loaded with signal level: $signalLevel")
                simSignalStrength.postValue(signalLevel)
            }

            SimStatus.UNKNOWN -> {
                Log.d(TAG, "SimStateReceiver: SIM card unknown")
                simSignalStrength.postValue(null)
            }
        }

    }


    companion object Companion {
        const val TAG = "init_activity"
    }
}