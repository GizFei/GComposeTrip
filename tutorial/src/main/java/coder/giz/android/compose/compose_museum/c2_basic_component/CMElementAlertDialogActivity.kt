package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coder.giz.android.compose.R
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2024/2/4
 */
class CMElementAlertDialogActivity : ComponentActivity() {

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
        val showCustomAlertDialog = remember { mutableStateOf(false) }
        CustomAlertDialog(showCustomAlertDialog)

        val showCustomDialog = remember { mutableStateOf(false) }
        CustomDialog(showCustomDialog)

        val showCustomFullscreenDialog = remember { mutableStateOf(false) }
        CustomFullscreenDialog(showCustomFullscreenDialog)

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { showCustomAlertDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(text = "弹出CustomAlertDialog")
            }

            Button(
                onClick = { showCustomDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(text = "弹出CustomDialog")
            }

            Button(
                onClick = { showCustomFullscreenDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(text = "弹出CustomFullscreenDialog")
            }
        }

    }

    @Composable
    fun CustomAlertDialog(showDialog: MutableState<Boolean>) {
        if (showDialog.value) {
            AlertDialog(
                // shadow: 添加阴影
                modifier = Modifier.shadow(16.dp, RoundedCornerShape(16.dp), spotColor = Color.Blue),
                onDismissRequest = {
                    showDialog.value = false
                },
                confirmButton = {
                    TextButton(
                        onClick = { showDialog.value = false },
                    ) {
                        Text(
                            text = "确认",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog.value = false },
                    ) {
                        Text(
                            text = "取消",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                },
                title = {
                    Text(
                        text = "开启位置服务",
                        fontWeight = FontWeight.W700,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                text = {
                    Text(
                        text = "这将意味着，我们会给您提供精准的位置服务，并且您将接受关于您订阅的位置信息",
                        fontSize = 16.sp,
                    )
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.compose_museum_logo),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }
            )
        }
    }

    @Composable
    fun CustomDialog(showDialog: MutableState<Boolean>) {
        if (showDialog.value) {
            Dialog(
                onDismissRequest = { showDialog.value = false },
            ) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .shadow(16.dp)
                        // 不加背景效果很奇怪
                        .background(Color.White, shape = RoundedCornerShape(24.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    Column {
                        LinearProgressIndicator(
                            progress = 0.1f,
                        )
                        Text(text = "加载中……")
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomFullscreenDialog(showDialog: MutableState<Boolean>) {
        if (showDialog.value) {
            AlertDialog(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(16.dp)
                    .background(MaterialTheme.colorScheme.surface),
                onDismissRequest = { showDialog.value = false },
                // 重要代码，取消Dialog宽度限制
                properties = DialogProperties(usePlatformDefaultWidth = false),
            ) {
                // dialog content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Green.copy(alpha = 0.3f))
                        .clickable {
                            showDialog.value = false
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "I'm a full screen dialog")
                }
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewContentView() {
        ContentView()
    }

    @Preview
    @Composable
    fun PreviewCustomAlertDialog() {
        val showDialog = remember { mutableStateOf(true) }
        CustomAlertDialog(showDialog)
    }

    @Preview
    @Composable
    fun PreviewCustomDialog() {
        val showDialog = remember { mutableStateOf(true) }
        CustomDialog(showDialog)
    }

    @Preview
    @Composable
    fun PreviewCustomFullscreenView() {
        val showDialog = remember { mutableStateOf(true) }
        CustomFullscreenDialog(showDialog)
    }
}

