package com.compose.books.common

sealed class Screen(val route: String) {
    object BookListingScreen : Screen("book_listing")
    object BooksDetails : Screen("book_detail")
    object Publishers : Screen("publishers")
}
