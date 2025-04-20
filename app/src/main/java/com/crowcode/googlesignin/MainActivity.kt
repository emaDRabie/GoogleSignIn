package com.crowcode.googlesignin

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crowcode.googlesignin.ui.theme.GoogleSignInTheme
import com.crowcode.googlesignin.ui.theme.*
import kotlinx.coroutines.launch

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
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = "Google logo",
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
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = "Use Your Google Account",
            style = TextStyle(
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(top = 24.dp)

        )
        OutlinedTextField(
            value = text,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { text = it },
            label = { Text("Email or Phone") },
            textStyle = TextStyle(
                brush = brush,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp)
        )
        Text(
            text = "Forgot email?",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Blue,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier
                .padding(top = 8.dp, bottom = 40.dp)
        )
        val snackbarHostState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()

        val annotatedText = buildAnnotatedString {
            append("Not your computer? Use Private Browsing windows to sign in. ")

            pushStringAnnotation(tag = "LEARN_MORE", annotation = "learn_more")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.W500,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Learn more about using guest mode")
            }
            pop()
        }

        ClickableText(
            text = annotatedText,
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier.padding(top = 8.dp),
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "LEARN_MORE", start = offset, end = offset)
                    .firstOrNull()?.let {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Entered Email: $text")

                        }
                    }
            }
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Create Account",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Button(
                { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Next")
            }
        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            snackbar = { data ->
                Snackbar(
                    snackbarData = data,
                    containerColor = Color(0xFF323232), // Custom background color
                    contentColor = Color.White,         // Text color
                    shape = RoundedCornerShape(12.dp),  // Rounded corners
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
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
