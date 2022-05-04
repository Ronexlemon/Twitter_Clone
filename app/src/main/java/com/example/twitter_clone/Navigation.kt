package com.example.twitter_clone

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(val route:String, val icon:ImageVector,){
    object  Home:NavigationScreen("home", Icons.Default.Home)
    object  Search:NavigationScreen("search", Icons.Default.Search)
    object  Notification:NavigationScreen("notification", Icons.Default.Notifications)
    object  Inbox:NavigationScreen("inbox", Icons.Default.Email)
}

sealed class  DrawerNavigationScreens(val route:String,val icon:ImageVector,val title:String){
    object Profile:DrawerNavigationScreens("profile",Icons.Default.Person,"Profile")
    object Lists:DrawerNavigationScreens("lists",Icons.Default.List,"Lists")
    object Topics:DrawerNavigationScreens("topics",Icons.Default.Build,"Topics")
    object Bookmarks:DrawerNavigationScreens("bookmarks",Icons.Default.Person,"Bookmarks")
    object Moments:DrawerNavigationScreens("moments",Icons.Default.Person,"Moments")
    object Monetisation:DrawerNavigationScreens("money",Icons.Default.Person,"Monetisation")
    object TwiterProf:DrawerNavigationScreens("twitterProf",Icons.Default.Person,"Twitter for Professionals")
    object Twitter_Ads:DrawerNavigationScreens("twitterAds",Icons.Default.Person,"Twitter Ads")
    object Setting:DrawerNavigationScreens("setting",Icons.Default.Person,"Settings and privacy")
    object Help:DrawerNavigationScreens("help",Icons.Default.Person,"Help Center")

}
