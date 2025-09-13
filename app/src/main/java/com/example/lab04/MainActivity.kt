package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") } // 👉 estado para TextField

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Hello $name!")

        Button(onClick = { }) {
            Text("Click me")
        }

        // 👉 Nuevo componente: TextField
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escribe aquí") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        Greeting("Android")
    }
}
