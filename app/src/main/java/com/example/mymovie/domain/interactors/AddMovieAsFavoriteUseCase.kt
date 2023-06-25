package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.FavoriteMoviesRepo

class AddMovieAsFavoriteUseCase(private val repo: FavoriteMoviesRepo) : suspend (Movie) -> Unit {
    override suspend fun invoke(movie: Movie): Unit = repo.addMovieAsFavorite(movie)
}