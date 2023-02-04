package com.example.template.data.presistance

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val context: Context
) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences
        .create(
            context,
            TOKEN_MANAGER_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    fun getAccessToken(): String? = sharedPreferences.getString(TOKEN_KEY, null)

    suspend fun saveAccessToken(token: String) {
        sharedPreferences.edit {
            putString(TOKEN_KEY, token)
        }
    }

    fun clearToken() {
        sharedPreferences.edit {
            putString(TOKEN_KEY, null)
        }
    }


    companion object {
        const val TOKEN_MANAGER_NAME = "auth_data"
        const val TOKEN_KEY = "auth_token"
    }

}