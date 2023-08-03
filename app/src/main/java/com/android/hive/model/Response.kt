package com.android.hive.model

sealed class Response<out T> {
    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Failure(
        val message: String
    ): Response<Nothing>()
}
