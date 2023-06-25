package com.example.mymovie.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.interactors.MovieDetailsUseCase
import com.example.mymovie.domain.model.MovieDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val useCase: MovieDetailsUseCase,
    private val movieId: String,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val handlerException = CoroutineExceptionHandler { _, _ ->
        //TODO handle error state
    }
    val movieObservable = MutableSharedFlow<MovieDetails>()

    init {
        viewModelScope.launch(dispatcher + handlerException) {
            movieObservable.emit(useCase.invoke(movieId))
        }
    }
}