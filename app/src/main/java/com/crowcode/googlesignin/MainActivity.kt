package com.crowcode.googlesignin

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
                    CreatingGoogleDesign(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CreatingGoogleDesign(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 16.dp)
                .size(50.dp)
        )
        Text(
            text = "Sign In",
            style = TextStyle(
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(
                    Font(
                        R.font.google_font,
                    )
                ),
            ),
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = "Use Your Google Account",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(top = 16.dp)

        )
    }
}

@Preview(
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun CreatingGoogleDesignPreview() {
    CreatingGoogleDesign()
}


/*Greeting(
    "Emad",
    Modifier.padding(innerPadding)
)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val localContext = LocalContext.current
    Text(
        text = "Hello $name",
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            color = White
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
*/
