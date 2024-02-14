package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementIconButtonActivity : ComponentActivity() {

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
        Row {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            }

            IconButton(onClick = {}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }

            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Done, contentDescription = null)
            }
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