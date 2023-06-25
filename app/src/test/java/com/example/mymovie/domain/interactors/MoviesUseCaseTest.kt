package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.repository.MoviesRepo
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class MoviesUseCaseTest {
    @Test
    fun invoke_getMovies() {
        val repo = mockk<MoviesRepo>()
        coEvery { repo.getMovies() } answers {
            listOf()
        }
        val useCase = MoviesUseCase(repo)
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