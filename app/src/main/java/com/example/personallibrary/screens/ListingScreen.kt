package com.example.personallibrary.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import viewmodels.ListingViewModel

@Composable
fun ListingScreen(viewModel: ListingViewModel = hiltViewModel()){
    val books by viewModel.bookList.collectAsState()

    LazyColumn {
        items(books) { book ->
            Text(text = book.title)
        }
    }
}