package com.example.hw5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp() {
    var tasks by remember { mutableStateOf(listOf("Купить молоко", "Позвонить другу")) }
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("Новая задача") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    tasks = tasks + newTask
                    newTask = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Добавить")
        }
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(tasks) { task ->
                Text(task, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoApp() {
    TodoApp()
}

//NEW