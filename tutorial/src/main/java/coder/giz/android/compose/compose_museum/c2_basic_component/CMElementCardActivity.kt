package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 教程链接：[Card](https://jetpackcompose.cn/docs/elements/card)
 *
 * Created by GizFei on 2024/2/8
 */
class CMElementCardActivity : ComponentActivity() {

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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    // 使用clickable，波纹效果不是圆角，而是一个矩形
                    .clickable { },
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            ) {
                CardContent()
            }

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                // 用onClick方法，点击的波纹效果会被裁剪成圆角
                onClick = {},
            ) {
                CardContent()
            }

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Red,
                ),
                onClick = {},
            ) {
                CardContent()
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Red,
                ),
                onClick = {},
            ) {
                CardContent()
            }
        }
    }

    @Composable
    private fun CardContent() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    append("欢迎来到 ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))) {
                        append("Jetpack Compose 博物馆")
                    }
                    append(" !")
                }
            )
            Text(
                text = buildAnnotatedString {
                    append("你现在观看的章节是 ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" .")
                }
            )
        }
    }

    @Preview()
    @Composable
    fun PreviewContentView() {
        GComposeTripTheme {
            ContentView()
        }
    }

}