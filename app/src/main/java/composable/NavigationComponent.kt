package composable

import androidx.navigation.NavHost

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import my.littlelemon.navigation.Home
import my.littlelemon.navigation.Onboarding
import my.littlelemon.navigation.Profile

@Composable
fun NavigationComposable(context: Context,navController: NavHostController) {

    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    var startDestination = Onboarding.route

    if (sharedPreferences.getBoolean("userRegistered", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding.route){
            Onboarding(context, navController)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile.route){
            Profile(context, navController)
        }
    }
}
