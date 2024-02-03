package coder.giz.android.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.compose_museum.ComposeMuseumMainActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.utils.launch

class TutorialMainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                TutorialMainActivityContentView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialMainActivityContentView() {
    val context = LocalContext.current
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            TopAppBar(
                title = { Text(text = "HHH") },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "KKK"
                    )
                }
            )
            Greeting("Android")
            Button(
                onClick = {
                    context launch ComposeMuseumMainActivity::class
                }
            ) {
                Text(text = "Compose Museum 教程")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    var count by remember { mutableIntStateOf(1) }
    Text(
        text = "Hello $name $count!",
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                count += 1
//                Toast
//                    .makeText(context, "HH", Toast.LENGTH_SHORT)
//                    .show()
            },
        color = Color(0xFF00FFFF)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GComposeTripTheme {
        TutorialMainActivityContentView()
    }
}