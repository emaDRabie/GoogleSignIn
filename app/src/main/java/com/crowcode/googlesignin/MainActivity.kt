package com.crowcode.googlesignin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crowcode.googlesignin.ui.theme.GoogleSignInTheme
import com.crowcode.googlesignin.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleSignInTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        "Emad",
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val localContext = LocalContext.current
    Text(
        text = "Hello $name",
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            color = Black
        ),
        modifier = modifier
            .padding(start = 32.dp, top = 64.dp)
            .background(Green, CircleShape)
            .padding(all = 32.dp)
            .clickable {
                Toast
                    .makeText(localContext, "Don not press the text :)", Toast.LENGTH_SHORT)
                    .show()
            }
    )

}

