package com.example.twitter_clone.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
//import com.example.twitter_clone.DrawerNavigation
import com.example.twitter_clone.NavigationGraph
import com.example.twitter_clone.NavigationScreen
import com.example.twitter_clone.R
import com.example.twitter_clone.bottomnavigation.BottomNavigationBar
import com.example.twitter_clone.data.LandingMessageScreen
import com.example.twitter_clone.data.LandingNotificationScreen

import com.example.twitter_clone.data.LandingScreenData
import com.example.twitter_clone.data.LandingSearchTrend
import com.example.twitter_clone.drawer.Drawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navController:NavHostController,scaffoldState:ScaffoldState,scope:CoroutineScope){
    val modalBottomSheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)



    Scaffold(
        scaffoldState= scaffoldState,

        drawerContent = {
                        Drawer(navController = navController, scope =scope , scaffoldstate = scaffoldState)
        },
//        topBar = {
//                AppBar(scope = scope,scaffoldState = scaffoldState)
//       },
        floatingActionButton = {
            FloatingButton(scope = scope,modalBottomSheetState = modalBottomSheetState)

        },

        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ){
       // DrawerNavigation(navcontroller = navController)
        NavigationGraph(navcontroller = navController)
        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {

Sheet()
            }
        ) {
            Text("hello")
        }

    }
   // LandingScreen()


}
@Composable
fun AppBar(modifier:Modifier=Modifier,scope: CoroutineScope,scaffoldState: ScaffoldState){

    TopAppBar(title = {Text(text="twitter")},  navigationIcon = {
        Row(horizontalArrangement = Arrangement.SpaceEvenly,verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.cardb),contentDescription = null,
                modifier
                    .clip(
                        CircleShape
                    )
                    .size(50.dp)
                    .clickable {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },contentScale = ContentScale.Crop)


        }

    },
        backgroundColor = MaterialTheme.colors.primary
    )


}
@Composable

fun LandingScreen(scope: CoroutineScope,scaffoldState: ScaffoldState){
    val list = listOf<LandingScreenData>(
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),  LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"),
        LandingScreenData(R.drawable.cardb,R.drawable.twitter,"ronex","sahfashfsh"))
    Column {

 LandingScreencontent(list =list,scope = scope,scaffoldState = scaffoldState )
    }
}
@Composable
fun LandingScreencontent(modifier:Modifier=Modifier,list:List<LandingScreenData>,scope:CoroutineScope,scaffoldState: ScaffoldState){

    Row(horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically,modifier= Modifier
        .fillMaxWidth()
        .height(60.dp)){
        Image(painter = painterResource(id = R.drawable.cardb),contentDescription = null,
            modifier
                .clip(
                    CircleShape
                )
                .size(50.dp)
                .clickable {


                },contentScale = ContentScale.Crop)
        Icon(painter = painterResource(id = R.drawable.twitter),contentDescription = null)
        Column(verticalArrangement = Arrangement.SpaceBetween,modifier=Modifier.padding(8.dp)){
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null
            )
        }



    }

    LazyColumn{
        items(items=list,itemContent = {item ->

LandingRecyclerviewContent(data = item)
            Divider(modifier = Modifier.height(2.dp))

        })
    }
}

