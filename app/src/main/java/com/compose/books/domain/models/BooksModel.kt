package com.compose.books.domain.models

data class BooksModel(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
)