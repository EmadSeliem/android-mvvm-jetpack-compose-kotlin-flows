package com.compose.books.presentaion.books.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.books.R
import com.compose.books.common.Screen
import com.compose.books.presentaion.books.BooksListItem
import com.compose.books.presentaion.books.BooksViewModel

@ExperimentalFoundationApi
@Composable
fun BooksListScreen(
    booksViewModel: BooksViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = booksViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            AppBar(stringResource(id = R.string.app_name), navController)
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                cells = GridCells.Fixed(3),
                contentPadding = PaddingValues(5.dp)
            ) {
                state.booksModel?.results?.let {
                    items(it.books) {
                        BooksListItem(book = it, onItemClick = {
                            /*
                            -Compose navigation is not supporting sending objects till now.
                            -So I used below workaround .
                            -It is not the correct way to pass objects , will be updated once navigation supported it
                              */
                            navController.navigate(Screen.BooksDetails.route + "?book_title=${it.title},?book_desc=${it.description},?book_url=${it.book_image},?book_author=${it.author},?price=${it.price},?publisher=${it.publisher}")
                        })
                    }
                }
            }

        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (state.error.isNotBlank())
            Text(
                text = state.error,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
    }
}