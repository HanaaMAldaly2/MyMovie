package com.example.mymovie.domain.model

data class Movie(
    val id: String,
    val title: String,
    val image: String,
    val vote: Float
) {
    val fullImagePath = "https://image.tmdb.org/t/p/original$image"
}