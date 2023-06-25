package com.example.mymovie.domain.interactors

import com.example.mymovie.domain.repository.MoviesRepo
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test

internal class MoviesByKeyUseCaseTest {
    @Test
    fun invoke_getMoviesByKey() {
        val key = "H"
        val repo = mockk<MoviesRepo>()
        coEvery { repo.getMoviesByKey(key) } answers {
            listOf()
        }
        val useCase = MoviesByKeyUseCase(repo)
        runTest {
            useCase.invoke(key)
        }
        coVerify {
            repo.getMoviesByKey(key)
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}