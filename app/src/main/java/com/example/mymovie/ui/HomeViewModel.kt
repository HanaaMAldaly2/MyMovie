package com.example.mymovie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.interactors.AddMovieAsFavoriteUseCase
import com.example.mymovie.domain.interactors.FavoriteMoviesUseCase
import com.example.mymovie.domain.interactors.MoviesByKeyUseCase
import com.example.mymovie.domain.interactors.MoviesUseCase
import com.example.mymovie.domain.interactors.TopRatedMoviesUseCase
import com.example.mymovie.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: MoviesUseCase,
    private val topRatedMoviesUseCase: TopRatedMoviesUseCase,
    private val moviesByKeyUseCase: MoviesByKeyUseCase,
    private val favoriteMoviesUseCase: FavoriteMoviesUseCase,
    private val addMovieAsFavoriteUseCase: AddMovieAsFavoriteUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val handlerException = CoroutineExceptionHandler { _, _ ->
        //TODO handle error state
    }
    val moviesObservable = MutableSharedFlow<List<Movie>>()
    val moviesByKeyObservable = MutableSharedFlow<List<Movie>>()
    val favoriteMoviesObservable = MutableSharedFlow<List<Movie>>()
    val topRatedMoviesObservable = MutableSharedFlow<List<Movie>>()

    fun getMovies() {
        viewModelScope.launch(dispatcher + handlerException) {
            moviesObservable.emit(useCase.invoke())
        }
    }

    fun getMoviesByKey(key: String) {
        viewModelScope.launch(dispatcher + handlerException) {
            moviesByKeyObservable.emit(moviesByKeyUseCase.invoke(key))
        }
    }

    fun getFavoriteMovies() {
        viewModelScope.launch(dispatcher + handlerException) {
            favoriteMoviesObservable.emit(favoriteMoviesUseCase.invoke())
        }
    }

    fun addMovieAsFavoriteMovies(movie: Movie) {
        viewModelScope.launch(dispatcher + handlerException) {
            addMovieAsFavoriteUseCase.invoke(movie)
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch(dispatcher + handlerException) {
            topRatedMoviesObservable.emit(topRatedMoviesUseCase.invoke())

        }
    }
}