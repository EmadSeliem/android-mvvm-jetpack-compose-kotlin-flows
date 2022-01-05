package com.compose.books.domain.repository

import com.compose.books.domain.models.BooksModel

interface BooksRepository {

    suspend fun getBooks(): BooksModel
}