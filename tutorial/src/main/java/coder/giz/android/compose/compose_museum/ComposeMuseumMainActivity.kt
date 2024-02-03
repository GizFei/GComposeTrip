package coder.giz.android.compose.compose_museum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import coder.giz.android.compose.compose_museum.c1_start.CMStartActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.utils.launch

/**
 * Created by GizFei on 2024/2/1
 */
class ComposeMuseumMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                ContentView()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ContentView() {
        Column {
            TopAppBar(
                title = { Text(text = "Compose Museum 教程") }
            )
            Button(onClick = { this@ComposeMuseumMainActivity launch CMStartActivity::class }) {
                Text(text = "初识 Jetpack Compose")
            }
        }
    }

}