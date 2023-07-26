package Helper

import Data.AppDatabase
import Data.MenuItemNetwork
import Data.MenuNetwork
import android.net.http.HttpResponseCache
import java.io.File

fun validateRegData(firstName:String, lastName: String, email: String): Boolean{
    var validated = false

    if(firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()){
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
            validated = true
    }

    return validated
}


suspend fun fetchMenu(url: String): List<MenuItemNetwork> {
    val httpClient = HttpClient(Android){
        val ContentNegotiation
        install(ContentNegotiation){
            json(contentType = ContentType("text", "plain"))
        }
    }
    val  httpResponse: MenuNetwork = httpClient.get(url).body()
    return httpResponse.items
}

fun json(contentType: Any) {

}

fun install(contentNegotiation: File?, function: () -> Unit): HttpResponseCache? {

}


fun saveMenuToDatabase(database: AppDatabase, menuItemsNetwork: List<MenuItemNetwork>) {
    val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
    database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
}