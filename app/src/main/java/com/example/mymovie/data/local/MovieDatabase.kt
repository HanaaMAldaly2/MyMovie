package com.example.mymovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymovie.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}