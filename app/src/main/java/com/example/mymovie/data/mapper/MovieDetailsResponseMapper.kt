package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.MovieDetailsResponse
import com.example.mymovie.domain.model.MovieDetails

fun MovieDetailsResponse.map() = run {
    val genres = genres.map { it.name }
    MovieDetails(
        id = id,
        title = title,
        description = overview,
        image = posterPath,
        vote = voteAverage,
        voteCount = voteCount,
        genres = genres
    )
}