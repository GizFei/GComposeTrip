package coder.giz.android.compose.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 带Toolbar的基类Activity。
 *
 * Created by GizFei on 2024/2/14
 */
abstract class TutorialBaseActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                Column {
                    TopAppBar(
                        title = { Text(text = getToolbarTitle()) }
                    )
                    ContentView()
                }
            }
        }
    }

    protected abstract fun getToolbarTitle(): String

    @Composable
    protected abstract fun ContentView()

}