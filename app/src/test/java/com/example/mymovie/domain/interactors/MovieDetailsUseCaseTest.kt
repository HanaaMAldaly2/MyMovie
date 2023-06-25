package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.repository.MoviesRepo
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class MovieDetailsUseCaseTest {
    @Test
    fun invoke_getMovieDetails() {
        val movieId = "id"

        val repo = mockk<MoviesRepo>()
        coEvery { repo.getMovieDetails(movieId) } returns mockk()
        val useCase = MovieDetailsUseCase(repo)
        runTest {
            useCase.invoke(movieId)
        }
        coVerify {
            repo.getMovieDetails(movieId)
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}