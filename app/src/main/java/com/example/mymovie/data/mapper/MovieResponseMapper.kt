package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.MovieResponse
import com.example.mymovie.domain.model.Movie

fun MovieResponse.map(): List<Movie> = run {
    val movies = mutableListOf<Movie>()
    results.forEach {
        val movie = Movie(it.id, it.title, it.posterPath, it.voteAverage)
        movies.add(movie)
    }
    movies
}