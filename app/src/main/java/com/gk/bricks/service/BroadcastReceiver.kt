package com.gk.bricks.service

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import com.gk.bricks.util.*
import com.gk.bricks.util.Constants.ACTION_CONNECTIVITY_STATE_CHANGE
import com.gk.bricks.util.Constants.ACTION_SIM_STATE_CHANGED
import com.gk.bricks.util.Constants.BATTERY_CHARGING
import com.gk.bricks.util.Constants.BATTERY_NOT_CHARGING
import com.gk.bricks.util.Constants.DATE_CHANGE
import com.gk.bricks.util.Constants.NETWORK_CONNECTED
import com.gk.bricks.util.Constants.NETWORK_DISCONNECTED
import com.gk.bricks.util.Constants.TIME_TICKING
import com.gk.bricks.util.Constants.VOLUME_CHANGED_ACTION
import com.gk.bricks.util.NetworkUtil
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BroadcastReceiver(private val onBroadcastReceived: (String, Int?,Intent?) -> Unit) :
    BroadcastReceiver() {

    private var networkUtil: NetworkUtil = NetworkUtil()
    private var date = Date()
    private val dateFormat by lazy { SimpleDateFormat("yyMMdd", Locale.getDefault()) }

    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        val currentDate = Date()
        if (intent.action == Intent.ACTION_BATTERY_CHANGED) {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)

            onBroadcastReceived.invoke(deviceHealth.toString(), null,null)

            val batteryLevel = (level * 100 / scale.toFloat()).toInt()

            val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL

            if (isCharging) onBroadcastReceived.invoke(BATTERY_CHARGING, batteryLevel,null)
            else onBroadcastReceived.invoke(BATTERY_NOT_CHARGING, batteryLevel,null)
        } else if (ACTION_CONNECTIVITY_STATE_CHANGE == intent.action) {
            val isNetworkAvailable: Boolean = networkUtil.isNetworkAvailable(context)
            Log.d(TAG, "onReceive: $isNetworkAvailable")
            if (isNetworkAvailable) {
                onBroadcastReceived.invoke(NETWORK_CONNECTED, null,null)
            } else {
                onBroadcastReceived.invoke(NETWORK_DISCONNECTED, null,null)
            }
        } else if ((intent.action == VOLUME_CHANGED_ACTION )
        ) {
            onBroadcastReceived.invoke(VOLUME_CHANGED_ACTION, null,null)
        }else if ((intent.action == Intent.ACTION_TIME_TICK || intent.action == Intent.ACTION_TIME_CHANGED || intent.action == Intent.ACTION_TIMEZONE_CHANGED) && !isSameDay(
                currentDate
            )
        ) {
            onBroadcastReceived.invoke(DATE_CHANGE, null,null)
        } else if (intent.action == Intent.ACTION_TIME_TICK) {
            onBroadcastReceived.invoke(TIME_TICKING, null,null)
        }else if(intent.action == ACTION_SIM_STATE_CHANGED){
            onBroadcastReceived.invoke(intent.action.toString(), null ,intent)
        }
    }

    private fun isSameDay(currentDate: Date) =
        dateFormat.format(currentDate) == dateFormat.format(date)

    companion object {
        private const val TAG = "BroadcastReceiver"
    }

}
