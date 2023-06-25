package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.FavoriteMoviesRepo
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class AddMovieAsFavoriteUseCaseTest {
    @Test
    fun invoke_addMovieAsFavorite() {
        val movie = mockk<Movie>()
        val repo = mockk<FavoriteMoviesRepo>()
        coEvery { repo.addMovieAsFavorite(movie) } just Runs
        val useCase = AddMovieAsFavoriteUseCase(repo)
        runTest {
            useCase.invoke(movie)
        }
        coVerify {
            repo.addMovieAsFavorite(movie)
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}