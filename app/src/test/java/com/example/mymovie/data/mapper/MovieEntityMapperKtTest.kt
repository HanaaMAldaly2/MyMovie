package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.MovieEntity
import com.example.mymovie.domain.model.Movie
import junit.framework.TestCase
import org.junit.Test

internal class MovieEntityMapperKtTest {
    @Test
    fun test_movieEntityListMap() {
        val id = "id"
        val name = "name"
        val image = "image"
        val vote = 5f
        val expectedResult = Movie(id, name, image, vote)
        val response = MovieEntity(id, name, image, vote)

        TestCase.assertEquals(listOf(expectedResult), listOf(response).map())
    }

    @Test
    fun test_movieToMovieEntityMap() {
        val id = "id"
        val name = "name"
        val image = "image"
        val vote = 5f
        val response = Movie(id, name, image, vote)
        val expectedResult = MovieEntity(id, name, image, vote)

        TestCase.assertEquals(expectedResult, response.map())
    }

}