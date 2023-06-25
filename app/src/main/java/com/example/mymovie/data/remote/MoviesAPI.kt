package com.example.mymovie.data.remote

import com.example.mymovie.data.model.MovieDetailsResponse
import com.example.mymovie.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {
    @GET("movie/now_playing/")
    suspend fun getMovies(
    ): MovieResponse

    @GET("search/movie")
    suspend fun getMoviesByKey(
        @Query("query") key: String
    ): MovieResponse

    @GET("movie/top_rated/")
    suspend fun getTopRatedMovies(): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String
    ): MovieDetailsResponse
}