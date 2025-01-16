package com.lyhorng.moviex.helpers

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import java.security.GeneralSecurityException
import java.io.IOException

object SecureStorageHelper {

    // Create or retrieve the Master Key
    @Throws(GeneralSecurityException::class, IOException::class)
    private fun getMasterKey(): String {
        return MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }

    // Get EncryptedSharedPreferences instance
    @Throws(GeneralSecurityException::class, IOException::class)
    private fun getEncryptedSharedPreferences(context: Context): SharedPreferences {
        val masterKeyAlias = getMasterKey()
        return EncryptedSharedPreferences.create(
            "secure_prefs", // File name for storing encrypted data
            masterKeyAlias, // Master key alias
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    // Store API key securely
    fun storeApiKey(context: Context, apiKey: String) {
        try {
            val sharedPreferences = getEncryptedSharedPreferences(context)
            sharedPreferences.edit().putString("API_KEY", apiKey).apply()
        } catch (e: Exception) {
            e.printStackTrace()  // Handle error appropriately
        }
    }

    // Retrieve API key securely
    fun getApiKey(context: Context): String? {
        return try {
            val sharedPreferences = getEncryptedSharedPreferences(context)
            sharedPreferences.getString("API_KEY", null)
        } catch (e: Exception) {
            e.printStackTrace()  // Handle error appropriately
            null
        }
    }
}