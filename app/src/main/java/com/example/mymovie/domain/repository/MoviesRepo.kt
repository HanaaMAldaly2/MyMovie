package com.example.mymovie.domain.repository

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.model.MovieDetails

interface MoviesRepo {
    suspend fun getMovies(): List<Movie>

    suspend fun getMoviesByKey(key: String): List<Movie>

    suspend fun getTopRatedMovies(): List<Movie>

    suspend fun getMovieDetails(movieId: String): MovieDetails
}