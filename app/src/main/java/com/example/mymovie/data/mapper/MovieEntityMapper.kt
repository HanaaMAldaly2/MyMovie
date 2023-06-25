package com.example.mymovie.data.mapper

import com.example.mymovie.data.model.MovieEntity
import com.example.mymovie.domain.model.Movie

fun List<MovieEntity>.map(): List<Movie> = map {
    Movie(
        it.id,
        it.title,
        it.image,
        it.vote
    )
}

fun Movie.map() = MovieEntity(id, title, image, vote)
