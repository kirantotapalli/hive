package com.android.hive.utils

fun isValidPassword(password: String): Boolean {
    val passwordPattern =
        Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\d\\s])[A-Za-z\\d\\W]{8,}\$")
    return password.matches(passwordPattern)
}
