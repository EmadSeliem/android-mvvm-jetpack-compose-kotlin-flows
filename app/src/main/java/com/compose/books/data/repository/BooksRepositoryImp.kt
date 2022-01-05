package com.compose.books.data.repository

import com.compose.books.data.remote.BooksApi
import com.compose.books.domain.models.BooksModel
import com.compose.books.domain.repository.BooksRepository
import javax.inject.Inject

class BooksRepositoryImp @Inject constructor(private val api: BooksApi) : BooksRepository {
    override suspend fun getBooks(): BooksModel {
        return api.getBooks()
    }
}