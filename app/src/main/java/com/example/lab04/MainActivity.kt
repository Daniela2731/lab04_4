package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.R

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
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        // 👉 Aquí hicimos el cambio distinto (rama conflicto-rama)
        Text(text = "Hola desde conflicto-rama")

        // 👉 Button con estilo (primer componente)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            )
        ) {
            Text(
                "Click Me!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 👉 TextField (segundo componente)
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escribe aquí") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 👉 Image (tercer componente modificado con estilo)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo Android",
            modifier = Modifier
                .size(120.dp) // tamaño fijo
                .padding(top = 16.dp)
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
