package com.gk.bricks.managers

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.io.File
import java.lang.reflect.Proxy

class HotspotManager(private val context: Context) {

    companion object{
        private const val TAG = "HotspotManager"
    }

    private var isHotspotHandlerRunning : Boolean = false
    private var hotspotStateListener: HotspotStateListener? = null


    fun setHotspotStateListener(listener: HotspotStateListener) {
        this.hotspotStateListener = listener
    }

    private val hotspotHandler = Handler(Looper.getMainLooper())

    private val hotspotRunnable = object : Runnable {
        override fun run() {
            Log.d(TAG, "run: isRunning")
            hotspotStateListener?.onHotspotRunnable()
            isHotspotHandlerRunning = true
            hotspotHandler.postDelayed(this, 5000) // run again after 10 sec
        }
    }

    fun startHotspotRunnable(){
        Log.d(TAG, "startHotspotRunnable: startHotspotRunnable")
        if (!isHotspotHandlerRunning){
            hotspotHandler.post(hotspotRunnable)
        }
    }

    fun removeHotspotRunnable(){
        hotspotHandler.removeCallbacks(hotspotRunnable)
        isHotspotHandlerRunning = false
    }

    fun isHotspotHandlerRunning() : Boolean{
        return isHotspotHandlerRunning
    }


    @SuppressLint("PrivateApi")
    fun enableHotspot(context: Context) {
        try {
            val tetheringManagerClass = Class.forName("android.net.TetheringManager")
            val tetheringManager = context.getSystemService(tetheringManagerClass)

            if (tetheringManager != null) {

                // Dump all methods for debugging
                val allMethods = tetheringManagerClass.declaredMethods
                allMethods.forEach { method ->
                    Log.d(TAG, "Method: ${method.name} with params: ${method.parameterTypes.joinToString { it.name }}")
                }

                for (method in allMethods) {
                    if (method.name == "startTethering") {
                        val params = method.parameterTypes

                        Log.d(TAG, "Found startTethering with params: ${params.joinToString { it.name }}")

                        // Your device uses: TetheringRequest, Executor, StartTetheringCallback
                        if (params.size == 3 &&
                            params[0].name.contains("TetheringRequest") &&
                            params[1].name.contains("Executor") &&
                            params[2].name.contains("StartTetheringCallback")
                        ) {

                            val builderClass = Class.forName("android.net.TetheringManager\$TetheringRequest\$Builder")

                            // Print available constructors
                            val constructors = builderClass.declaredConstructors
                            constructors.forEach { constructor ->
                                Log.d(TAG, "Builder constructor: ${constructor.name} with params: ${constructor.parameterTypes.joinToString { it.name }}")
                            }

                            // Use constructor with int param (0 = TETHERING_WIFI)
                            val constructor = builderClass.getDeclaredConstructor(Int::class.javaPrimitiveType)
                            val builder = constructor.newInstance(0)
                            val tetheringRequest = builderClass.getDeclaredMethod("build").invoke(builder)

                            val callbackClass = tetheringManagerClass.declaredClasses.firstOrNull {
                                it.simpleName == "StartTetheringCallback"
                            } ?: run {
                                Log.e(TAG, "StartTetheringCallback class not found")
                                return
                            }

                            val proxy = Proxy.newProxyInstance(
                                callbackClass.classLoader,
                                arrayOf(callbackClass)
                            ) { _, method2, _ ->
                                when (method2.name) {
                                    "onTetheringStarted" -> {
                                        Log.d(TAG, "Hotspot started successfully")
                                        hotspotStateListener?.onHotspotEnabled()
                                    }
                                    "onTetheringFailed" -> {
                                        Log.e(TAG, "Failed to start hotspot")
                                    }
                                }
                                null
                            }

                            // Get main executor (API 28+)
                            val mainExecutor = context.mainExecutor

                            method.invoke(tetheringManager, tetheringRequest, mainExecutor, proxy)
                            Log.d(TAG, "Invoked startTethering with TetheringRequest (3 params)")
                            return
                        } else {
                            Log.e(TAG, "Unsupported startTethering params: ${params.joinToString { it.name }}")
                        }
                    }
                }

                Log.e(TAG, "startTethering method not found or unsupported on this device")
            } else {
                Log.e(TAG, "TetheringManager not available on this device")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error enabling hotspot: ${e.message}")
            e.printStackTrace()
        }
    }

    // Check if hotspot is enabled
    @SuppressLint("PrivateApi")
    fun isHotspotEnabled(): Boolean {
        return try {
            val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val method = wifiManager.javaClass.getDeclaredMethod("isWifiApEnabled")
            method.isAccessible = true
            method.invoke(wifiManager) as Boolean
        } catch (e: Exception) {
            Log.e(TAG, "Error checking hotspot state: ${e.message}")
            false
        }
    }

    @SuppressLint("PrivateApi")
    fun disableHotspot(context: Context) {
        try {
            val tetheringManagerClass = Class.forName("android.net.TetheringManager")
            val tetheringManager = context.getSystemService(tetheringManagerClass)

            if (tetheringManager != null) {
                // Try to call stopTethering(int tetherType)
                val stopMethod = tetheringManagerClass.getDeclaredMethod("stopTethering", Int::class.javaPrimitiveType)
                stopMethod.isAccessible = true
                stopMethod.invoke(tetheringManager, 0) // 0 = TETHERING_WIFI

                Log.d(TAG, "Hotspot stopped successfully")
                hotspotStateListener?.onHotspotDisabled()
            } else {
                Log.e(TAG, "TetheringManager not available on this device")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error disabling hotspot: ${e.message}")
            e.printStackTrace()

            // Optional fallback for rooted device
            try {
                Runtime.getRuntime().exec("su -c svc wifi set-hotspot disabled")
                Log.d(TAG, "Fallback: hotspot disabled using root command")
                hotspotStateListener?.onHotspotDisabled()
            } catch (e2: Exception) {
                Log.e(TAG, "Fallback root disable failed: ${e2.message}")
            }
        }
    }

}
