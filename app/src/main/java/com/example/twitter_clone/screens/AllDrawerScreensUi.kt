package com.example.twitter_clone.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitter_clone.R
import com.example.twitter_clone.data.LandingMessageScreen

//Todo add profile screen
@Composable
fun Profile(modifier:Modifier= Modifier){
    var change by remember{ mutableStateOf(0)}
    Column(
        modifier
            .fillMaxSize()


            ){
        Row(modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.cardb),contentDescription = null,modifier.fillMaxWidth(),contentScale = ContentScale.Fit)

        }
        OutlinedButton(onClick = { /*TODO*/ },shape = RoundedCornerShape(10.dp),modifier= Modifier
            .align(Alignment.End)
            .padding(4.dp)) {
            Text(text="Edit profile",style= TextStyle(fontWeight = FontWeight.Black,fontSize = 16.sp,))
        }

        Text(modifier=Modifier.padding(start=4.dp),text="Lemonr",style=TextStyle(fontWeight = FontWeight.Bold,fontSize = 20.sp))
       Text(text="@ronexondimu",modifier.padding(start=4.dp))
        Text(text="cybersecurity ethuastic all the way up",modifier.padding(start=4.dp,top = 8.dp))

        Row(
            modifier
                .padding(start = 4.dp, top = 8.dp)
                .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
           Text(text="Nairobi",style=TextStyle(fontWeight = FontWeight.Light))
           Text(text="Kenya",style=TextStyle(fontWeight = FontWeight.Light))
           Text(text="link",style=TextStyle(fontWeight = FontWeight.Light),modifier= Modifier
               .clickable { }
               .padding(end = 4.dp))
       }
        Row(modifier.padding(start=4.dp)){
            Icon(Icons.Default.DateRange,contentDescription = null)
            Text(text="Joined June 2020")
        }
       Row(modifier.padding(start=4.dp)){
           Text(text="79 Following")
           Text(text="22 Followers",modifier.padding(start=8.dp))
       }
