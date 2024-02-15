package coder.giz.android.compose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 简单的特性示例卡片。
 *
 * Created by GizFei on 2024/2/14
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleFeatureExampleCard(
    featName: String,
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
                    text = featName,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.W700,
                    color = MaterialTheme.colorScheme.primary,
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
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
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


@Preview
@Composable
private fun PreviewSimpleFeatureExampleCard() {
    val isExpanded = remember { mutableStateOf(true) }

    GComposeTripTheme {
        Column {
            SimpleFeatureExampleCard(
                featName = "特性名称",
                isExpanded = isExpanded,
            ) {
                Text(text = "示例内容")
            }

            SimpleFeatureExampleCard(
                featName = "特性名称".repeat(4),
                isExpanded = isExpanded,
            ) {
                Text(text = "示例内容")
            }
        }
    }
}