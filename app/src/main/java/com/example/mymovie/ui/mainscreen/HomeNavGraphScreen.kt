package com.example.mymovie.ui.mainscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mymovie.ui.HomeViewModel

@Composable
fun HomeNavGraphScreen(
    viewModel: HomeViewModel,
    padding: PaddingValues, navController: NavHostController
) {
    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = HomeBottomBarScreen.Movies.route
    ) {
        composable(route = HomeBottomBarScreen.Movies.route) {
            MoviesScreen(viewModel)
        }
        composable(route = HomeBottomBarScreen.SearchMovies.route) {
            SearchScreen(viewModel)
        }
        composable(route = HomeBottomBarScreen.TopRatedMovies.route) {
            TopRatedMoviesScreen(viewModel)
        }
        composable(route = HomeBottomBarScreen.FavoriteMovies.route) {
            FavoriteMoviesScreen(viewModel)
        }
    }

}