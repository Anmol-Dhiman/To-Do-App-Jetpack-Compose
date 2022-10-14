package com.example.to_doapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController

import com.example.to_doapp.utils.Constants.SPLASH_SCREEN
import com.example.to_doapp.navigation.destinations.listComposable
import com.example.to_doapp.navigation.destinations.splashComposable
import com.example.to_doapp.navigation.destinations.taskComposable
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list
        )
        taskComposable(
            navigateToListScreen = screen.task
        )
    }
}