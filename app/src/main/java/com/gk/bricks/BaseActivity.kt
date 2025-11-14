package com.gk.bricks

import android.Manifest
import android.app.Activity
import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.app.role.RoleManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.gk.bricks.util.LocaleManager
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mAdminComponentName: ComponentName
    lateinit var mDevicePolicyManager: DevicePolicyManager

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            Log.d("Project_Q_home_permission", "granted")
        }
    }

    private val requestInstallPackagesResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        requestWriteSettingsPermissions()
    }

    fun disableKioskMode() {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        if (mDevicePolicyManager.isLockTaskPermitted(packageName)) {
            if (manager.lockTaskModeState == ActivityManager.LOCK_TASK_MODE_LOCKED)
                stopLockTask()
        } /*openInstallerToWhitelist()*/
    }

    fun enableKioskMode() {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        if (manager.lockTaskModeState == ActivityManager.LOCK_TASK_MODE_NONE) {
            if (mDevicePolicyManager.isLockTaskPermitted(packageName)) {
                startLockTask()
            } /*else openInstallerToWhitelist()*/
        }
    }

    private fun requestWriteSettingsPermissions() {
        if (!Settings.System.canWrite(this@BaseActivity)) {
            val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
            intent.data = Uri.parse("package:$packageName")
            startActivity(intent)
        }
    }

    fun handleRequiredPermissions(isAllPermissionsGranted: (Boolean) -> Unit) {
        val permissions = mutableListOf(
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.CAMERA,
        )


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            permissions.add(Manifest.permission.NEARBY_WIFI_DEVICES)
//        } else {
//            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
//            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
//        }

        Dexter.withContext(this)
            .withPermissions(permissions)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(multiplePermissionsReport: MultiplePermissionsReport) {

                    val deniedPermissions = mutableListOf<String>()
                    for (p in multiplePermissionsReport.deniedPermissionResponses)
                        deniedPermissions.add(p.permissionName)

                    if (multiplePermissionsReport.areAllPermissionsGranted()
//                        || deniedPermissions.contains(
//                            Manifest.permission.ACCESS_FINE_LOCATION
//                        )
//                        || deniedPermissions.contains(Manifest.permission.ACCESS_COARSE_LOCATION)
                    ) {
                        isAllPermissionsGranted.invoke(true)
                        requestWriteSettingsPermissions()

//                        if (!Environment.isExternalStorageManager()) requestManageStoragePermissions()
//
//                        requestOverLayPermission()
//
//                        if (!packageManager.canRequestPackageInstalls()) {
//                            requestInstallPackagesResult.launch(
//                                Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
//                                    .setData(String.format("package:%s", packageName).toUri())
//                            )
//                        } else
//                            requestWriteSettingsPermissions()
//
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                            if (!getSystemService(AlarmManager::class.java).canScheduleExactAlarms()) {
//                                // Ask user to manually enable the permission
//                                val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
//                                startActivity(intent)
//                            }
//                        }
                    } else {
                        isAllPermissionsGranted.invoke(false)
                        finishAffinity()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    list: List<PermissionRequest>,
                    permissionToken: PermissionToken,
                ) = Unit
            }).check()
    }

    override fun attachBaseContext(newBase: Context) {
        val lang = LocaleManager.getLanguage(newBase)
        super.attachBaseContext(LocaleManager.updateResources(newBase, lang))
    }

    private fun showLauncherSelection() {
        val roleManager = getSystemService(Context.ROLE_SERVICE)
                as RoleManager
        if (roleManager.isRoleAvailable(RoleManager.ROLE_HOME) &&
            !roleManager.isRoleHeld(RoleManager.ROLE_HOME)
        ) {
            val intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_HOME)
            startForResult.launch(intent)
        }
    }

    fun requestManageStoragePermissions() {
        val intent = Intent()
        intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun requestOverLayPermission() {
        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                ("package:" + this.packageName).toUri()
            )
            startActivity(intent)
        } else {
            //Permission Granted-System will work
        }
    }

    fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}