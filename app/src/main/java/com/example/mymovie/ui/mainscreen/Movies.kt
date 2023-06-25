package com.example.mymovie.ui.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.ui.HomeViewModel

@Composable
fun MoviesScreen(viewModel: HomeViewModel) {
    viewModel.getMovies()
    val movies: List<Movie> by viewModel.moviesObservable.collectAsState(initial = listOf())
    Column {
        MovieList(movies = movies) {
            viewModel.addMovieAsFavoriteMovies(it)
        }
    }

}
