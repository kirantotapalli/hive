package com.android.hive.domain

import com.android.hive.repository.PasswordResponse
import com.android.hive.repository.SaveResponse
import com.android.hive.repository.UserRepository
import com.android.hive.source.UserDataSource
import javax.inject.Inject


class UserUseCaseImpl @Inject constructor(private val userDataSource: UserDataSource) :
    UserUseCase {
    override suspend fun savePassword(password: String): SaveResponse =
        userDataSource.savePassword(password)

    override suspend fun getPassword(): PasswordResponse =
        userDataSource.getPassword()

}
