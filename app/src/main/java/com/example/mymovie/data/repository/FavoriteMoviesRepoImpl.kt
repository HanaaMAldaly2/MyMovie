package com.example.mymovie.data.repository

import com.example.mymovie.data.local.MovieDatabase
import com.example.mymovie.data.mapper.map
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.FavoriteMoviesRepo

class FavoriteMoviesRepoImpl(private val db: MovieDatabase) : FavoriteMoviesRepo {
    override suspend fun getMovies(): List<Movie> {
        return db.getMovieDao().getAll().map()
    }

    override suspend fun addMovieAsFavorite(movie: Movie) {
        db.getMovieDao().insert(movie.map())
    }
}