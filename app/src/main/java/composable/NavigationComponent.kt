package composable

import androidx.navigation.NavHost

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
@Composable
fun NavigationComposable(context: Context, navController: Unit) {

    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    var startDestination = Onboarding().route

    if (sharedPreferences.getBoolean("userRegistered", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding().route){
            Onboarding(context, navController)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile().route){
            Profile(context, navController)
        }
    }
}

fun composable(route: Any, function: () -> Unit) {

}

fun Onboarding() {
    TODO("Not yet implemented")
}
