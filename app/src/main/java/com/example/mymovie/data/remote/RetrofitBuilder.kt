package com.example.mymovie.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO this class contains keys & URLs that shouldn't be hard coded and shared like this ^_^


/**
 * Helper to get single instance of Retrofit, add authentication headers & Json converter
 */
object RetrofitBuilder {
    internal const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getInstance() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient().newBuilder()
                .addInterceptor {
                    val request = it.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzODZhODdlMjZiOTI1MTExN2U5ZDVhNjBiOGVkZTgyYiIsInN1YiI6IjVjYTdjMThhOTI1MTQxNTY1Y2ZjOWYwMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.JtCPi0COOnQPqafexDmLeMEKuhAadhyD0E3TSYVzONA"
                        )
                        .addHeader("accept", "application/json")
                        .build()
                    it.proceed(request)
                }
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}