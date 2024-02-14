package coder.giz.android.compose.compose_museum.c2_basic_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementImageActivity : TutorialBaseActivity() {

    override fun getToolbarTitle(): String = "Image"

    @Composable
    override fun ContentView() {
        Column(
            modifier = Modifier.verticalScroll(state = ScrollState(0))
        ) {
            Image(
                painter = painterResource(id = R.drawable.wallpaper_1),
                contentDescription = null,
            )

            Image(
                painter = painterResource(id = R.drawable.wallpaper_1),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.Blue)
                    .clip(CircleShape)
            )

            Surface(
                shape = CircleShape,
                modifier = Modifier.background(Color.Red.copy(alpha = 0.5f)),
                border = BorderStroke(10.dp, Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.wallpaper_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .background(Color.Cyan),
                    contentScale = ContentScale.Crop
                )
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