package com.example.mymovie.domain.model

data class MovieDetails(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val vote: Float,
    val voteCount: Int,
    val genres: List<String>
) {
    val fullImagePath = "https://image.tmdb.org/t/p/original$image"
}