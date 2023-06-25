package com.example.mymovie.ui.mainscreen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mymovie.ui.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController) })
    {
        HomeNavGraphScreen(viewModel, it, navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val screens = listOf(
        HomeBottomBarScreen.Movies,
        HomeBottomBarScreen.SearchMovies,
        HomeBottomBarScreen.TopRatedMovies,
        HomeBottomBarScreen.FavoriteMovies
    )
    NavigationBar() {

        screens.forEach {
            Item(
                screen = it,
                currentDestination = navBackStackEntry.value?.destination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.Item(
    screen: HomeBottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    NavigationBarItem(
        label = {
            Text(text = stringResource(id = screen.title))
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = ""
            )
        },
        selected =
        currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
    )
}