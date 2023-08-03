package com.android.hive.source


import com.android.hive.repository.PasswordResponse
import com.android.hive.repository.SaveResponse
import com.android.hive.repository.UserRepository
import javax.inject.Inject


class UserDataSourceImpl @Inject constructor(private val userRepository: UserRepository) :
    UserDataSource {
    override suspend fun savePassword(password: String): SaveResponse =
        userRepository.savePassword(password)

    override suspend fun getPassword(): PasswordResponse =
        userRepository.getPassword()

}
