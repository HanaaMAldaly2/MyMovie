package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.MoviesRepo

class MoviesByKeyUseCase(private val repo: MoviesRepo) : suspend (String) -> List<Movie> {
    override suspend fun invoke(key: String): List<Movie> = repo.getMoviesByKey(key)
}