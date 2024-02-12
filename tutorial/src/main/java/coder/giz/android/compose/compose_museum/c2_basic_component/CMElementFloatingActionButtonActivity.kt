package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 教程链接：[FloatingActionButton](https://jetpackcompose.cn/docs/elements/floatingactionbutton)
 *
 * Created by GizFei on 2024/2/12
 */
class CMElementFloatingActionButtonActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                ContentView()
            }
        }
    }

    @Composable
    private fun ContentView() {
        var color by remember {
            mutableStateOf(Color.Red)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Button(onClick = { color = Color.Red }) {
                Text(text = "Test Button", color = color)
            }

            FloatingActionButton(
                onClick = {
                    color = Color.Blue
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }

            FloatingActionButton(
                onClick = {
                    color = Color.Blue
                },
                shape = FloatingActionButtonDefaults.largeShape,
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }

            ExtendedFloatingActionButton(
                text = { Text(text = "添加到我喜欢的") },
                icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null) },
                onClick = {
                    color = Color.Cyan
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Preview
    @Composable
    private fun PreviewContentView() {
        GComposeTripTheme {
            ContentView()
        }
    }

}