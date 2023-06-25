package com.example.mymovie.ui.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.ui.HomeViewModel

@Composable
fun TopRatedMoviesScreen(viewModel: HomeViewModel) {
    viewModel.getTopRatedMovies()
    val movies: List<Movie> by viewModel.topRatedMoviesObservable.collectAsState(initial = listOf())

    MovieList(movies = movies) {
        viewModel.addMovieAsFavoriteMovies(it)
    }

}