Row(
    modifier
        .fillMaxWidth()
        .padding(start = 4.dp, end = 4.dp, top = 4.dp),horizontalArrangement = Arrangement.SpaceBetween){
    Text(text="Tweets",modifier.clickable { change =0 })
    Text(text="Tweets & replies",modifier.clickable { change=1 })
    Text(text="Media",modifier.clickable { change =2 })
    Text(text="Likes",modifier.clickable {change =3  })
}
        when(change){
            0 -> ProfileTweets()
            1 -> ProfileTweets()
            2 -> Text(text="media")
            3 -> Text(text="likes")
        }

    }
}
@Composable
fun ProfileTweets(modifier:Modifier=Modifier){
    val list = listOf(LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
        profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
    profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
    profile = R.drawable.cardb),LandingMessageScreen(username="Jones",message="Thanks alot..i appreciate it",date="09 sep 21",
    profile = R.drawable.cardb),)
    Column{
        LazyColumn{
            items(items=list,itemContent = {item->

                ProfileTweetsItems(item = item)

            })
        }
    }
}
@Composable
fun ProfileTweetsItems(modifier:Modifier=Modifier,item:LandingMessageScreen){




            Card(
                modifier
                    .fillMaxWidth()
                    .height(200.dp), elevation = 10.dp) {
                Row(modifier.padding(start = 20.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.retweet),
                        contentDescription = null
                    )
                    Text(text = "You Retweeted", modifier.padding(start = 8.dp))
                }
                Row(modifier.padding(start=2.dp,top=20.dp)) {
                    Image(
                        painter = painterResource(id = item.profile), contentDescription = null,
                        modifier
                            .clip(
                                CircleShape
                            )
                            .padding(start = 4.dp, end = 4.dp)
                            .size(50.dp), contentScale = ContentScale.Crop
                    )
                    Column(modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceAround) {
                        Row(
                            modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = item.username,
                                modifier.padding(end = 2.dp),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                            Text(
                                text = "@${item.username}",
                                modifier.padding(end = 4.dp),
                                style = TextStyle(fontWeight = FontWeight.Light)
                            )
                            Text(text = item.date)
                        }
                        Text(modifier=Modifier.padding(start=18.dp),
                            text = item.message,
                            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Black)
                        )
                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.Bottom) {
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.inbox),
                                    contentDescription = null,modifier.align(Alignment.CenterVertically)
                                )
                                Text(text = "3,556", modifier.padding(start = 2.dp))
                            }
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.retweet),
                                    contentDescription = null,modifier.align(Alignment.CenterVertically)
                                )
                                Text(text = "11k", modifier.padding(start = 2.dp))
                            }
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.like),
                                    contentDescription = null,modifier.align(Alignment.CenterVertically)
                                )
                                Text(text = "10.3k", modifier.padding(start = 2.dp))
                            }
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.share),
                                    contentDescription = null,modifier.align(Alignment.CenterVertically)
                                )

                            }

                        }
                        Text(text="Show this thread",
                            modifier
                                .clickable { }
                                .padding(start = 18.dp),style = TextStyle(color= Color.Blue,fontSize = 16.sp))
                    }

                }


            }


}
//Lists Screen
@Composable
fun ListScreenNav(modifier:Modifier=Modifier){
    Column(modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceEvenly){
        Row(horizontalArrangement = Arrangement.SpaceBetween,modifier=Modifier.fillMaxWidth().wrapContentHeight()){
            Row{
                Icon(Icons.Default.ArrowBack,contentDescription = "back to home",modifier.align(Alignment.CenterVertically))
                Text(text="Lists",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.ExtraBold),modifier=Modifier.padding(8.dp))
            }
            Icon(Icons.Default.MoreVert,contentDescription = "lists ou're on")
        }
       Divider(modifier.height(2.dp))
        Column(
            modifier
                .fillMaxWidth()
                .wrapContentHeight(),verticalArrangement = Arrangement.SpaceBetween){
            Text(text="Pinned  Lists",style=TextStyle(fontSize = 20.sp,fontWeight = FontWeight.ExtraBold),modifier=Modifier.padding(start=2.dp,bottom = 8.dp))
            Text(text="Nothing to see here yet -pin your favourite Lists to access them quickly",style=TextStyle(fontWeight = FontWeight.ExtraLight),modifier=Modifier.padding(start=20.dp))
        }
        Divider(modifier.height(4.dp))
        Column(modifier.fillMaxWidth()){
            Text(text="Discover new Lists",style=TextStyle(fontSize = 16.sp,fontWeight = FontWeight.ExtraBold))
          DiscoverLists()
            DiscoverLists()
            DiscoverLists()
            Text(text="Show more",style=TextStyle(color=Color.Blue),modifier=Modifier.clickable {  })
        }

        Divider(modifier.height(4.dp))
        Column(
            modifier
                .fillMaxWidth()
                .wrapContentHeight(),verticalArrangement = Arrangement.SpaceBetween){
            Text(text="Your Lists",style=TextStyle(fontSize = 20.sp,fontWeight = FontWeight.ExtraBold),modifier=Modifier.padding(start=2.dp))
            Text(text="You haven't created or followed any lists.",style=TextStyle(fontWeight = FontWeight.ExtraLight),modifier=Modifier.padding(start=20.dp))
            Text(text="when you do ,they will show up here",style=TextStyle(fontWeight = FontWeight.ExtraLight),modifier=Modifier.padding(start=20.dp))
        }

    }

}
@Composable
fun DiscoverLists(modifier:Modifier=Modifier){
    Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround){
        Image(painter = painterResource(id = R.drawable.cardb), contentDescription = null,modifier.
        clip(shape= RoundedCornerShape(10.dp)).size(50.dp),
            contentScale = ContentScale.Fit)
        Column{
            Text(text="Man World",style=TextStyle(fontSize = 12.sp,fontWeight = FontWeight.ExtraBold))
            Row{
                Image(painter = painterResource(id = R.drawable.just), contentDescription = null,
                    modifier
                        .clip(CircleShape)
                        .size(20.dp),
                    contentScale = ContentScale.Crop)
                Text(text="@ron",style=TextStyle(fontWeight = FontWeight.ExtraLight))
            }

        }
        OutlinedButton(onClick = { /*TODO*/ },shape= RoundedCornerShape(15.dp)) {
            Text(text="Follow",style=TextStyle(color=Color.White))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerScreen(){
   // Profile()
    //ProfileTweets()
    ListScreenNav()
}
