package com.compose.books.presentaion.books.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose.books.common.Screen


@Composable
fun AppBar(title: String, navController: NavController) {

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFFFFF),
        contentColor = Color.White,
        elevation = 0.7.dp
    ) {
        Icon(
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    navController.popBackStack()
                },
            imageVector = Icons.Default.ArrowBack,
            tint = Color.Black,
            contentDescription = ""
        )
        Text(
            text = title,
            textAlign = TextAlign.Start, color = Color.Black,
            modifier = Modifier,
            fontSize = 16.sp, fontFamily = FontFamily.Serif
        )

    }
}