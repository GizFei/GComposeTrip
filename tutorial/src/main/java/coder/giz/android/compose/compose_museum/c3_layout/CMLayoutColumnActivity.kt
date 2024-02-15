package coder.giz.android.compose.compose_museum.c3_layout

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.widget.CardExpandedControlButtons
import coder.giz.android.compose.widget.SimpleFeatureExampleCard

/**
 * Created by GizFei on 2024/2/15
 */
class CMLayoutColumnActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "Column"

    @Composable
    override fun ContentView() {
        Column(
            modifier = Modifier
                .verticalScroll(ScrollState(0))
        ) {
            Column(
                modifier = Modifier
                    .border(1.dp, Color.Black)
                    .size(200.dp, 300.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello, World!",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.align(Alignment.End)
                )
                Text("Jetpack Compose")
            }

            Text(
                text = "Arrangement示例",
                style = MaterialTheme.typography.headlineSmall,
            )
            
            val allCardExpanded = remember { mutableStateOf(true) }

            CardExpandedControlButtons(allCardExpanded = allCardExpanded)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(ScrollState(0)),
            ) {
                val boxModifier = Modifier
                    .width(150.dp)
                val colModifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .border(1.dp, Color.Black)
                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "Top",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "Bottom",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "Center",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "SpaceAround",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "SpaceBetween",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "SpaceEvenly",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }

                Box(modifier = boxModifier) {
                    SimpleFeatureExampleCard(
                        featName = "spacedBy(40.dp)",
                        isExpanded = allCardExpanded,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = colModifier,
                        ) {
                            ColumnContent()
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ColumnContent() {
        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
        ) {
            Icon(Icons.Filled.Favorite, null)
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
        ) {
            Icon(Icons.Filled.Share, null)
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary),
        ) {
            Icon(Icons.Filled.Refresh, null)
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