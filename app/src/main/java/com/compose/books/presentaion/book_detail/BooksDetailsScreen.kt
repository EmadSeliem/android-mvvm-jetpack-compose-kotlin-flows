package com.compose.books.presentaion.book_detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.compose.books.R
import com.compose.books.presentaion.book_detail.components.BuyButton
import com.compose.books.presentaion.books.components.AppBar
import kotlinx.coroutines.launch

@Composable
fun BooksDetailsScreen(
    navController: NavController,
    bookTitle: String,
    book_desc: String,
    book_url: String,
    book_author: String,
    price: String,
    publisher: String
) {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState // attaching `scaffoldState` to the `Scaffold`
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            AppBar(title = stringResource(id = R.string.app_desc), navController)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(180.dp), elevation = 5.dp
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10.dp))
                            .border(width = 20.dp, shape = CircleShape, color = Color.Transparent),
                        contentScale = ContentScale.Crop,
                        painter = rememberImagePainter(book_url),
                        contentDescription = null
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(6f)
                        .padding(horizontal = 10.dp)
                ) {

                    Text(
                        text = bookTitle,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = book_author,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal
                    )

                }
            }

            Spacer(Modifier.padding(vertical = 10.dp))
            Text(
                text = stringResource(id = R.string.about_this_book),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = book_desc,
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = stringResource(id = R.string.published_by),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = publisher,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable { },
                fontSize = 16.sp,
                color = Color.Black, textDecoration = TextDecoration.Underline,
            )
            Spacer(modifier = Modifier.weight(1f))
            BuyButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp), onItemClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Under Implementaion",
                            actionLabel = ""
                        )
                    }
                }
//
                , price = price
            )
        }
    }
}

