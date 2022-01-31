package com.coolapps.jetweather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.coolapps.jetweather.screens.about.AboutScreen
import com.coolapps.jetweather.screens.main.MainScreen
import com.coolapps.jetweather.screens.main.MainViewModel
import com.coolapps.jetweather.screens.setting.SettingScreen
import com.coolapps.jetweather.screens.splash.WeatherSplashScreen
import com.coolapps.weatherapp.screens.favorites.FavoriteScreen
import com.coolapps.weatherapp.screens.search.SearchScreen

@ExperimentalComposeUiApi
@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name ){
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }
        //After search Screen
        //www.google.com/cityname= "seattle"
        val route = WeatherScreens.MainScreen.name
        //composable(WeatherScreens.MainScreen.name){
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                }
            )){navBack ->
            navBack.arguments?.getString("city").let {city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel,
                    city = city)
            }

        }
        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.SettingsScreen.name) {
            SettingScreen(navController = navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            FavoriteScreen(navController = navController)
        }
    }
}