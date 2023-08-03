package com.android.hive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.hive.screens.ScreenMain
import com.android.hive.ui.theme.AppTheme
import com.android.hive.ui.theme.HiveApplicationTheme
import com.android.hive.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiveApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme
                ) {
                    if (viewModel.isPasswordExist(this)) {
                        ScreenMain(viewModel, false)
                    } else {
                        ScreenMain(viewModel, true)
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiveApplicationTheme {

    }
}
