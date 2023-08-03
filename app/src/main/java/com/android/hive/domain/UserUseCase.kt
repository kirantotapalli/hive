package com.android.hive.domain


import com.android.hive.repository.PasswordResponse
import com.android.hive.repository.SaveResponse


interface UserUseCase {
    suspend fun savePassword(password: String): SaveResponse
    suspend fun getPassword(): PasswordResponse
}
