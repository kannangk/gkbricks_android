package com.gk.bricks.fragment.production

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.gk.bricks.ProductionMainActivity
import com.gk.bricks.R
import com.gk.bricks.databinding.FragmentHomeBinding
import com.gk.bricks.fragment.BaseFragment
import com.gk.bricks.util.AppSingleton
import com.gk.bricks.util.AppSingleton.onBatteryCharging
import com.gk.bricks.util.AppSingleton.onBatteryChargingStop
import com.gk.bricks.util.AppSingleton.onTickTime
import com.gk.bricks.util.AppSingleton.sendSocketQuery
import com.gk.bricks.util.AppSingleton.simSignalStrength
import com.gk.bricks.util.AppSingleton.socketReceivedData
import com.gk.bricks.util.AppSingleton.wifiConnectionStatus
import com.gk.bricks.util.CabinSendConstants.sendCallBookingPacket
import com.gk.bricks.util.ServerDataListeners
import com.gk.bricks.util.ViewAnimationUtils
import com.gk.bricks.util.ViewAnimationUtils.slideInLeftVisible
import com.gk.bricks.util.ViewAnimationUtils.slideInRightVisible
import com.gk.bricks.util.ViewAnimationUtils.slideOutLeftGone
import com.gk.bricks.util.ViewAnimationUtils.slideOutRightGone
import com.gk.bricks.util.WiFiServerStatus
import com.gk.bricks.viewmodel.MainNavViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

@AndroidEntryPoint
class HomeFragment : BaseFragment(), ServerDataListeners {

    private lateinit var mContext: Context
    private lateinit var binding: FragmentHomeBinding

    private var oldFloor: Int = 0
    private var currentFloor: Int = 0
    private var isRunningFloorAnimation: Boolean = false
    private var upcomingFloor = ArrayList<Int>()
    private var currentCount = 0

