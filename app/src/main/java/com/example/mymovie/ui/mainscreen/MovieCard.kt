package com.example.mymovie.ui.mainscreen

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.ui.details.MOVIE_ID_KEY
import com.example.mymovie.ui.details.MovieDetailsActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(movie: Movie, addMovieAsFavoriteEvent: ((Movie) -> Unit)? = null) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            context.startActivity(Intent(context, MovieDetailsActivity::class.java)
                .apply {
                    putExtra(MOVIE_ID_KEY, movie.id)
                })
        }) {
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

                addMovieAsFavoriteEvent?.let {
                    IconButton(onClick = {
                        it.invoke(movie)

                    }) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Add to favorite",
                            tint = Color.LightGray
                        )
                    }
                }
            }
        }
    }
} 
