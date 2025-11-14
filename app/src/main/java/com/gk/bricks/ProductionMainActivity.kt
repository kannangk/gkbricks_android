package com.gk.bricks

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.gk.bricks.databinding.ActivityProductionBinding
import com.gk.bricks.managers.HotspotStateListener
import com.gk.bricks.service.BroadcastReceiver
import com.gk.bricks.util.AppSingleton.isHotspotEnable
import com.gk.bricks.util.AppSingleton.isWifiServerStatus
import com.gk.bricks.util.AppSingleton.onBatteryCharging
import com.gk.bricks.util.AppSingleton.onBatteryChargingStop
import com.gk.bricks.util.AppSingleton.onTickTime
import com.gk.bricks.util.AppSingleton.simSignalStrength
import com.gk.bricks.util.Constants.ACTION_SIM_STATE_CHANGED
import com.gk.bricks.util.Constants.BATTERY_CHARGING
import com.gk.bricks.util.Constants.BATTERY_NOT_CHARGING
import com.gk.bricks.util.SimStatus
import com.gk.bricks.util.WiFiServerStatus
import com.gk.bricks.util.mapSimStateIntToString
import com.gk.bricks.util.parseLteSignalLevelFromString
import com.gk.bricks.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductionMainActivity : BaseActivity() {
    private lateinit var binding: ActivityProductionBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var filter: IntentFilter
    private lateinit var receiver: BroadcastReceiver
    private var isUDPConnected: Boolean = false
    private lateinit var navOptions: NavOptions
    private var telephonyManager: TelephonyManager? = null
    private var backPressedTime: Long = 0
    private lateinit var toast: Toast


    private val timeTickReceiver = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_TIME_CHANGED,
                Intent.ACTION_DATE_CHANGED,
                Intent.ACTION_TIME_TICK,
                Intent.ACTION_TIMEZONE_CHANGED -> {
                    Log.d(TAG, "DateTimeChangeReceiver : Date or Time Changed")
                    onTickTime.postValue(true)
                    checkSimRelatedData()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver()
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            toast.cancel()
            finish() // closes all activities and exits app
            return
        } else {
            toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)
            toast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductionBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.status_bar)

        updateBottomNavView()
        initBroadcastReceiver()
        initFragmentTransitionAnim()
        observe()
        setupListeners()
        hotspotManagerListeners()
        viewModel.startHotspotRunnable()
        udpListeners()
        checkSimRelatedData()
        setupTelephonyManager()
        listenToPermissionResponse()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.destroyWifiAccessory()
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.isHotspotEnabled()) {
            viewModel.enableHotspot(this)
            viewModel.startHotspotRunnable()
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.disableHotspot(this)
    }

    private fun initFragmentTransitionAnim() {
        val navBuilder = NavOptions.Builder()
        navOptions = navBuilder.build()
    }

    private fun getHostFragment(): NavHostFragment {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as? NavHostFragment
        if (navHostFragment != null) {
            return navHostFragment
        } else {
            throw Exception("Fragment not found")
        }
    }


    private fun setupListeners() {
        binding.bottomNV.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    getNavController().navigate(R.id.homeFragment)
                    true
                }

                R.id.settings -> {
                    getNavController().navigate(R.id.settingsFragment)
                    true
                }

                R.id.history -> {
                    getNavController().navigate(R.id.alarmFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun setupTelephonyManager() {
        telephonyManager?.simState?.let { setSimUIState(mapSimStateIntToString(it)) }
    }

    private fun checkSimRelatedData() {
        telephonyManager?.simState?.let {
            setSimUIState(mapSimStateIntToString(it))
        }
    }

    private fun getNavController(): NavController {
        return getHostFragment().navController
    }

    private fun updateBottomNavView() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNV) { view, windowInsets ->
            val insets =
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
            view.setPadding(
                insets.left + 20,
                insets.top + 20,
                insets.right + 20,
                insets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }
        binding.bottomNV.visibility = View.VISIBLE
    }


    private fun udpListeners() {
        viewModel.listenToWifiLopConnection { isConnected ->
            Log.d(TAG, "udpListeners: listenToWifiLopConnection = $isConnected")
        }
        viewModel.openWifiAccessory { status ->
            openWifiAccessory(status)
        }
    }

    private fun openWifiAccessory(status: WiFiServerStatus) {
        if (status == WiFiServerStatus.CONNECTED) {
            isUDPConnected = true
            viewModel.startReadLopData { isReading, hexString ->
                if (isReading) {
                    connectCabinServer()
                }
            }
        }
    }

    private fun initBroadcastReceiver() {
        filter = IntentFilter()
        filter.addAction(Intent.ACTION_BATTERY_CHANGED)
        filter.addAction(Intent.ACTION_TIME_TICK)
        filter.addAction(Intent.ACTION_DATE_CHANGED)
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED)
        filter.addAction(Intent.ACTION_TIME_CHANGED)
        filter.addAction(ACTION_SIM_STATE_CHANGED)
    }

    private fun registerReceiver() {
        receiver = BroadcastReceiver { type, i, intent ->
            onBroadcastReceived(type, i, intent)
        }
        registerReceiver(receiver, filter, RECEIVER_EXPORTED)
        registerReceiver(timeTickReceiver, filter, RECEIVER_EXPORTED)
    }

    private fun observe() {
        viewModel.isAllPermissionsGranted.observe(this) {
//            viewModel.enableHotspot(this)
//            viewModel.startHotspotRunnable()
        }
    }

    private fun hotspotManagerListeners() {
        viewModel.hotspotManager().setHotspotStateListener(object : HotspotStateListener {
            override fun onHotspotEnabled() {
                Log.d(TAG, "HotspotStateListener-onHotspotEnabled: true")
            }

            override fun onHotspotDisabled() {
                Log.d(TAG, "HotspotStateListener-onHotspotDisabled: true")
            }

            override fun onHotspotRunnable() {
                Log.d(
                    TAG,
                    "HotspotStateListener-onHotspotRunnable: ${viewModel.isHotspotEnabled()} "
                )
//                if (!viewModel.isHotspotEnabled()) {
//                    Log.d(TAG, "run: isEnabling Hotspot")
//                    viewModel.enableHotspot(this@ProductionMainActivity)
//                }
                if (!isUDPConnected) {
                    viewModel.openWifiAccessory { status ->
                        openWifiAccessory(status)
                    }
                }
                isHotspotEnable.postValue(viewModel.isHotspotEnabled())
            }
        })
    }


    private fun isLiftConnectedWifiServer(): Boolean {
        return isWifiServerStatus.value == WiFiServerStatus.CONNECTED
    }

    private fun listenToPermissionResponse() {
        handleRequiredPermissions {
            viewModel.isAllPermissionsGranted.postValue(it)
        }
    }

    private fun onBroadcastReceived(type: String, i: Int?, intent: Intent?) {
        when (type) {
            BATTERY_CHARGING -> onBatteryCharging.postValue(i)
            BATTERY_NOT_CHARGING -> onBatteryChargingStop.postValue(i)
            ACTION_SIM_STATE_CHANGED -> {
                if (intent == null) return
                val simState = intent.getStringExtra("ss")
                Log.d(TAG, "onBroadcastReceived: $simState")
                simState?.let {
                    setSimUIState(it)
                }
            }
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

    private fun connectCabinServer() {
        if (!isLiftConnectedWifiServer()) {
            viewModel.listenToWifiServerConnection()
            viewModel.readDataFromCabin()
        }
    }


    companion object Companion {
        const val TAG = "main_activity"
    }
}