package coder.giz.android.compose.compose_museum.c2_basic_component

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coder.giz.android.compose.R
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.widget.FeatureExampleCard

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementTextActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "Text"

    @Composable
    override fun ContentView() {
        Column(
            modifier = Modifier.verticalScroll(ScrollState(1000))
        ) {
            Text(text = "HelloWorld")

            Text(text = stringResource(id = R.string.app_name))

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

            FeatureExampleCard(
                featName = "style",
                featIntro = "style 参数可以帮助我们配置文本的行高，颜色，粗体等设置",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    Text(
                        text = "你好呀陌生人，这是一个标题",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text ="你好呀陌生人，我是内容",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text ="修改文字间距",
                        style = TextStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            letterSpacing = 8.sp,
                        )
                    )
                }
            }

            FeatureExampleCard(
                featName = "maxLines",
                featIntro = "使用 maxLines 参数可以帮助我们将文本限制在指定的行数之间",
                isExpanded = allCardExpanded,
            ) {
                Text(
                    text = "你好呀陌生人，这是一个标题，不是很长，因为我想不出其他什么比较好的标题了",
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                )
            }

            FeatureExampleCard(
                featName = "overflow",
                featIntro = "处理溢出效果",
                isExpanded = allCardExpanded,
            ) {
                Text(
                    text = "你好呀陌生人，这是一个标题，不是很长，因为我想不出其他什么比较好的标题了",
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            FeatureExampleCard(
                featName = "textAlign",
                featIntro = "文本对齐方式",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    Text(
                        text = "每天摸鱼",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "这好吗",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "这非常的好",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }

            FeatureExampleCard(
                featName = "lineHeight",
                featIntro = "行高间距",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    Text(text = "两面包夹芝士".repeat(4))
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = "两面包夹芝士".repeat(4),
                        lineHeight = 8.sp,
                    )
                }
            }

            FeatureExampleCard(
                featName = "fontFamily",
                featIntro = "更改字体",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    Text(
                        text = "测试字体<Serif> Test Font Family",
                        fontFamily = FontFamily.Serif,
                    )
                    Text(
                        text = "测试字体<SanSerif> Test Font Family",
                        fontFamily = FontFamily.SansSerif,
                    )
                }
            }

            FeatureExampleCard(
                featName = "Modifier.clickable",
                featIntro = "添加点击事件",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    val context = LocalContext.current
                    Text(
                        text = "点击有波纹效果",
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                Toast
                                    .makeText(context, "点击有波纹效果", Toast.LENGTH_SHORT)
                                    .show()
                            },
                    )
                    Text(
                        text = "点击没有波纹效果",
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    Toast
                                        .makeText(context, "点击没有波纹效果", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            ),
                    )
                }
            }

            FeatureExampleCard(
                featName = "AnnotatedString",
                featIntro = "使用buildAnnotatedString，让一个 Text 语句中使用不同的样式，比如粗体提醒，特殊颜色",
                isExpanded = allCardExpanded,
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("你现在观看的章节是 ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W700)) {
                            append("Text")
                        }
                    }
                )
            }

            FeatureExampleCard(
                featName = "ClickableText",
                featIntro = "ClickableText + AnnotatedString 实现文字点击超链接",
                isExpanded = allCardExpanded,
            ) {
                val annotatedText = buildAnnotatedString {
                    append("勾选即代表同意")
                    pushStringAnnotation(tag = "tag", annotation = "这是用户协议的注释嘿嘿")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontWeight = FontWeight.W700,
                        ),
                    ) {
                        append("用户协议")
                    }
                    pop()
                }

                val context = LocalContext.current
                val showDialog = remember { mutableStateOf(false) }
                UserPrivacyPolicyDialog(showDialog = showDialog)

                ClickableText(
                    text = annotatedText,
                    onClick = { offset ->
                        annotatedText.getStringAnnotations("tag", offset, offset)
                            .firstOrNull()
                            ?.let {
                                showDialog.value = true
                                Toast
                                    .makeText(context, "点击文本：tag=${it.tag}, item=${it.item}", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    }
                )
            }

            FeatureExampleCard(
                featName = "SelectionContainer",
                featIntro = "默认情况下 Text 并不能进行复制等操作，我们需要设置 SelectionContainer 来包装 Text",
                isExpanded = allCardExpanded,
            ) {
                SelectionContainer {
                    Column {
                        Text(
                            text = "每天摸鱼",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "这好吗",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "这非常的好",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }

            FeatureExampleCard(
                featName = "LocalContentColor",
                featIntro = "M3使用字重和透明度对文本进行强调",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    Text(
                        text = "High emphasis",
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Medium emphasis",
                        fontWeight = FontWeight.Normal,
                    )
                    CompositionLocalProvider(
                        LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                    ) {
                        Text(
                            text = "Disabled emphasis",
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun UserPrivacyPolicyDialog(showDialog: MutableState<Boolean>) {
        if (showDialog.value) {
            AlertDialog(
                title = {
                    Text(
                        text = "用户协议",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                text = {
                    Text(text = "如果你看到了这个弹窗，就说明你同意了用户协议")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        },
                    ) {
                        Text(text = "确认")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        },
                    ) {
                        Text(text = "取消")
                    }
                },
                onDismissRequest = {
                    showDialog.value = false
                },
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

//    @Preview
    @Composable
    private fun PreviewUserPrivacyPolicyDialog() {
        GComposeTripTheme {
            UserPrivacyPolicyDialog(showDialog = remember { mutableStateOf(true) })
        }
    }
}