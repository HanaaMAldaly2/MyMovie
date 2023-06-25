package com.example.mymovie.data.remote

/**
 * Movies Service that return instance of [MoviesAPI]
 */
object MoviesCloud {
    fun getMovieServiceInstance() =
        RetrofitBuilder.getInstance().create(MoviesAPI::class.java)
}