package com.gk.bricks.util

import android.content.Context
import android.os.Environment
import android.telephony.TelephonyManager
import android.util.Log
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.services.s3.AmazonS3Client
import com.gk.bricks.R
import com.gk.bricks.interfaces.OnUpload
import com.gk.bricks.util.Constants.S3_BUCKET_URL
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.io.StringWriter
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getExceptionString(obj: Any, throwable: Throwable): String {
    return "\n${getCurrentTime()} | ${obj.javaClass.enclosingClass.name} | ${
        getStackTraceToString(
            throwable
        )
    }\n"
}

private fun getCurrentTime(): String {
    return SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().time)
}

private fun getStackTraceToString(throwable: Throwable): String {
    val result = StringWriter()
    throwable.printStackTrace(PrintWriter(result))
    return result.toString()
}

fun saveExceptionsToFile(context: Context, text: String) {
    try {
        val logFile = File(getLogDir(context), "log_exceptions.txt")
        FileWriter(logFile, true).use { writer ->
            writer.write(text)
        }
    } catch (e: Exception) {
        Log.e("Logcat", "Error saving logcat", e)
    }
}

private fun getLogDir(context: Context): String {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = (calendar.get(Calendar.MONTH) + 1).toString().padStart(2, '0')
    val day = calendar.get(Calendar.DAY_OF_MONTH).toString().padStart(2, '0')
    //val logDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)?.absolutePath+"/Elite/logs/$year-$month-$day"
    val logDir =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + "/ProjectQ/logs/$year-$month-$day"
    if (!File(logDir).exists()) {
        File(logDir).mkdirs()
    }
    return logDir
}

fun parseLteSignalLevelFromString(signalStrengthString: String): Int {
    val lteRegex = Regex("""mLte=CellSignalStrengthLte:.*?level=(\d)""")
    val match = lteRegex.find(signalStrengthString)
    return match?.groups?.get(1)?.value?.toIntOrNull() ?: 0
}

fun mapSimStateIntToString(state: Int): String {
    return when (state) {
        TelephonyManager.SIM_STATE_UNKNOWN -> "UNKNOWN"
        TelephonyManager.SIM_STATE_ABSENT -> "ABSENT"
        TelephonyManager.SIM_STATE_PIN_REQUIRED -> "PIN_REQUIRED"
        TelephonyManager.SIM_STATE_PUK_REQUIRED -> "PUK_REQUIRED"
        TelephonyManager.SIM_STATE_NETWORK_LOCKED -> "NETWORK"
        TelephonyManager.SIM_STATE_READY -> "READY"
        TelephonyManager.SIM_STATE_NOT_READY -> "NOT_READY"
        TelephonyManager.SIM_STATE_PERM_DISABLED -> "PERM_DISABLED"
        TelephonyManager.SIM_STATE_CARD_IO_ERROR -> "CARD_IO_ERROR"
        TelephonyManager.SIM_STATE_CARD_RESTRICTED -> "CARD_RESTRICTED"
        else -> "UNKNOWN"
    }
}

fun fileUpload(
    context: Context,
    key: String,
    file: File,
    accessKey: String,
    secretKey: String,
    bucketName: String,
    onUpload: OnUpload
) {
    val awsCreds = BasicAWSCredentials(accessKey, secretKey)
    val s3Client = AmazonS3Client(awsCreds)
    val trans = TransferUtility.builder().context(context)
        .s3Client(s3Client).build()
    val observer: TransferObserver = trans.upload(
        bucketName,
        key,
        file
    )
    observer.setTransferListener(object : TransferListener {
        override fun onStateChanged(id: Int, state: TransferState) {
            if (state == TransferState.COMPLETED) {
                Log.d("Elite", "success")
                val url = S3_BUCKET_URL + key
                onUpload.onUploadSuccess(url)
            } else if (state == TransferState.FAILED) {
                Log.d("Elite", "failed")
                onUpload.onError(id, Exception("Failed"))
            }
        }

        override fun onProgressChanged(id: Int, bytesCurrent: Long, bytesTotal: Long) {
            val sizeUploaded = getSizeInKB(bytesCurrent)
            val percentage = (bytesCurrent.toFloat() / bytesTotal.toFloat()) * 100
            onUpload.onProgressUpdate(percentage.toInt(), sizeUploaded.toLong())
        }

        override fun onError(id: Int, ex: Exception) {
            Log.e("Elite", ex.toString())
            val value = getExceptionString(object {}, ex)
            saveExceptionsToFile(context, value)
            onUpload.onError(id, ex)
        }
    })
}

