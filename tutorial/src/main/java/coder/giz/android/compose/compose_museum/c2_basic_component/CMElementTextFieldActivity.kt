package coder.giz.android.compose.compose_museum.c2_basic_component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.widget.FeatureExampleCard

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementTextFieldActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "TextField"

    @Composable
    override fun ContentView() {
        Column(
            modifier = Modifier.verticalScroll(ScrollState(0)),
        ) {
            val allCardExpanded = remember { mutableStateOf(false) }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { allCardExpanded.value = false },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f),
                ) {
                    Text(text = "收起所有")
                }

                Button(
                    onClick = { allCardExpanded.value = true },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f),
                ) {
                    Text(text = "展开所有")
                }
            }

            var basicUsageText by remember { mutableStateOf("") }
            FeatureExampleCard(
                featName = "基础用法",
                featIntro = "基础用法。输入文本：$basicUsageText",
                isExpanded = allCardExpanded,
            ) {
                TextField(
                    value = basicUsageText,
                    onValueChange = {
                        basicUsageText = it
                    },
                )
            }

            FeatureExampleCard(
                featName = "singleLine",
                featIntro = "使用 singleLine 参数可以将 TextField 设置成只有一行。\n" +
                    "设置了 singleLine 再设置 maxLines 将无效。",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                )
            }

            FeatureExampleCard(
                featName = "label",
                featIntro = "label 标签可以运用在 TextField 中，当聚焦的时候会改变字体大小",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    label = {
                        Row {
                            Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                            Text(text = "邮箱")
                        }
                    },
                )
            }

            FeatureExampleCard(
                featName = "leadingIcon",
                featIntro = "leadingIcon 参数可以在 TextField 前面布置 lambda 表达式所接收到的东西",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    label = {
                        Row {
                            Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                            Text(text = "邮箱")
                        }
                    },
                    leadingIcon = {
                        Row {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                            Text(text = "LeadingIcon")
                        }
                    }
                )
            }

            FeatureExampleCard(
                featName = "trailingIcon",
                featIntro = "trailingIcon 参数可以在 TextField 尾部布置 lambda 表达式所接收到的东西",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    label = {
                        Row {
                            Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                            Text(text = "邮箱")
                        }
                    },
                    leadingIcon = {
                        Row {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                            Text(text = "LeadingIcon")
                        }
                    },
                    trailingIcon = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "@163.com")
                            IconButton(onClick = { text = "" }) {
                                Icon(
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = null,
                                )
                            }
                        }
                    },
                )
            }

            FeatureExampleCard(
                featName = "Colors",
                featIntro = "各种颜色参数",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("Input Text") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Blue,
                        unfocusedContainerColor = Color.Transparent,
                    )
                )
            }

            FeatureExampleCard(
                featName = "visualTransformation",
                featIntro = "visualTransformation 可以帮助我们应用输入框的显示模式",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                var passwordHidden by remember { mutableStateOf(false) }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = {
                        Text(text = "密码")
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            val iconRes = if (passwordHidden) {
                                R.drawable.baseline_visibility_off_24
                            } else {
                                R.drawable.baseline_visibility_24
                            }
                            Icon(painter = painterResource(id = iconRes), contentDescription = null)
                        }
                    },
                    visualTransformation = if (passwordHidden) {
                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    }
                )
            }

            FeatureExampleCard(
                featName = "BasicTextField",
                featIntro = "自定义TextField",
                isExpanded = allCardExpanded,
            ) {
                var text by remember { mutableStateOf("") }
                var passwordHidden by remember { mutableStateOf(false) }
                BasicTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE), CircleShape)
                        .height(40.dp)
                        .fillMaxWidth(),
                    singleLine = true,
                ) { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                    ) {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                        }

                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.LightGray),
                        ) {
                            innerTextField()
                        }

                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = null,
                            )
                        }
                    }
                }
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