    private val mainNavViewModel by lazy {
        ViewModelProvider(this)[MainNavViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = mainNavViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewWorker()
    }

    override fun onBatteryStateChanged(batteryState: Int) {
        Log.d(ProductionMainActivity.TAG, "onBatteryStateChanged: $batteryState")
        val drawable = ContextCompat.getDrawable(
            binding.root.context,
            mainNavViewModel.setBatteryIconStatus(batteryState)
        )

    }

    private fun onViewWorker() {
        onObserveListeners()
        mainNavViewModel.setOnServerDataListeners(this)
        setOnClickListeners()
        setOnLongClickListener()
    }

    private fun onObserveListeners() {
        onBatteryCharging.observe(viewLifecycleOwner) { i ->
            if (i == null) return@observe
            binding.chargingIV.visibility = View.VISIBLE
            setupIntelBattery(i)
        }

        onBatteryChargingStop.observe(viewLifecycleOwner) { i ->
            if (i == null) return@observe
            binding.chargingIV.visibility = View.GONE
            setupIntelBattery(i)
        }

        onTickTime.observe(viewLifecycleOwner) {
            if (!it) return@observe
        }

        simSignalStrength.observe(viewLifecycleOwner) { signal ->
            mainNavViewModel.showSimSignalStrength(signal, binding.simSignalIV)
        }

        wifiConnectionStatus.observe(viewLifecycleOwner) {
            Log.d(ProductionMainActivity.TAG, "wifiConnectionStatus : $it")
            if (!mainNavViewModel.isHotspotEnabled()) {
                binding.connectedIV.setImageResource(R.drawable.hotspot_disabled)
                binding.connectedTV.text = "Hotspot Enabling.."
                val color =
                    ContextCompat.getColor(mContext, R.color.red) // get color from color file
                binding.ivImgStatus.setColorFilter(color, PorterDuff.Mode.SRC_IN)

            } else {
                binding.connectionLAW.visibility =
                    if (it == WiFiServerStatus.SERVER_CONNECTED) View.INVISIBLE else View.VISIBLE
                binding.connectedIV.visibility =
                    if (it == WiFiServerStatus.SERVER_CONNECTED) View.VISIBLE else View.INVISIBLE
                binding.connectedIV.setImageResource(R.drawable.connected_ic)
                binding.connectedTV.text = mainNavViewModel.getWifiCurrentStatus(it)
                if (it == WiFiServerStatus.SERVER_CONNECTED) {
                    val color =
                        ContextCompat.getColor(mContext, R.color.gold) // get color from color file
                    binding.ivImgStatus.setColorFilter(
                        color,
                        PorterDuff.Mode.SRC_IN
                    )
                } else {
                    val color =
                        ContextCompat.getColor(mContext, R.color.red) // get color from color file
                    binding.ivImgStatus.setColorFilter(
                        color,
                        PorterDuff.Mode.SRC_IN
                    )
                }

            }
        }

        AppSingleton.lopReceivedData.observe(viewLifecycleOwner) { data ->
            val hexString = data.joinToString(", ") { String.format("0x%02X", it) }
            appendTextToLogcat("CABIN_RECEIVED_DATA :[$hexString] \n\n")
            logcatAutoScrollToLast()
        }

        sendSocketQuery.observe(viewLifecycleOwner) {
            if (it != null) {
                val hexString = it.joinToString(", ") { value -> String.format("0x%02X", value) }
                appendTextToLogcat("SEND_QUERY_TO_SOCKET :[$hexString] \n\n")
            }
        }

        socketReceivedData.observe(viewLifecycleOwner) { data ->
            val value = ((data[2].toInt() and 0xFF) shl 8) or (data[1].toInt() and 0xFF)
            val lastValue = ((data[4].toInt() and 0xFF) shl 8) or (data[3].toInt() and 0xFF)
            Log.d(TAG, "NIBAV_WIFI_SHAFT count: $value")
            val hexString = data.joinToString(", ") { String.format("0x%02X", it) }
            appendTextToLogcat("Recev data:[$hexString] \n\n")
            logcatAutoScrollToLast()
//            mainNavViewModel.socketDataObserver(data)
            GlobalScope.launch(Dispatchers.Main) {
                if (abs(value - currentCount) > 1) {
                    binding.digitTextView.setOldValue(value)
                }
                binding.digitTextView.setValue(value)
                binding.tvTotalBricks.text = "${(value * 2)}"
                currentCount = value
                binding.tvLastBricksCountValue.text = "${(lastValue * 2)}"
            }
        }
    }

    private fun logcatAutoScrollToLast() {
        binding.logcatTV.post {
            val scrollAmount = binding.logcatTV.layout?.getLineTop(binding.logcatTV.lineCount) ?: 0
            if (scrollAmount > binding.logcatTV.height) {
                binding.logcatTV.scrollTo(0, scrollAmount - binding.logcatTV.height)
            }
        }
    }

    private fun setOnClickListeners() {

        binding.logcatLTV.setOnClickListener {
            binding.logcatTV.visibility =
                if (binding.logcatTV.isVisible) View.GONE else View.VISIBLE
        }

        binding.groundFloorMCV.setOnClickListener {
            selectFloor(0) //changed 0 to 1
            oldFloor = 0
        }
        binding.firstFloorMCV.setOnClickListener {
            selectFloor(1)
            oldFloor = 1
        }
        binding.secFloorMCV.setOnClickListener {
            selectFloor(2)
            oldFloor = 2
        }
        binding.thirdFloorMCV.setOnClickListener {
            selectFloor(3)
            oldFloor = 3
        }
        binding.forthFloorMCV.setOnClickListener {
            selectFloor(4)
            oldFloor = 4
        }

    }

    private fun setOnLongClickListener() {
        binding.logcatLTV.setOnLongClickListener {
            binding.logcatTV.text = ""
            true
        }

        binding.groundFloorMCV.setOnLongClickListener {
            removeUpcomingFloor(0) //changed 0 to 1
            true
        }
        binding.firstFloorMCV.setOnLongClickListener {
            removeUpcomingFloor(1) //changed 1 to 2
            true
        }
        binding.secFloorMCV.setOnLongClickListener {
            removeUpcomingFloor(2) //changed 2 to 3
            true
        }
        binding.thirdFloorMCV.setOnLongClickListener {
            removeUpcomingFloor(3) //changed 3 to 4
            true
        }
        binding.forthFloorMCV.setOnLongClickListener {
            removeUpcomingFloor(4) //changed 4 to 5
            true
        }
    }

    private fun upcomingFloorView(): ArrayList<TextView> {
        return arrayListOf(
            binding.groundFloorTV,
            binding.firstFloorTV,
            binding.secFloorTV,
            binding.thirdFloorTV,
            binding.forthFloorTV
        )
    }

    private fun currentFloorView(): ArrayList<TextView> {
        return arrayListOf(
            binding.groundFloorTVBG,
            binding.firstFloorTVBG,
            binding.secFloorTVBG,
            binding.thirdFloorTVBG,
            binding.forthFloorTVBG
        )
    }

    private fun appendTextToLogcat(data: String) {
        val timestamp = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        binding.logcatTV.append("[$timestamp] $data")
    }

//    private fun hotspotIconHandler(b: Boolean) {
//        if (!b){
//            binding.connectedIV.setImageResource(R.drawable.hotspot_disabled)
//            binding.connectedTV.text = "Hotspot Enabling.."
//        }else{
//            if ()
//            binding.connectedIV.setImageResource(R.drawable.connected_ic)
//        }
//    }


    private fun startFloorAnimation() {
        if (isRunningFloorAnimation && upcomingFloor.isEmpty()) return
        isRunningFloorAnimation = true
        if (currentFloor < upcomingFloor.first()) {
            currentFloorView()[currentFloor].slideOutRightGone(mContext) {}
            currentFloorView()[upcomingFloor.first()].slideInLeftVisible(mContext) {
                if (it == ViewAnimationUtils.AnimationStatus.END) {
                    currentFloor = upcomingFloor.first()
                    val baseColor = ContextCompat.getColor(
                        mContext,
                        R.color.select_floor_color
                    )// Replace with your base color
                    val alphaColor = ColorUtils.setAlphaComponent(
                        baseColor,
                        (0.1f * 255).toInt()
                    )
                    upcomingFloorView()[upcomingFloor.first()].backgroundTintList =
                        ColorStateList.valueOf(alphaColor)
                    upcomingFloor.remove(upcomingFloor.first())
                    isRunningFloorAnimation = false
                }
            }
        } else {
            currentFloorView()[currentFloor].slideOutLeftGone(mContext) {}
            currentFloorView()[upcomingFloor.first()].slideInRightVisible(mContext) {
                if (it == ViewAnimationUtils.AnimationStatus.END) {
                    currentFloor = upcomingFloor.first()
                    val baseColor = ContextCompat.getColor(
                        mContext,
                        R.color.select_floor_color
                    ) // Replace with your base color
                    val alphaColor = ColorUtils.setAlphaComponent(
                        baseColor,
                        (0.1f * 255).toInt()
                    )
                    upcomingFloorView()[upcomingFloor.first()].backgroundTintList =
                        ColorStateList.valueOf(alphaColor)
                    upcomingFloor.remove(upcomingFloor.first())
                    isRunningFloorAnimation = false
                }
            }
        }
    }


    private fun selectFloor(floor: Int) {
        if (floor == currentFloor || upcomingFloor.contains(floor) || upcomingFloor.size >= 1) return
        upcomingFloor.add(floor)
        val downFloors = upcomingFloor.filter { it < currentFloor }.sortedDescending()
        val upFloors = upcomingFloor.filter { it > currentFloor }.sorted()
        val updatedList = arrayListOf<Int>()
        updatedList.addAll(downFloors)
        updatedList.addAll(upFloors)
        upcomingFloor.clear()
        upcomingFloor.addAll(updatedList)
        Log.d("LIFT", "Upcoming Floors: $upcomingFloor")
        // Optional: Visual update
        val baseColor = ContextCompat.getColor(mContext, R.color.select_floor_color)
        val alphaColor = ColorUtils.setAlphaComponent(baseColor, (0.5f * 255).toInt())
        upcomingFloorView()[floor].backgroundTintList = ColorStateList.valueOf(alphaColor)
        mainNavViewModel.sendWifiData(floor.sendCallBookingPacket())
        startFloorAnimation()
    }

    private fun removeUpcomingFloor(floor: Int) {
        if (currentFloor == floor) return
        if (upcomingFloor.contains(floor)) {
            upcomingFloor.remove(floor)
            val baseColor = ContextCompat.getColor(
                mContext,
                R.color.select_floor_color
            ) // Replace with your base color
            val alphaColor = ColorUtils.setAlphaComponent(
                baseColor,
                (0.1f * 255).toInt()
            )
            upcomingFloorView()[floor].backgroundTintList = ColorStateList.valueOf(alphaColor)
        }
    }


    private fun setupIntelBattery(percentage: Int?) {
        binding.chargingPercentageTV.text = getString(R.string.charging_percentage, percentage ?: 0)
        binding.chargerIV.setImageResource(mainNavViewModel.setBatteryIconStatus(percentage))
    }

    companion object {
        const val TAG = "home_fragment"
    }


}