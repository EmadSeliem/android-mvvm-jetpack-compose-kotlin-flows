package com.compose.books.presentaion.books

import com.compose.books.domain.models.BooksModel

data class BooksListState(
    val isLoading: Boolean = false,
    val booksModel: BooksModel? = null,
    val error: String = ""
)
