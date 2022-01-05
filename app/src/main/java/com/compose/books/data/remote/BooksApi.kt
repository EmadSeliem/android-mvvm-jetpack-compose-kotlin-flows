package com.compose.books.data.remote

import com.compose.books.domain.models.BooksModel
import retrofit2.http.GET

interface BooksApi {
    @GET("lists/current/hardcover-fiction.json?api-key=TPhtqFGwkQ4G5EotHbaX1XQkuDB8CQYA")
    suspend fun getBooks(): BooksModel
}