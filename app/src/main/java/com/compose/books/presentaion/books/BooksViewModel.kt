package com.compose.books.presentaion.books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.books.common.Resource
import com.compose.books.domain.models.BooksModel
import com.compose.books.domain.use_cases.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(val getBooksUseCase: GetBooksUseCase) : ViewModel() {

    private val _state = mutableStateOf(BooksListState())
    val state: State<BooksListState> = _state

    init {
        getBooks()
    }

    fun getBooks() {
        getBooksUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = BooksListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = BooksListState(booksModel = result.data)
                }
                is Resource.Error -> {
                    _state.value = BooksListState(error = result.message ?: "Something went wrong!")
                }
            }
        }.launchIn(viewModelScope)
    }
}