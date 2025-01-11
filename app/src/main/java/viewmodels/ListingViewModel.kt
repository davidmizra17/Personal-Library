package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.entities.BookEntity
import data.repositories.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel(){
    //'private' because it will only be modified by the viewmodel
    private val _bookList = MutableStateFlow<List<BookEntity>>(emptyList());
    //public and exposes the stateflow to the UI so it can observe any changes made to the model
    val bookList: StateFlow<List<BookEntity>> = _bookList

    init{
        fetchBooks()
    }

    private fun fetchBooks(){
        viewModelScope.launch {
            repository.getBooks()
                .collect{ books ->
                    _bookList.value = books

            }
        }
    }



}