package com.android.hive.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.hive.composables.CustomButton
import com.android.hive.composables.CustomHeader
import com.android.hive.ui.theme.AppTheme
import com.android.hive.viewmodel.UserViewModel
import com.android.hive.R

@Composable
fun FirstPage(navController: NavHostController,viewModel: UserViewModel) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppTheme)){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomHeader(stringResource(R.string.str_welcome))

            Spacer(modifier = Modifier.height(200.dp))

            CustomButton(
                title = stringResource(R.string.str_next),
                onClick = {
                    viewModel.moveToSecondScreen(navController)
                }
            )
        }
    }
}