@Composable
fun LandingRecyclerviewContent(data:LandingScreenData,modifier: Modifier =Modifier){
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentSize()){
        Row(modifier.fillMaxSize()) {
            Image(painter = painterResource(id = data.userimage), contentDescription = null,
                modifier
                    .align(Alignment.Top)
                    .padding(4.dp)
                    .size(size = 60.dp)
                    .clip(shape = CircleShape),contentScale = ContentScale.Crop)
            Text(text = data.username,
                modifier
                    .padding(4.dp)
                    .wrapContentSize())
            Column(modifier.fillMaxHeight(),verticalArrangement = Arrangement.SpaceAround) {
                Text(text = data.text,
                    modifier
                        .padding(16.dp)
                        .wrapContentSize())
                Card(
                    modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .wrapContentSize(),shape = RoundedCornerShape(10.dp),elevation = 10.dp){
                    Image(painter = painterResource(id = data.image), contentDescription = null,modifier.size(width = 300.dp,height = 400.dp))
                }

                Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier= Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp)) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly){
                        IconButton(onClick = { /*TODO*/ },modifier.size(30.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.reply),
                                contentDescription = null
                            )}
                        Text(text="700",
                            modifier
                                .align(Alignment.CenterVertically)
                                .size(height = 20.dp, width = 30.dp))
                    }

                    Row(horizontalArrangement = Arrangement.SpaceEvenly){
                        IconButton(onClick = { /*TODO*/ },modifier.size(30.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.retweet),
                                contentDescription = null
                            )}
                        Text(text="700",
                            modifier
                                .align(Alignment.CenterVertically)
                                .size(height = 20.dp, width = 30.dp))
                    }
                    Row(horizontalArrangement = Arrangement.SpaceEvenly){
                        IconButton(onClick = { /*TODO*/ },modifier.size(30.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.like),
                                contentDescription = null
                            )

                        }
                        Text(text="700",
                            modifier
                                .align(Alignment.CenterVertically)
                                .size(height = 20.dp, width = 30.dp))
                    }
                        Row(horizontalArrangement = Arrangement.SpaceEvenly){
                            IconButton(onClick = { /*TODO*/ },modifier.size(30.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.share),
                                    contentDescription = null
                                )

                            }

                        }



                        }
                    }
                }

            }
        }

