package com.example.twitter_clone

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.twitter_clone.screens.LandingScreen
import com.example.twitter_clone.screens.LandingSearch

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
    //TODO
}
@Composable
fun InboxScreen(){
    //TODO
}

@Composable
fun DrawerNavigation(navcontroller: NavHostController){
    NavHost(navController=navcontroller, startDestination =DrawerNavigationScreens.Profile.route ){
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
fun ProfileScreen(){
    //TODO
}
fun ListsScreen(){
    //TODO
}
fun TopicsScreen(){
    //TODO
}

fun BookmarkScreen(){
    //TODO
}
fun MomentsScreen(){
    //TODO
}
fun MoneyScreen(){
    //TODO
}
fun ProfScreen(){
    //TODO
}
fun AdsScreen(){
    //TODO
}
fun SettingScreen(){
    //TODO
}
fun HelpScreen(){
    //TODO
}