package com.example.mymovie.ui.details

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.example.mymovie.data.repository.MoviesRepositoryImpl
import com.example.mymovie.domain.interactors.MovieDetailsUseCase
import com.example.mymovie.domain.model.MovieDetails
import com.example.mymovie.ui.theme.MyMovieTheme

const val MOVIE_ID_KEY = "movie-id"

class MovieDetailsActivity : ComponentActivity() {
    private val viewModel by viewModels<MovieDetailsViewModel>() {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MovieDetailsViewModel(
                    MovieDetailsUseCase(MoviesRepositoryImpl()),
                    movieId = intent.extras?.getString(MOVIE_ID_KEY) ?: ""
                ) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieTheme {
                val movieDetails by viewModel.movieObservable.collectAsState(initial = null)
                movieDetails?.let {
                    MovieDetailsScreen(movie = it)
                }
            }
        }
    }

    @Composable
    fun MovieDetailsScreen(movie: MovieDetails) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .height(200.dp),
                model = movie.fullImagePath,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    AsyncImage(
                        modifier = Modifier
                            .height(200.dp),
                        model = movie.fullImagePath,
                        contentDescription = "",
                        contentScale = ContentScale.Inside
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = movie.title,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
                        )
                        Row() {
                            Icon(
                                Icons.Default.Star, contentDescription = null,
                            )
                            Text(
                                text = "${movie.vote}",
                                fontSize = 20.sp
                            )
                        }

                    }

                }
                Text(
                    text = movie.description,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
                )
            }
        }
    }
}