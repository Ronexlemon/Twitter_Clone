package com.example.twitter_clone.drawer

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.twitter_clone.DrawerNavigationScreens
import com.example.twitter_clone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(navController:NavHostController,scope:CoroutineScope,scaffoldstate:ScaffoldState) {
    val list = listOf(
        DrawerNavigationScreens.Profile,

        DrawerNavigationScreens.Lists,
        DrawerNavigationScreens.Topics,
        DrawerNavigationScreens.Bookmarks,
        DrawerNavigationScreens.Moments,
        DrawerNavigationScreens.Monetisation,
        DrawerNavigationScreens.TwiterProf,
        DrawerNavigationScreens.Twitter_Ads,
        DrawerNavigationScreens.Setting,
        DrawerNavigationScreens.Help,
    )
    Column(verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.teal_200))
    ) {
        // Header
        Image(
            painter = painterResource(id = R.drawable.cardb),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                ,contentScale = ContentScale.Crop
        )
        // Space between
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )
        Text(text="Lemonr",modifier=Modifier.padding(start=20.dp))
        Text(text="@ronexondimu",modifier=Modifier.padding(start=20.dp))
        Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly){
            Row(){
                Text(text="76",modifier=Modifier.padding(end=2.dp))
                Text(text="Following")
            }
            Row(){
                Text(text="23",modifier=Modifier.padding(end=2.dp))
                Text(text="Followers")
            }

        }
        Divider(modifier=Modifier.height(4.dp))
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        list.forEach { routes ->
            DrawerItem(item = routes, selected = currentRoute == routes.route, onItemClick = {
                navController.navigate(routes.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }


                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldstate.drawerState.close()
                }

            })
        }
    }
}
@Composable
fun DrawerItem(item:DrawerNavigationScreens, selected: Boolean, onItemClick: (DrawerNavigationScreens)-> Unit){
    val background = if (selected) R.color.purple_200 else android.R.color.transparent
    if(item.title == "Monetisation" || item.title == "Twitter Ads"){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onItemClick(item) })
                .height(45.dp)
                .background(colorResource(id = background))
                .padding(start = 10.dp)
        ) {
            Image(
                imageVector = item.icon,
                contentDescription = item.title,
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(35.dp)
                    .width(35.dp)
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = item.title,
                fontSize = 18.sp,
                color = Color.White
            )
        }
        Divider(modifier=Modifier.height(4.dp))
    }else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onItemClick(item) })
                .height(45.dp)
                .background(colorResource(id = background))
                .padding(start = 10.dp)
        ) {
            Image(
                imageVector = item.icon,
                contentDescription = item.title,
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(35.dp)
                    .width(35.dp)
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = item.title,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }

}