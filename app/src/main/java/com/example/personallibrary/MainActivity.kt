package com.example.personallibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personallibrary.screens.ListingScreen
import com.example.personallibrary.ui.theme.PersonalLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = rememberNavController(),
                        startDestination = com.example.personallibrary.Screen.Listing,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable(com.example.personallibrary.Screen.Listing.route){
                            ListingScreen()
                        }
//                        composable(com.example.personallibrary.Screen.Detail.route){
//                            DetailScreen()
//                        }
//                        composable(com.example.personallibrary.Screen.Stats.route){
//                            StatsScreen()
//                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersonalLibraryTheme {
        Greeting("Android")
    }
}