package com.android.hive.repository

import androidx.lifecycle.LiveData
import com.android.hive.model.Response

typealias SaveResponse = Response<Boolean>
typealias PasswordResponse = Response<String>
interface UserRepository {
    suspend fun savePassword(password: String): SaveResponse
    suspend fun getPassword():PasswordResponse
}
