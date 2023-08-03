package com.android.hive.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.hive.viewmodel.UserViewModel


@Composable
fun ScreenMain(viewModel: UserViewModel, isPasswordSaved : Boolean){
    val navController = rememberNavController()
    val startDestination = if (isPasswordSaved) Routes.FirstPage.route else Routes.LastPage.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.FirstPage.route) {
            FirstPage(navController = navController,viewModel)
        }

        composable(Routes.SecondPage.route) {
            SecondPage(navController = navController,viewModel)
        }

        composable(Routes.LastPage.route) {
            LastPage(navController = navController,viewModel)
        }
    }
}
