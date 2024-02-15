package coder.giz.android.compose.compose_museum.c3_layout

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.widget.CardExpandedControlButtons
import coder.giz.android.compose.widget.SimpleFeatureExampleCard

/**
 * Created by GizFei on 2024/2/14
 */
class CMLayoutRowActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "Row"

    @Composable
    override fun ContentView() {
        val allCardExpanded = remember { mutableStateOf(true) }
        Column(
            modifier = Modifier.verticalScroll(ScrollState(0))
        ) {
            CardExpandedControlButtons(allCardExpanded = allCardExpanded)

            SimpleFeatureExampleCard(
                featName = "Arrangement.Start",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.End",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.Center",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.SpaceBetween",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.SpaceEvenly",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.SpaceAround",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    RowContent()
                }
            }

            SimpleFeatureExampleCard(
                featName = "Arrangement.spacedBy(40.dp)",
                isExpanded = allCardExpanded,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                ) {
                    RowContent()
                }
            }
        }
    }

    @Composable
    private fun RowContent() {
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