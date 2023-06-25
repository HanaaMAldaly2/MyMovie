package com.example.mymovie.data.remote

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit

internal class MoviesCloudTest {
    @Test
    fun test_movieCloud_expectInitializeMovieCloud() {
        val retrofit = mockk<Retrofit>()
        mockkObject(RetrofitBuilder)
        every { RetrofitBuilder.getInstance() } returns retrofit
        every { retrofit.create(MoviesAPI::class.java) } just return
        MoviesCloud.getMovieServiceInstance()
        verify { retrofit.create(MoviesAPI::class.java) }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}