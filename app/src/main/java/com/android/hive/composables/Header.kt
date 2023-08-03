package com.android.hive.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.hive.R

@Composable
fun CustomHeader(title: String){

    Spacer(modifier = Modifier.height(10.dp))
    Image(
        painterResource(id = R.drawable.hive_logo),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(50.dp)
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(text = title, style = TextStyle(fontSize = 25.sp, fontFamily = FontFamily.Default, color = Color.White))

}
