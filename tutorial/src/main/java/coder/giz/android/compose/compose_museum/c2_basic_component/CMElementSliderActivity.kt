package coder.giz.android.compose.compose_museum.c2_basic_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import kotlin.math.max
import kotlin.math.min

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementSliderActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "Slider"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun ContentView() {
        var progress by remember { mutableFloatStateOf(0f) }

        fun changeProgress(delta: Float) {
            val np = progress + delta
            progress = max(0f, min(np, 1f))
        }

        ElevatedCard(
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp,
                disabledElevation = 2.dp,
            ),
            modifier = Modifier.padding(16.dp),
            onClick = {},
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "凤屿",
                        style = MaterialTheme.typography.headlineMedium,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.W700,
                    )

                    Text(
                        text = "闫东炜",
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                    )

                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .background(Color.Blue)
                    )

                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null)
                    }
                }

                Slider(
                    value = progress,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White,
                        activeTrackColor = Color(0xFF0079D3),
                        inactiveTrackColor = Color(0x3D0079D3),
                    ),
                    onValueChange = {
                        progress = it
                    },
                )
                var range by remember {
                    mutableStateOf(1f..2f)
                }
                RangeSlider(
                    value = range,
                    valueRange = 0f..4f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.White,
                        activeTrackColor = Color(0xFF0079D3),
                        inactiveTrackColor = Color(0x3D0079D3),
                    ),
                    onValueChange = {
                        range = it
                        progress = it.start
                    },
                )

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            changeProgress(-0.1f)
                        },
                        modifier = Modifier
                            .align(alignment = Alignment.CenterStart)
                    ) {
                        Text(text = "进度-0.1")
                    }

                    Button(
                        onClick = {
                            changeProgress(0.1f)
                        },
                        modifier = Modifier
                            .align(alignment = Alignment.CenterEnd)
                    ) {
                        Text(text = "进度+0.1")
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