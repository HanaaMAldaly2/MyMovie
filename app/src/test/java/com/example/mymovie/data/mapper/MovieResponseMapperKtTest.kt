package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.MovieResponse
import com.example.mymovie.data.model.Results
import com.example.mymovie.domain.model.Movie
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.After
import org.junit.Test

internal class MovieResponseMapperKtTest {
    @Test
    fun test_MoviesResponseMap() {
        val id = "id"
        val name = "name"
        val image = "image"
        val vote = 5f
        val expectedResult = Movie(id, name, image, vote)
        val response = mockk<MovieResponse>()
        val result = mockk<Results>()
        every { response.results } returns listOf(result)
        every { result.id } returns id
        every { result.title } returns name
        every { result.posterPath } returns image
        every { result.voteAverage } returns vote

        TestCase.assertEquals(listOf(expectedResult), response.map())
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}