@Composable
fun LandingSearch(modifier:Modifier=Modifier){
    //TODO change the state to viewmodel
    var searchTerm by rememberSaveable{ mutableStateOf("")}
    Column(modifier.fillMaxSize()){


        Column(
            modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.cardb),
                    contentDescription = null,
                    modifier
                        .clip(
                            CircleShape
                        )
                        .size(50.dp)
                        .padding(top = 8.dp, start = 2.dp, bottom = 4.dp),
                    contentScale = ContentScale.Crop
                )

                OutlinedTextField(value = searchTerm,
                    onValueChange = { searchTerm = it },
                    modifier = Modifier
                        .padding(8.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(15.dp),
                    label = {
                        Text(
                            text = "Search Twitter",
                            modifier
                                .align(Alignment.CenterVertically)
                                .padding(2.dp)
                        )
                    })


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Settings, contentDescription = null,
                        modifier
                            .size(30.dp)
                            .padding(8.dp))

                }


            }
            Box(
                modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cardb),
                    contentDescription = null,
                    modifier.fillMaxSize(1f)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Text(text = "Sports.Live")
                    Text(text = "Happy birthday,Ronex")
                    Image(
                        painter = painterResource(id = R.drawable.cardb),
                        contentDescription = null,
                        modifier.size(20.dp)
                    )
                }

            }



        }
        //Todo Lazy Column
        Column(modifier.fillMaxSize()) {
            Text(
                text = "Trends for you",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 0.dp, bottom = 8.dp)
            )
            LandingSearchRecycler()
        }
    }
}
@Composable
fun LandingSearchRecycler(){
    val listSearch = listOf<LandingSearchTrend>(LandingSearchTrend(topic="Trending in politics",what = "Putin's Door",tweets="8,8993k  Tweets"),
        LandingSearchTrend(topic="Trending in Football",what = "Mane",tweets="45,697k  Tweets"),
        LandingSearchTrend(topic="Trending in Kenya",what = "Muturi",tweets="68,686k  Tweets"),
        LandingSearchTrend(topic="Trending in Kenya",what = "Paypal",tweets="88,993k  Tweets"),
        LandingSearchTrend(topic="Trending in politics",what = "Biden",tweets="8,8993  Tweets"),
    )
    LazyColumn{
        items(items=listSearch,itemContent = {item->
            //TODO Populate the items
            TrendingSearchItems(list = item)
        })
    }
}
@Composable
fun TrendingSearchItems(modifier:Modifier=Modifier,list:LandingSearchTrend){
    Row(modifier.fillMaxWidth()){
        Row(horizontalArrangement = Arrangement.SpaceBetween,modifier=Modifier.fillMaxWidth()){


            Column{
                Text(text=list.topic,style= TextStyle(fontSize = 10.sp),fontWeight = FontWeight.Light)
                Text(text=list.what,style= TextStyle(fontSize = 20.sp,fontWeight = FontWeight.Bold))
                Text(text=list.tweets)
            }
            Icon(imageVector = Icons.Default.MoreVert,contentDescription = null)

        }

    }

}
@Composable
fun LandingNotification(modifier:Modifier=Modifier){
    Column(modifier.fillMaxSize()){
        Column(modifier.fillMaxWidth()){
            Row(
                modifier
                    .fillMaxWidth()
                    .height(50.dp),horizontalArrangement = Arrangement.SpaceBetween){
                Image(painter= painterResource(id = R.drawable.cardb),contentDescription = null,
                    modifier
                        .clip(
                            CircleShape
                        )
                        .padding(top = 4.dp, start = 2.dp, bottom = 8.dp)
                        .size(40.dp)
                        ,contentScale = ContentScale.Crop)
                Text(text="Notifications",modifier.padding(top = 4.dp, start = 2.dp, bottom = 8.dp))
                Icon(imageVector = Icons.Default.Settings,contentDescription = null,
                    modifier
                        .size(30.dp)
                        .padding(top = 4.dp, end = 4.dp, bottom = 8.dp))
            }
            Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly){
                Text(text="All",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Light))
                Text(text="Mentions",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Light))
            }
        }
        // Add recyclerview to populate notification page
        NotificationRecycler()

    }
}
@Composable //lazycolumn to populate the notification screen
fun NotificationRecycler(){
    val list = listOf(LandingNotificationScreen(username = "john",text="followed you",userImage =R.drawable.cardb,icon = Icons.Default.Person),
        LandingNotificationScreen(username = "john",text="followed you",userImage =R.drawable.cardb,icon = Icons.Default.Person))
    LazyColumn{
        items(items=list,itemContent = {item->
            //Create recycler items
            Divider(modifier=Modifier.height(4.dp))

            NofiticationItem(data=item)
        })
    }
}
@Composable
fun NofiticationItem(modifier:Modifier=Modifier,data:LandingNotificationScreen){
    Column(
        modifier
            .fillMaxWidth()
            .wrapContentSize()){
        Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier=Modifier.padding(start=15.dp)){
            Icon(imageVector = data.icon,contentDescription = null)
            Spacer(modifier.width(4.dp))
            Text(text=data.username,style=TextStyle(fontWeight = FontWeight.Bold,fontSize = 14.sp))
            Spacer(modifier.width(2.dp))
            Text(text=data.text)
        }
        Card(
            modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 20.dp),elevation = 15.dp,shape= RoundedCornerShape(8.dp)){
            Column(modifier.fillMaxSize()){
                Row(horizontalArrangement = Arrangement.SpaceBetween,modifier=Modifier.fillMaxWidth()){
                    Image(painter = painterResource(id = data.userImage), contentDescription ="userimage",
                        modifier
                            .padding(2.dp)
                            .clip(
                                CircleShape
                            )
                            .size(50.dp),contentScale = ContentScale.Crop )
                    Button(onClick = {
                                     //TODo implement follow button
                    }, shape = RoundedCornerShape(15.dp),modifier=Modifier.padding(4.dp),colors=ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                        Text(text="Follow",style=TextStyle(fontSize = 18.sp,color = Color.White))
                    }
                }
                Text(text=data.username,style=TextStyle(fontSize = 18.sp))
                Text(text="@${data.username}",style=TextStyle(fontSize = 18.sp))
                Text(modifier=Modifier.wrapContentSize(),text=data.text,style=TextStyle(fontSize = 18.sp))

            }
        }
    }

}
@Composable
fun LandingMessage(modifier:Modifier=Modifier){
    var searchTermPeople by rememberSaveable{ mutableStateOf("")}
    Column(modifier.fillMaxSize()){
        Column{
            Row {
                Image(
                    painter = painterResource(id = R.drawable.cardb),
                    contentDescription = null,
                    modifier
                        .clip(
                            CircleShape
                        )
                        .size(50.dp)
                        .padding(top = 8.dp, start = 2.dp, bottom = 4.dp),
                    contentScale = ContentScale.Crop
                )

                OutlinedTextField(value = searchTermPeople,
                    onValueChange = { searchTermPeople = it },
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentSize(),
                    shape = RoundedCornerShape(15.dp),
                    label = {
                        Text(
                            text = "Search for people and groups",
                            modifier
                                .align(Alignment.CenterVertically)
                                .padding(2.dp)
                        )
                    })


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Settings, contentDescription = null,
                        modifier
                            .size(40.dp)
                            .padding(8.dp))

                }


            }
            //Todo implemeting lazycolumn for the messages
            LandingMessageRecycler()
        }

    }
}
@Composable
fun LandingMessageRecycler(){
    val list = listOf(LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
    profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
        profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
        profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
        profile = R.drawable.cardb),)
    LazyColumn{
        items(items=list,itemContent = {item->
            //Todo implement item layout
            LandingMessageItem(data = item)
        })
    }
}
@Composable
fun LandingMessageItem(modifier:Modifier=Modifier,data:LandingMessageScreen){
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentSize().padding(bottom = 8.dp)){
        Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = data.profile),contentDescription ="profile",
                modifier
                    .clip(
                        CircleShape
                    )
                    .padding(top = 4.dp, start = 2.dp)
                    .size(60.dp),contentScale = ContentScale.Crop)
           
            Column(modifier.fillMaxWidth()){
                Row(
 modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text="${data.username}",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Bold))
                    Text(text="@${data.username}",style=TextStyle(fontSize = 12.sp,fontWeight = FontWeight.Light))
                    Text(text="${data.date}",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Light),modifier=Modifier.padding(end=2.dp))
                }
                Text(text="${data.message}",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.Light),modifier=Modifier.padding(start=4.dp,top=2.dp))
            }
        }
        
        
        
    }
    
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FloatingButton(scope:CoroutineScope,modalBottomSheetState: ModalBottomSheetState){
    ExtendedFloatingActionButton(text = { Icon(Icons.Default.Add,contentDescription = null,modifier= Modifier
        .clip(
            CircleShape
        )
        .size(25.dp)) }, onClick = { scope.launch { modalBottomSheetState.show() } },modifier= Modifier
        .clip(CircleShape)
        .size(60.dp)
        .background(color = Color.Blue))

}
@Composable
fun Sheet(){
    Column(verticalArrangement = Arrangement.SpaceBetween,modifier= Modifier
        .fillMaxWidth()
        .background(color = Color.White) ){
        Row(modifier=Modifier.align(Alignment.End)) {
            Text(text = "Spaces")
            ExtendedFloatingActionButton(text = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }, onClick = { /*TODO*/ },modifier= Modifier
                .clip(CircleShape)
                .size(60.dp)
                .background(color = Color.Blue))
        }
        Row(modifier=Modifier.align(Alignment.End)){
            Text(text = "Photos")
            ExtendedFloatingActionButton(text = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }, onClick = { /*TODO*/ },modifier= Modifier
                .clip(CircleShape)
                .size(60.dp)
                .background(color = Color.Blue))
        }
        Row( modifier=Modifier.align(Alignment.End)) {
            Text(text = "Gif")
            ExtendedFloatingActionButton(text = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }, onClick = { /*TODO*/ },modifier= Modifier
                .clip(CircleShape)
                .size(60.dp)
                .background(color = Color.Blue))
        }
        Row(modifier=Modifier.align(Alignment.End)) {
            Text(text = "Tweet")
            ExtendedFloatingActionButton(text = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }, onClick = { /*TODO*/ },modifier= Modifier
                .clip(CircleShape)
                .size(60.dp)
                .background(color = Color.Blue))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowAll(){
    //LandingScreen()
   //  LandingSearch()
   // LandingSearchRecycler()
    //LandingNotification()
    LandingMessage()
   // NotificationRecycler()
}