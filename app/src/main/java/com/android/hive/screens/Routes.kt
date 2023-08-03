package com.android.hive.screens

sealed class Routes(val route: String) {
    object FirstPage : Routes("FirstPage")
    object SecondPage : Routes("SecondPage")
    object LastPage : Routes("LastPage")
}
