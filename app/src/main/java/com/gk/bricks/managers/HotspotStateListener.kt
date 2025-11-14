package com.gk.bricks.managers

interface HotspotStateListener {
    fun onHotspotEnabled()
    fun onHotspotDisabled()
    fun onHotspotRunnable()
}
