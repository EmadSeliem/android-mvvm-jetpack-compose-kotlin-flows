package com.compose.books.domain.use_cases

import com.compose.books.common.Resource
import com.compose.books.domain.models.BooksModel
import com.compose.books.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(val booksRepository: BooksRepository) {

    operator fun invoke(): Flow<Resource<BooksModel>> = flow {
        try {
            emit(Resource.Loading<BooksModel>())
            val books = booksRepository.getBooks()
            emit(Resource.Success<BooksModel>(books))
        } catch (http: HttpException) {
            emit(
                Resource.Error<BooksModel>(
                    http.localizedMessage ?: " Something went wrong please try again later!"
                )
            )
        } catch (io: IOException) {
            emit(Resource.Error<BooksModel>("Please check your internet connecion and try again later."))
        }

    }


}