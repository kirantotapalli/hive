package com.android.hive.source

import com.android.hive.repository.PasswordResponse
import com.android.hive.repository.SaveResponse

interface UserDataSource {
    suspend fun savePassword(password: String): SaveResponse
    suspend fun getPassword(): PasswordResponse
}
