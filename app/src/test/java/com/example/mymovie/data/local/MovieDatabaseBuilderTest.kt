package com.example.mymovie.data.local

import android.content.Context
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Test

internal class MovieDatabaseBuilderTest {
    @Test
    fun invoke_databaseBuilder() {
        val context = mockk<Context>()
        every { context.applicationContext } returns mockk()
        assertNotNull(MovieDatabaseBuilder.getInstance(context))
    }

    @After
    fun clearMocks() {
        clearAllMocks()
    }
}