package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.Genres
import com.example.mymovie.data.model.MovieDetailsResponse
import com.example.mymovie.domain.model.MovieDetails
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Test

internal class MovieDetailsResponseMapperKtTest {
    @Test
    fun test_detailsResponseMap() {
        val id = "id"
        val name = "name"
        val description = "description"
        val image = "image"
        val vote = 5f
        val voteCount = 3
        val genres = listOf("Drama")
        val expectedResult = MovieDetails(id, name, description, image, vote, voteCount, genres)
        val response = mockk<MovieDetailsResponse>()
        every { response.id } returns id
        every { response.title } returns name
        every { response.overview } returns description
        every { response.posterPath } returns image
        every { response.voteAverage } returns vote
        every { response.voteCount } returns voteCount
        every { response.genres } returns listOf(Genres(1, "Drama"))
        assertEquals(expectedResult, response.map())
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}