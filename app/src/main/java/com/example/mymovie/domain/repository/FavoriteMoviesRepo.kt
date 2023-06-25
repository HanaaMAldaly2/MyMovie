package com.example.mymovie.domain.repository

import com.example.mymovie.domain.model.Movie

interface FavoriteMoviesRepo {
    suspend fun getMovies(): List<Movie>

    suspend fun addMovieAsFavorite(movie: Movie)
}