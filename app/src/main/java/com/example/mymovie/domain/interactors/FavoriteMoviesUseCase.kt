package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.FavoriteMoviesRepo

class FavoriteMoviesUseCase(private val repo: FavoriteMoviesRepo) : suspend () -> List<Movie> {
    override suspend fun invoke(): List<Movie> = repo.getMovies()
}