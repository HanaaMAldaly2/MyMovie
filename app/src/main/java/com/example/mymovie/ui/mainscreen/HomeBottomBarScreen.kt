package com.example.mymovie.ui.mainscreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mymovie.R

sealed class HomeBottomBarScreen(
    val route: String,
    val title: Int,
    val icon: ImageVector
) {
    object Movies : HomeBottomBarScreen(
        route = "movies",
        title = R.string.movies_tab_title,
        icon = Icons.Default.Home
    )

    object SearchMovies : HomeBottomBarScreen(
        route = "search",
        title = R.string.search_movies_title,
        icon = Icons.Default.Search
    )

    object TopRatedMovies : HomeBottomBarScreen(
        route = "top-rated",
        title = R.string.top_rated_movies_title,
        icon = Icons.Default.Star
    )

    object FavoriteMovies : HomeBottomBarScreen(
        route = "favorite",
        title = R.string.favorite_movies_title,
        icon = Icons.Default.Favorite
    )
}
