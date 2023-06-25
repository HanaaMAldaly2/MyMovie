package com.example.mymovie.ui.mainscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.mymovie.domain.model.Movie

@Composable
fun MovieList(movies: List<Movie>, addMovieAsFavoriteEvent: ((Movie) -> Unit)? = null) {
    LazyColumn() {
        items(movies) {
            MovieCard(movie = it, addMovieAsFavoriteEvent)
        }
    }
}