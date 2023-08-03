package com.android.hive.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import com.android.hive.R
import com.android.hive.composables.CustomButton
import com.android.hive.composables.CustomHeader
import com.android.hive.model.Response
import com.android.hive.ui.theme.AppTheme
import com.android.hive.viewmodel.UserViewModel

@Composable
fun LastPage(navController: NavHostController,viewModel: UserViewModel) {
    var savedPassword  by remember { mutableStateOf("") }
    viewModel.getPasswordInfo()
    viewModel.passwordInfo.observe(LocalLifecycleOwner.current, Observer { response ->
        when (response) {
            is Response.Success -> {
                response.data.let {
                    savedPassword = response.data
                }
            }
            is Response.Failure -> {

            }
        }
    })

    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppTheme)) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomHeader(stringResource(R.string.str_your_password))
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = savedPassword,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(50.dp))

            CustomButton(title = stringResource(R.string.str_clear),
                onClick = {
                    viewModel.onClearButtonClick()
                    viewModel.moveToFirstScreen(navController)
                })
        }
    }

}
