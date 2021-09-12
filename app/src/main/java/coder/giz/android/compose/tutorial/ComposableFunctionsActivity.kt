package coder.giz.android.compose.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import coder.giz.android.compose.R
import coder.giz.android.compose.Tutorial

/**
 * Created by GizFei on 2021/9/12
 */
@Tutorial(lesson = 1)
class ComposableFunctionsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Compose")
        }
    }

}

// 创建Composable函数
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}

// 预览
@Preview(
    name = "ComposableFunctionsPreview",
    group = "TutorialPreviewGroup",
    locale = "zh",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFF1B3CFF,
    device = Devices.PIXEL_2
)
@Composable
fun ComposableFunctionsPreview() {
    MessageCard(name = "Jetpack Compose App: ${R.string.app_name}")
}