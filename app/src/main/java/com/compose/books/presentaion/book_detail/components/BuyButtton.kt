package com.compose.books.presentaion.book_detail.components

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun BuyButton(modifier: Modifier, price: String, onItemClick: (String) -> Unit) {

    Button(

        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
        // below line is use to add shape for our button.
        shape = MaterialTheme.shapes.medium,
        onClick = {
            onItemClick("")
        }
    ) {
        Text(
            text = "Buy AED ${price}",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
