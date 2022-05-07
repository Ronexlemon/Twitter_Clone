package com.example.twitter_clone

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(val route:String, val icon:Int,){
    object  Home:NavigationScreen("home", icon=R.drawable.home)
    object  Search:NavigationScreen("search", icon=R.drawable.search1)
    object  Notification:NavigationScreen("notification", icon=R.drawable.notification)
    object  Inbox:NavigationScreen("inbox", R.drawable.inbox)
}

sealed class  DrawerNavigationScreens(val route:String,val icon:Int,val title:String){
    object Profile:DrawerNavigationScreens("profile",icon=R.drawable.person,"Profile")
    object Lists:DrawerNavigationScreens("lists",icon=R.drawable.list,"Lists")
    object Topics:DrawerNavigationScreens("topics",icon=R.drawable.topic,"Topics")
    object Bookmarks:DrawerNavigationScreens("bookmarks",icon=R.drawable.bookmark,"Bookmarks")
    object Moments:DrawerNavigationScreens("moments",icon=R.drawable.moments,"Moments")
    object Monetisation:DrawerNavigationScreens("money",icon=R.drawable.money,"Monetisation")
    object TwiterProf:DrawerNavigationScreens("twitterProf",icon=R.drawable.twiterprof,"Twitter for Professionals")
    object Twitter_Ads:DrawerNavigationScreens("twitterAds",icon=R.drawable.adds,"Twitter Ads")
    object Setting:DrawerNavigationScreens("setting",icon=R.drawable.topic,"Settings and privacy")
    object Help:DrawerNavigationScreens("help",icon=R.drawable.topic,"Help Center")

}
