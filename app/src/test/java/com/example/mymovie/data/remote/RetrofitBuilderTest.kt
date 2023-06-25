package com.example.mymovie.data.remote

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.verifyOrder
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class RetrofitBuilderTest {
    @Test
    fun test_retrofitBuilder() {
        mockkConstructor(Retrofit.Builder::class)
        every { anyConstructed<Retrofit.Builder>().build() } returns mockk()
        RetrofitBuilder.getInstance()
        verifyOrder {
            anyConstructed<Retrofit.Builder>().baseUrl(RetrofitBuilder.BASE_URL)
            anyConstructed<Retrofit.Builder>().client(any())
            anyConstructed<Retrofit.Builder>().addConverterFactory(any<GsonConverterFactory>())
            anyConstructed<Retrofit.Builder>().build()
        }
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }

}