package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MoviesRepo

class MoviesUseCase(private val repo: MoviesRepo) : suspend () -> List<Movie> {
    override suspend fun invoke(): List<Movie> = repo.getMovies()
}