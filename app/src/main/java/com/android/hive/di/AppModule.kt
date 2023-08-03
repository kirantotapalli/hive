package com.android.hive.di

import com.android.hive.domain.UserUseCase
import com.android.hive.domain.UserUseCaseImpl
import com.android.hive.repository.UserRepository
import com.android.hive.repository.UserRepositoryImpl
import com.android.hive.source.UserDataSource
import com.android.hive.source.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository =
        userRepositoryImpl

    @Provides
    @Singleton
    fun provideUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource  = userDataSourceImpl

    @Provides
    @Singleton
    fun provideUserDataDomain(
        userDataSource: UserDataSource,
    ): UserUseCase {
        return UserUseCaseImpl(userDataSource)
    }
}