fun getSizeInKB(bytes: Long): Int {
    val kilobyte = 1024
    return (bytes / kilobyte).toInt()
}

fun generateRandomText(): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return (1..12)
        .map { chars.random() }
        .joinToString("")
}

fun generateRandomText(length: Int): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}

fun getRupeesFormat(amount: Int): String {
    try {
        return "₹${NumberFormat.getNumberInstance(Locale("en", "IN")).format(amount)}"
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return "₹$amount"
}

fun getCommaFormat(total: Int): String {
    try {
        return "${NumberFormat.getNumberInstance(Locale("en", "IN")).format(total)}"
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return "$total"
}

fun vendorLoadItemMap(mContext:Context) = hashMapOf(
    "Karuvellamaram" to mContext.getString(R.string.karuvellamaram),
    "Pala Jathi" to mContext.getString(R.string.pala_jathi),
    "Vembu" to mContext.getString(R.string.vembu),
    "Panai maram" to mContext.getString(R.string.panai_maram),
    "Maamaram" to mContext.getString(R.string.maamaram),
    "Puliya maram" to mContext.getString(R.string.puliya_maram),
    "Thennai maram" to mContext.getString(R.string.thennai_maram),
    "Alamaram" to mContext.getString(R.string.alamaram),
    "Thekku" to mContext.getString(R.string.thekku),
    "Aththi maram" to mContext.getString(R.string.aththi_maram),
    "Viragu" to mContext.getString(R.string.viragu),
    "Semmann" to mContext.getString(R.string.semmann),
    "Kalimann" to mContext.getString(R.string.kalimann),
    "Manal mann" to mContext.getString(R.string.manal_mann),
    "Kattu mann" to mContext.getString(R.string.kattu_mann),
    "Vandal mann" to mContext.getString(R.string.vandal_mann),
    "Karisal mann" to mContext.getString(R.string.karisal_mann),
    "Saralai mann" to mContext.getString(R.string.saralai_mann),
    "Mann" to mContext.getString(R.string.mann),
)

fun firewoodItemMap(mContext:Context) = hashMapOf(
    "Karuvellamaram" to mContext.getString(R.string.karuvellamaram),
    "Pala Jathi" to mContext.getString(R.string.pala_jathi),
    "Vembu" to mContext.getString(R.string.vembu),
    "Panai maram" to mContext.getString(R.string.panai_maram),
    "Maamaram" to mContext.getString(R.string.maamaram),
    "Puliya maram" to mContext.getString(R.string.puliya_maram),
    "Thennai maram" to mContext.getString(R.string.thennai_maram),
    "Alamaram" to mContext.getString(R.string.alamaram),
    "Thekku" to mContext.getString(R.string.thekku),
    "Aththi maram" to mContext.getString(R.string.aththi_maram),
    "Viragu" to mContext.getString(R.string.viragu),
)

fun sandItemMap(mContext:Context) = hashMapOf(
    "Semmann" to mContext.getString(R.string.semmann),
    "Kalimann" to mContext.getString(R.string.kalimann),
    "Manal mann" to mContext.getString(R.string.manal_mann),
    "Kattu mann" to mContext.getString(R.string.kattu_mann),
    "Vandal mann" to mContext.getString(R.string.vandal_mann),
    "Karisal mann" to mContext.getString(R.string.karisal_mann),
    "Saralai mann" to mContext.getString(R.string.saralai_mann),
    "Mann" to mContext.getString(R.string.mann),
)




