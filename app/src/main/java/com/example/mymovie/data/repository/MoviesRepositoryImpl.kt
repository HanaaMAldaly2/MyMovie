package com.example.mymovie.data.repository

import com.example.mymovie.data.mapper.map
import com.example.mymovie.data.remote.MoviesCloud
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.model.MovieDetails
import com.example.mymovie.domain.repository.MoviesRepo

class MoviesRepositoryImpl : MoviesRepo {
    override suspend fun getMovies(): List<Movie> {
        return MoviesCloud.getMovieServiceInstance().getMovies().map()
    }

    override suspend fun getMoviesByKey(key: String): List<Movie> {
        return MoviesCloud.getMovieServiceInstance().getMoviesByKey(key).map()
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return MoviesCloud.getMovieServiceInstance().getTopRatedMovies().map()
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetails {
        return MoviesCloud.getMovieServiceInstance().getMovieDetails(movieId).map()
    }
}