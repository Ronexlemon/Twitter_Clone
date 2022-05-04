package com.example.twitter_clone.bottomnavigation

import androidx.compose.material.BottomDrawer
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.twitter_clone.NavigationScreen

@Composable
fun BottomNavigationBar(navController:NavHostController){
    val list = listOf(NavigationScreen.Home,NavigationScreen.Search,
    NavigationScreen.Notification,
    NavigationScreen.Inbox)

 BottomNavigation {
     val navBackStackEntry by navController.currentBackStackEntryAsState()
     val currentRoute = navBackStackEntry?.destination?.route
     list.forEach { item ->
         BottomNavigationItem(
             icon = { Icon(imageVector = item.icon, contentDescription = null) },
            selected =currentRoute == item.route,selectedContentColor = Color.White,unselectedContentColor = Color.White.copy(0.4f) ,onClick = {
            navController.navigate(item.route){
                navController.graph.startDestinationRoute?.let { screen_route->
                    popUpTo(screen_route){
                        saveState =true
                    }
                }
                launchSingleTop =true
            } })



     }

 }
}