package com.android.hive.repository

import android.content.Context
import android.util.Log
import com.android.hive.R
import com.android.hive.model.Response
import com.android.hive.utils.SharedPreferencesUtil
import com.android.hive.utils.USER_PASSWORD
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(@ApplicationContext val applicationContext: Context) :
    UserRepository {
    override suspend fun savePassword(password: String): SaveResponse = try {
        SharedPreferencesUtil.getEncryptedSharedPreferences(applicationContext).edit()
            .putString(USER_PASSWORD, password).apply()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e.message ?: applicationContext.getString(R.string.str_exception))
    }
    override suspend fun getPassword(): PasswordResponse = try {
        val result = SharedPreferencesUtil.getEncryptedSharedPreferences(applicationContext)
            .getString(USER_PASSWORD, "")

        Response.Success(result.orEmpty())
    } catch (e: Exception) {
        Response.Failure(e.message ?: applicationContext.getString(R.string.str_exception))
    }


}
