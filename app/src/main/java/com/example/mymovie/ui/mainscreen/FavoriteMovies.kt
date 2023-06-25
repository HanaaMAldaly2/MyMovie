package com.example.mymovie.ui.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.ui.HomeViewModel

@Composable
fun FavoriteMoviesScreen(viewModel: HomeViewModel) {
    viewModel.getFavoriteMovies()
    val movies: List<Movie> by viewModel.favoriteMoviesObservable.collectAsState(initial = listOf())

    MovieList(movies = movies)

}
