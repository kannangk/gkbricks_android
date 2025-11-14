package com.gk.bricks

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.gk.bricks.model.parse.BricksChamberLoading
import com.gk.bricks.model.parse.BricksChamberLoadingLogs
import com.gk.bricks.model.parse.BricksProduction
import com.gk.bricks.model.parse.BricksUnloadingLogs
import com.gk.bricks.model.parse.Employee
import com.gk.bricks.model.parse.EmployeeWorkLog
import com.gk.bricks.model.parse.Vendor
import com.gk.bricks.model.parse.VendorPaidLog
import com.parse.Parse
import com.parse.ParseObject
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class BaseApplication : Application(),Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    init {
        System.loadLibrary("native-lib")
        // System.loadLibrary("UARTData")
    }


    override fun onCreate() {
        super.onCreate()
        ParseObject.registerSubclass(Employee::class.java)
        ParseObject.registerSubclass(EmployeeWorkLog::class.java)
        ParseObject.registerSubclass(BricksProduction::class.java)
        ParseObject.registerSubclass(BricksChamberLoading::class.java)
        ParseObject.registerSubclass(BricksChamberLoadingLogs::class.java)
        ParseObject.registerSubclass(Vendor::class.java)
        ParseObject.registerSubclass(VendorPaidLog::class.java)
        ParseObject.registerSubclass(BricksUnloadingLogs::class.java)
//        ParseObject.registerSubclass(EliteSubEvents::class.java)
//        ParseObject.registerSubclass(UserActions::class.java)
//        ParseObject.registerSubclass(AutoReturn::class.java)
//        ParseObject.registerSubclass(OtaUpdate::class.java)
//        ParseObject.registerSubclass(ShaftDetails::class.java)
//        ParseObject.registerSubclass(EliteCustomerImages::class.java)
//        ParseObject.registerSubclass(EliteCustomerVideos::class.java)
//        ParseObject.registerSubclass(EliteCustomerMusic::class.java)
//        ParseObject.registerSubclass(UserGames::class.java)
//        ParseObject.registerSubclass(LiveQueryStatus::class.java)
//        ParseObject.registerSubclass(CopPingPong::class.java)
//        ParseObject.registerSubclass(EmergencySOS::class.java)
//        ParseObject.registerSubclass(PrivacyScreenControl::class.java)
//        ParseObject.registerSubclass(AppRestriction::class.java)
//        ParseObject.registerSubclass(EliteTripHistory::class.java)
//        ParseObject.registerSubclass(EliteUnauthorizedHistory::class.java)
//        ParseObject.registerSubclass(LiftPerformanceParse::class.java)
        Log.d("BaseApplication", "onCreate: ${getApiKey(3,BuildConfig.DEBUG)}")
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getApiKey(2,BuildConfig.DEBUG))
                .server(getApiKey(3,BuildConfig.DEBUG))
                .build()
        )
    }

    private external fun getApiKey(id: Int,isDebug:Boolean): String

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().setWorkerFactory(workerFactory).build()

    companion object{
        lateinit var appContext: Context
    }
}