package coder.giz.android.compose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 特性介绍与示例卡片。
 *
 * Created by GizFei on 2024/2/14
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureExampleCard(
    featName: String,
    featIntro: String,
    isExpanded: MutableState<Boolean> = remember { mutableStateOf(true) },
    content: @Composable () -> Unit,
) {
    var innerIsExpanded by remember { mutableStateOf(isExpanded.value) }

    innerIsExpanded = isExpanded.value
    
    Card(
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
        onClick = {
            innerIsExpanded = !innerIsExpanded
        },
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("特性：")
                        }
                        append(featName)
                    },
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.W700,
                    color = Color.Blue,
                    modifier = Modifier.weight(1f),
                )

                Spacer(modifier = Modifier)

                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(if (innerIsExpanded) 180f else 0f)
                )
            }

            AnimatedVisibility(
                visible = innerIsExpanded
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .padding(top = 8.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .width(2.dp)
                                .fillMaxHeight()
                                .background(Color.Black)
                        )
                        Text(
                            text = featIntro,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.Blue,
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .background(Color.LightGray)
                            .padding(vertical = 1.dp)
                    )

                    Text(text = "示例：")

                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            content()
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun PreviewFeatureExampleCard() {
    val isExpanded = remember { mutableStateOf(true) }

    GComposeTripTheme {
        Column {
            FeatureExampleCard(
                featName = "特性名称",
                featIntro = "这是一段特性介绍文本",
                isExpanded = isExpanded,
            ) {
                Text(text = "示例内容")
            }

            FeatureExampleCard(
                featName = "特性名称".repeat(4),
                featIntro = "这是一段特性介绍文本。可以很长很长很长".repeat(3),
                isExpanded = isExpanded,
            ) {
                Text(text = "示例内容")
            }
        }
    }
}