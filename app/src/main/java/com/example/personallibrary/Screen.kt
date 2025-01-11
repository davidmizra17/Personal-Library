package com.example.personallibrary

object Screen{
    val Listing = ScreenItem("listing");
    val Detail = ScreenItem("Detail");
    val Stats = ScreenItem("statistics");
}

data class ScreenItem(val route: String);