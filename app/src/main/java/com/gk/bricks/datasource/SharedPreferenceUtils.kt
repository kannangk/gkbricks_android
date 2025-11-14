package com.gk.bricks.datasource

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences


private val defaultPrefKeyEncryptionScheme: EncryptedSharedPreferences.PrefKeyEncryptionScheme =
    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV
private val defaultPrefValueEncryptionScheme: EncryptedSharedPreferences.PrefValueEncryptionScheme =
    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM

class SharedPreferenceUtils(
    fileName: String = "NIBAV",
    applicationContext: Context,
    prefKeyEncryptionScheme: androidx.security.crypto.EncryptedSharedPreferences.PrefKeyEncryptionScheme = com.gk.bricks.datasource.defaultPrefKeyEncryptionScheme,
    prefValueEncryptionScheme: androidx.security.crypto.EncryptedSharedPreferences.PrefValueEncryptionScheme = com.gk.bricks.datasource.defaultPrefValueEncryptionScheme
) {
    private var masterKey = androidx.security.crypto.MasterKey.Builder(
        applicationContext,
        androidx.security.crypto.MasterKey.DEFAULT_MASTER_KEY_ALIAS
    )
        .setKeyScheme(androidx.security.crypto.MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences: SharedPreferences =
        androidx.security.crypto.EncryptedSharedPreferences.create(
            applicationContext,
            fileName, masterKey, prefKeyEncryptionScheme, prefValueEncryptionScheme
        )

    fun containsKey(key: String): Boolean = sharedPreferences.contains(key)
    fun getBoolean(key: String, defaultValue: Boolean): Boolean = sharedPreferences.getBoolean(key, defaultValue)
    fun getInt(key: String, defaultValue: Int): Int = sharedPreferences.getInt(key, defaultValue)
    fun getLong(key: String, defaultValue: Long): Long = sharedPreferences.getLong(key, defaultValue)
    fun getFloat(key: String, defaultValue: Float): Float = sharedPreferences.getFloat(key, defaultValue)
    fun getString(key: String, defaultValue: String): String = sharedPreferences.getString(key, defaultValue) ?: ""

    fun saveBoolean(key: String, value: Boolean) = sharedPreferences.edit().putBoolean(key, value).apply()
    fun saveInt(key: String, value: Int) = sharedPreferences.edit().putInt(key, value).apply()
    fun saveLong(key: String, value: Long) = sharedPreferences.edit().putLong(key, value).apply()
    fun saveFloat(key: String, value: Float) = sharedPreferences.edit().putFloat(key, value).apply()
    fun saveString(key: String, value: String) = sharedPreferences.edit().putString(key, value).apply()

    fun deleteValue(key: String) = sharedPreferences.edit().remove(key).apply()

    fun clear() = sharedPreferences.edit().clear().apply()

}