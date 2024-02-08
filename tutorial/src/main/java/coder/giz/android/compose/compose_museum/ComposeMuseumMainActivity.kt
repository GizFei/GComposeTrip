package coder.giz.android.compose.compose_museum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.compose_museum.c1_start.CMStartActivity
import coder.giz.android.compose.compose_museum.c2_basic_component.CMElementAlertDialogActivity
import coder.giz.android.compose.compose_museum.c2_basic_component.CMElementButtonActivity
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
        val context = LocalContext.current
        Column {
            TopAppBar(
                title = { Text(text = "Compose Museum 教程") }
            )

            Text(
                text = "入门",
                modifier = Modifier.padding(start = 16.dp)
            )
            Button(
                onClick = { context launch CMStartActivity::class },
                modifier = Modifier.padding(start = 24.dp)
            ) {
                Text(text = "初识 Jetpack Compose")
            }

            Text(
                text = "基础组件",
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Button(
                onClick = { context launch CMElementAlertDialogActivity::class },
                modifier = Modifier.padding(start = 24.dp),
            ) {
                Text(text = "AlertDialog")
            }
            Button(
                onClick = { context launch CMElementButtonActivity::class },
                modifier = Modifier.padding(start = 24.dp)
            ) {
                Text(text = "Button")
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewContentView() {
        ContentView()
    }

}