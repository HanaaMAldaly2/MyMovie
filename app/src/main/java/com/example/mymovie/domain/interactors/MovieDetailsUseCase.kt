package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.MovieDetails
import com.example.mymovie.domain.repository.MoviesRepo

class MovieDetailsUseCase(private val repo: MoviesRepo) : suspend (String) -> MovieDetails {
    override suspend fun invoke(id: String) = repo.getMovieDetails(id)
}