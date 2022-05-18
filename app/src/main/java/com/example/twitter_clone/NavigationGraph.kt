package com.example.twitter_clone

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.twitter_clone.screens.*

@Composable
fun NavigationGraph(navcontroller:NavHostController){
    NavHost(navController = navcontroller, startDestination =NavigationScreen.Home.route ){
        composable(route=NavigationScreen.Home.route){
           HomeScreen()
        }
        composable(route=NavigationScreen.Search.route){
           SearchScreen()
        }
        composable(route=NavigationScreen.Notification.route){
           NotificationScreen()
        }
        composable(route=NavigationScreen.Inbox.route){
           InboxScreen()
        }
        //new
        composable(route=DrawerNavigationScreens.Profile.route){
            ProfileScreen()
        }
        composable(route=DrawerNavigationScreens.Lists.route){
            ListsScreen()
        }
        composable(route=DrawerNavigationScreens.Topics.route){
            TopicsScreen()
        }
        composable(route=DrawerNavigationScreens.Bookmarks.route){
            BookmarkScreen()
        }
        composable(route=DrawerNavigationScreens.Moments.route){
            MomentsScreen()
        }
        composable(route=DrawerNavigationScreens.Monetisation.route){
            MoneyScreen()
        }
        composable(route=DrawerNavigationScreens.TwiterProf.route){
            ProfScreen()
        }
        composable(route=DrawerNavigationScreens.Twitter_Ads.route){
            AdsScreen()
        }
        composable(route=DrawerNavigationScreens.Setting.route){
            SettingScreen()
        }
        composable(route=DrawerNavigationScreens.Help.route){
            HelpScreen()
        }

    }

    }


@Composable
fun HomeScreen(){
    //Todo all to viewmodel
    val nacontroller = rememberNavController()
    val scaffold = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    LandingScreen(scaffoldState = scaffold,scope=scope)
}
@Composable
fun SearchScreen(){
    LandingSearch()
}
@Composable
fun NotificationScreen(){
    LandingNotification()
}
@Composable
fun InboxScreen(){
    LandingMessage()
}


@Composable
fun ProfileScreen(){
    Profile()
}
@Composable
fun ListsScreen(){
    ListScreenNav()
}
@Composable
fun TopicsScreen(){
    //TODO
}
@Composable
fun BookmarkScreen(){
    //TODO
}
@Composable
fun MomentsScreen(){
    //TODO
}
@Composable
fun MoneyScreen(){
    //TODO
}
@Composable
fun ProfScreen(){
    //TODO
}
@Composable
fun AdsScreen(){
    //TODO
}
@Composable
fun SettingScreen(){
    //TODO
}
@Composable
fun HelpScreen(){
    //TODO
}