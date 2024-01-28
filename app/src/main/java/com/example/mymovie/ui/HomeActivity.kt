package com.example.mymovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovie.data.local.MovieDatabaseBuilder
import com.example.mymovie.data.repository.FavoriteMoviesRepoImpl
import com.example.mymovie.data.repository.MoviesRepositoryImpl
import com.example.mymovie.domain.interactors.AddMovieAsFavoriteUseCase
import com.example.mymovie.domain.interactors.FavoriteMoviesUseCase
import com.example.mymovie.domain.interactors.MoviesByKeyUseCase
import com.example.mymovie.domain.interactors.MoviesUseCase
import com.example.mymovie.domain.interactors.TopRatedMoviesUseCase
import com.example.mymovie.ui.mainscreen.HomeScreen
import com.example.mymovie.ui.theme.MyMovieTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>() {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repo = MoviesRepositoryImpl()
                
                val favoriteMoviesRepo =
                    FavoriteMoviesRepoImpl(MovieDatabaseBuilder.getInstance(this@MainActivity))
                return HomeViewModel(
                    MoviesUseCase(repo),
                    TopRatedMoviesUseCase(repo),
                    MoviesByKeyUseCase(repo),
                    FavoriteMoviesUseCase(favoriteMoviesRepo),
                    AddMovieAsFavoriteUseCase(favoriteMoviesRepo)
                ) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieTheme {
                HomeScreen(viewModel)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HomeScreen(viewModel)
    }
}
