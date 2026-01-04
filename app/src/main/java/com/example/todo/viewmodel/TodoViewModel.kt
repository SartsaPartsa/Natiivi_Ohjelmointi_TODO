package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Todo
import com.example.todo.model.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    // Muutetaan lista State-tyypiksi, jotta Compose havaitsee sen muutokset
    var todos: List<Todo> by mutableStateOf(emptyList())
        private set // Varmistetaan, että listaa voi muokata vain ViewModelin sisältä

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                // Korvataan koko lista uudella haetulla listalla.
                // Tämä laukaisee Compose-käyttöliittymän päivityksen.
                todos = TodosApi.getInstance().getTodos()
            } catch (e: Exception) {
                Log.e("TODOVIEWMODEL", "Error fetching todos: ${e.message}")
            }
        }
    }
}