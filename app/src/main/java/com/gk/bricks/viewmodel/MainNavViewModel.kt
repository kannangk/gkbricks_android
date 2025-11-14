package com.gk.bricks.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.gk.bricks.R
import com.gk.bricks.datasource.firebase.FirebaseInterface
import com.gk.bricks.managers.HotspotManager
import com.gk.bricks.model.ProductionModel
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.model.parse.BricksChamberLoadingLogs
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.model.parse.BricksUnloadingLogs
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.model.parse.VendorPaidLog
import com.gk.bricks.util.Constants.COMPANY_NAME
import com.gk.bricks.util.ServerDataListeners
import com.gk.bricks.util.SettingData
import com.gk.bricks.util.WiFiServerStatus
import com.gk.bricks.wifi.WifiServerInterface
import com.parse.ParseQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject
import kotlin.invoke


@HiltViewModel
class MainNavViewModel @Inject constructor(
    private val app: Application,
    private val wifiServerInterface: WifiServerInterface,
    private val firebaseDatabase: FirebaseInterface,
    private val hotspotManager: HotspotManager
) : BaseViewModel(app) {

    companion object {
        const val TAG = "main_nav_view_model"
    }

    private var serverDataListeners: ServerDataListeners? = null

    fun setOnServerDataListeners(serverData: ServerDataListeners) {
        serverDataListeners = serverData
    }

    fun isHotspotEnabled(): Boolean {
        return hotspotManager.isHotspotEnabled()
    }

    fun socketDataObserver(data: ByteArray) {
        if (data[5].toInt() == 1) {
            serverDataListeners?.onBatteryStateChanged(data[6].toInt())
        }
    }


    fun getAllProductionList(context: Context,dataAvailableListener: (List<BricksProduction>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksProduction> = ParseQuery.getQuery(BricksProduction::class.java)
                query.whereEqualTo(BricksProduction.KEY_COMPANY_NAME, COMPANY_NAME)
                query.orderByDescending(BricksProduction.KEY_WORKING_DATE)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksProduction_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksProduction_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksProduction_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getEmployee(empId: String, dataAvailableListener: (List<Employee>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<Employee> = ParseQuery.getQuery(Employee::class.java)
                query.whereEqualTo(Employee.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(Employee.KEY_EMP_ID, empId)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_Employee_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_Employee_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_Employee_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getEmployeeList(context: Context,dataAvailableListener: (List<Employee>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<Employee> = ParseQuery.getQuery(Employee::class.java)
                query.whereEqualTo(Employee.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(Employee.KEY_IS_BLOCKED, false)
                query.orderByAscending("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_Employee_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_Employee_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_Employee_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getAllEmployeeList(context: Context,dataAvailableListener: (List<Employee>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<Employee> = ParseQuery.getQuery(Employee::class.java)
                query.whereEqualTo(Employee.KEY_COMPANY_NAME, COMPANY_NAME)
                query.orderByDescending("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_Employee_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_Employee_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_Employee_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }


    fun getEmployeeWorkLogUsingDate(date: Date,dataAvailableListener: (List<EmployeeWorkLog>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<EmployeeWorkLog> = ParseQuery.getQuery(EmployeeWorkLog::class.java)
                query.whereEqualTo(EmployeeWorkLog.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(EmployeeWorkLog.KEY_WORK_DATE, date)
                query.whereEqualTo(EmployeeWorkLog.KEY_IS_PAYABLE, false)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getEmployeeWorkLogUsingEmpId(empId: String,dataAvailableListener: (List<EmployeeWorkLog>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<EmployeeWorkLog> = ParseQuery.getQuery(EmployeeWorkLog::class.java)
                query.whereEqualTo(EmployeeWorkLog.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(EmployeeWorkLog.KEY_EMP_ID, empId)
                query.addDescendingOrder(EmployeeWorkLog.KEY_WORK_DATE)
                query.addDescendingOrder("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_EmployeeWorkLog_GET", results.size.toString())
//                        var allWorkData = listOf<EmployeeWorkLog>()
                        var totalAmount = 0
                        results.reverse()
                        results.forEach { workLog ->
                            if(!workLog.isPaid && !workLog.isPayable){
                                totalAmount = totalAmount+workLog.empSalary
//                                Log.d("GKBRICKS_totalAmount", totalAmount.toString())
                            }
                            workLog.totalAmount = totalAmount
                        }
                        results.reverse()
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }


    fun getBricksChamberLoadingList(context: Context,dataAvailableListener: (List<BricksChamberLoading>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksChamberLoading> = ParseQuery.getQuery(BricksChamberLoading::class.java)
                query.whereEqualTo(BricksChamberLoading.KEY_COMPANY_NAME, COMPANY_NAME)
                query.orderByAscending(BricksChamberLoading.KEY_IS_COMPLETED)
                query.addDescendingOrder(BricksChamberLoading.KEY_CHAMBER_CREATE_DATE)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getBricksChamberCompletedList(context: Context,dataAvailableListener: (List<BricksChamberLoading>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksChamberLoading> = ParseQuery.getQuery(BricksChamberLoading::class.java)
                query.whereEqualTo(BricksChamberLoading.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksChamberLoading.KEY_IS_COMPLETED,true)
                query.orderByDescending(BricksChamberLoading.KEY_CHAMBER_CREATE_DATE)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getBricksChamberLoadingDataFromId(chamberId: String,dataAvailableListener: (List<BricksChamberLoading>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksChamberLoading> = ParseQuery.getQuery(BricksChamberLoading::class.java)
                query.whereEqualTo(BricksChamberLoading.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksChamberLoadingLogs.KEY_CHAMBER_ID, chamberId)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getChamberBricksLog(chamberId: String, dataAvailableListener: (List<BricksChamberLoadingLogs>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksChamberLoadingLogs> = ParseQuery.getQuery(BricksChamberLoadingLogs::class.java)
                query.whereEqualTo(BricksChamberLoadingLogs.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksChamberLoadingLogs.KEY_CHAMBER_ID, chamberId)
                query.addDescendingOrder(BricksChamberLoadingLogs.KEY_PAID_DATE)
                query.addDescendingOrder("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksChamberLoadingLogs_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksChamberLoadingLogs_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksChamberLoadingLogs_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getVendorList(vendorType: String,dataAvailableListener: (List<Vendor>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<Vendor> = ParseQuery.getQuery(Vendor::class.java)
                query.whereEqualTo(Vendor.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(Vendor.KEY_VENDOR_TYPE, vendorType)
                query.orderByDescending("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_Vendor_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_Vendor_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_Vendor_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getChamberFromId(chamberId: String,dataAvailableListener: (List<BricksChamberLoading>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksChamberLoading> = ParseQuery.getQuery(BricksChamberLoading::class.java)
                query.whereEqualTo(BricksChamberLoading.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksChamberLoading.KEY_CHAMBER_ID, chamberId)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_v_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksChamberLoading_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getVendorFromId(vendorId: String,dataAvailableListener: (List<Vendor>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<Vendor> = ParseQuery.getQuery(Vendor::class.java)
                query.whereEqualTo(Vendor.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(Vendor.KEY_VENDOR_ID, vendorId)
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_Vendor_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_Vendor_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_Vendor_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getChamberUnloadingLog(chamberId: String, dataAvailableListener: (List<BricksUnloadingLogs>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<BricksUnloadingLogs> = ParseQuery.getQuery(BricksUnloadingLogs::class.java)
                query.whereEqualTo(BricksUnloadingLogs.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(BricksUnloadingLogs.KEY_CHAMBER_ID, chamberId)
                query.addDescendingOrder(BricksUnloadingLogs.KEY_WORK_DATE)
                query.addDescendingOrder("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_BricksUnloadingLogs_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_BricksUnloadingLogs_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_BricksUnloadingLogs_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getVendorPaidLog(vendorId: String, dataAvailableListener: (List<VendorPaidLog>) -> Unit){
        try {
            GlobalScope.launch(IO){
                val query: ParseQuery<VendorPaidLog> = ParseQuery.getQuery(VendorPaidLog::class.java)
                query.whereEqualTo(VendorPaidLog.KEY_COMPANY_NAME, COMPANY_NAME)
                query.whereEqualTo(VendorPaidLog.KEY_VENDOR_ID, vendorId)
                query.addDescendingOrder(VendorPaidLog.KEY_WORK_DATE)
                query.addDescendingOrder("createdAt")
                query.findInBackground { results, e ->
                    if (e != null) {
                        Log.d("GKBRICKS_VendorPaidLog_GET", e.message.toString() + e.code)
                    } else if (results.isEmpty()) {
                        Log.d("GKBRICKS_VendorPaidLog_GET", "EMPTY")
                        dataAvailableListener.invoke(listOf())
                    } else {
                        Log.d("GKBRICKS_VendorPaidLog_GET", results.size.toString())
                        dataAvailableListener.invoke(results)
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun setBatteryIconStatus(percentage: Int?): Int {
        return when (percentage) {
            in 0..10 -> R.drawable.battery_10_ic
            in 11..30 -> R.drawable.battery_20_ic
            in 31..50 -> R.drawable.battery_40_ic
            in 51..70 -> R.drawable.battery_60_ic
            in 71..90 -> R.drawable.battery_80_ic
            in 91..100 -> R.drawable.battery_full_ic
            else -> R.drawable.battery_full_ic
        }
    }

    fun setBlueBatteryIconStatus(percentage: Int?): Int {
        return when (percentage) {
            in 0..10 -> R.drawable.blue_battery_10_ic
            in 11..30 -> R.drawable.blue_battery_20_ic
            in 31..50 -> R.drawable.blue_battery_40_ic
            in 51..70 -> R.drawable.blue_battery_60_ic
            in 71..90 -> R.drawable.blue_battery_80_ic
            in 91..100 -> R.drawable.blue_battery_full_ic
            else -> R.drawable.blue_battery_full_ic
        }
    }

    fun sendWifiData(byteArray: ByteArray) {
        wifiServerInterface.sendWifiData(byteArray)
    }

    fun getWifiCurrentStatus(wifiStatus: WiFiServerStatus): String {
        val message = when (wifiStatus) {
            WiFiServerStatus.CABIN_NOT_FOUND -> "Sensor not found"
            WiFiServerStatus.CABIN_CONNECTING -> "Connecting to sensor.."
            WiFiServerStatus.CABIN_CONNECTED -> "Sensor connected"
            WiFiServerStatus.CABIN_DIS_CONNECTING -> "Sensor disconnected"
            WiFiServerStatus.SERVER_CONNECTING -> "Sensor connecting..."
            WiFiServerStatus.SERVER_NOT_FOUND -> "Sensor not found"
            WiFiServerStatus.SERVER_CONNECTED -> "Sensor connected"
            else -> "No sensor detected"
        }
        Log.d(MainViewModel.TAG, "wifiStatusMessage: $message")
        return message
    }

    fun showSimSignalStrength(level: Int?, signalIV: ImageView) {
        if (level == null) {
            signalIV.visibility = View.GONE
        } else {
            signalIV.visibility = View.VISIBLE
            when (level) {
                0 -> signalIV.setImageResource(R.drawable.sim_tower_1)
                1 -> signalIV.setImageResource(R.drawable.sim_tower_2)
                2 -> signalIV.setImageResource(R.drawable.sim_tower_3)
                3 -> signalIV.setImageResource(R.drawable.sim_tower_4)
                4 -> signalIV.setImageResource(R.drawable.sim_tower_5)
                else -> {}
            }
        }
    }

    fun showSimBlueSignalStrength(level: Int?, signalIV: ImageView) {
        if (level == null) {
            signalIV.visibility = View.GONE
        } else {
            signalIV.visibility = View.VISIBLE
            when (level) {
                0 -> signalIV.setImageResource(R.drawable.tower_20_ic)
                1 -> signalIV.setImageResource(R.drawable.tower_40_ic)
                2 -> signalIV.setImageResource(R.drawable.tower_60_ic)
                3 -> signalIV.setImageResource(R.drawable.tower_80_ic)
                4 -> signalIV.setImageResource(R.drawable.full_tower_ic)
                else -> {}
            }
        }
    }

    fun getSettingList(): ArrayList<SettingData> {
        return arrayListOf(
            SettingData("Lighting", R.drawable.light_ic),
            SettingData("Fan", R.drawable.fan_ic)
        )
    }

}