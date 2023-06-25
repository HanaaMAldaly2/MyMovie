package com.example.mymovie.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mymovie.data.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    suspend fun getAll(): List<MovieEntity>

    @Insert
    suspend fun insert(movie: MovieEntity)

}