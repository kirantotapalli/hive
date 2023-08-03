package com.android.hive.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.android.hive.R

@Composable
fun CustomTextField(onTextChanged: (text: String) -> Unit,value : String,hasError: Boolean = false) {

    var password  = value
    var showPassword by remember { mutableStateOf(value = false) }
    OutlinedTextField(
        modifier = Modifier.height(70.dp),
        value = password,
        onValueChange = { newText ->
            password = newText
            onTextChanged(newText)
        },
        label = {
            Text(text = stringResource(R.string.str_password),color = Color.White)
        },
        isError = hasError,
        placeholder = { Text(text = stringResource(R.string.str_type_here),color = Color.White) },
        shape = RoundedCornerShape(percent = 20),
        visualTransformation = if (showPassword) {

            VisualTransformation.None

        } else {

            PasswordVisualTransformation()

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            textColor = Color.White,
            cursorColor = Color.White,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Image(
                        painterResource(id = R.drawable.visibilit),
                        contentDescription = "hide_password",
                        contentScale = ContentScale.Crop,
                    )
                }
            } else {
                IconButton(
                    onClick = { showPassword = true }) {
                    Image(
                        painterResource(id = R.drawable.visibility_off),
                        contentDescription = "hide_password",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    )
    if (hasError) {
        Text(
            text = stringResource(R.string.str_password_validation),
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}
