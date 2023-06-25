package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.repository.MoviesRepo
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class TopRatedMoviesUseCaseTest {
    @Test
    fun invoke_getTopRatedMovies() {
        val repo = mockk<MoviesRepo>()
        coEvery { repo.getTopRatedMovies() } answers {
            listOf()
        }
        val useCase = TopRatedMoviesUseCase(repo)
        runTest {
            useCase.invoke()
        }
        coVerify {
            repo.getTopRatedMovies()
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}