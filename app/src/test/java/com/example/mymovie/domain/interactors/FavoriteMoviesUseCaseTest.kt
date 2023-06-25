package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.repository.FavoriteMoviesRepo
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class FavoriteMoviesUseCaseTest {
    @Test
    fun invoke_getFavoriteMovies() {
        val movie = mockk<Movie>()
        val repo = mockk<FavoriteMoviesRepo>()
        coEvery { repo.getMovies() } answers {
            listOf()
        }
        val useCase = FavoriteMoviesUseCase(repo)
        runTest {
            useCase.invoke()
        }
        coVerify {
            repo.getMovies()
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}