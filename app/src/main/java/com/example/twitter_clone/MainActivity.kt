package com.example.twitter_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.twitter_clone.screens.LandingScreen
import com.example.twitter_clone.screens.MainScreen
import com.example.twitter_clone.ui.theme.Twitter_CloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Twitter_CloneTheme(darkTheme =true) {
                val nacontroller = rememberNavController()
                val scaffold = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //Greeting("Android")
                   // LandingScreen()

                    MainScreen(navController =nacontroller ,scaffoldState = scaffold,scope = scope)
                }
            }
        }
    }
}

