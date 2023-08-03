package com.android.hive.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.android.hive.R
import com.android.hive.composables.CustomButton
import com.android.hive.composables.CustomHeader
import com.android.hive.composables.CustomTextField
import com.android.hive.model.Response
import com.android.hive.ui.theme.AppTheme
import com.android.hive.viewmodel.UserViewModel

@Composable
fun SecondPage(navController: NavHostController,viewModel: UserViewModel) {
    var hasError  by remember { mutableStateOf(value = false) }
    val myContext = LocalContext.current
    viewModel.passwordResult.observe(LocalLifecycleOwner.current, Observer { response ->
        when (response) {
            is Response.Success -> {
                response.data.let {
                    hasError = false
                }
            }
            is Response.Failure -> {
                hasError = true

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

            CustomHeader(stringResource(R.string.str_password))
            Spacer(modifier = Modifier.height(200.dp))

            var password by remember { mutableStateOf(value = "") }
            CustomTextField(onTextChanged = {
                password = it
            },password,hasError)

            Spacer(modifier = Modifier.height(50.dp))

            CustomButton(title = stringResource(R.string.str_next),
                onClick = {
                    viewModel.checkPassword(password,navController,myContext)
                })
        }
    }

}
