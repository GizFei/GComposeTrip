package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2024/2/14
 */
class CMElementIconActivity : ComponentActivity() {

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
        Column {
            Text(text = "Icon用来展示单色简单图标，可以被染成任意颜色。但是不能显示彩色图片")

            val modifier = Modifier.size(48.dp)

            Icon(
                painter = painterResource(id = R.drawable.compose_museum_logo),
                contentDescription = "任意类型资源",
                modifier = modifier,
            )

            Image(
                painter = painterResource(id = R.drawable.compose_museum_logo),
                contentDescription = "任意类型资源",
                modifier = modifier,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.compose_museum_logo),
                contentDescription = "矢量图资源",
                modifier = modifier,
            )

            Icon(
                bitmap = ImageBitmap.imageResource(R.drawable.logo_fika),
                contentDescription = "图片资源",
                modifier = modifier,
            )

            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.logo_fika),
                contentDescription = "图片",
                modifier = modifier,
            )

            Icon(imageVector = Icons.Filled.Home, contentDescription = null, modifier = modifier)
            Icon(imageVector = Icons.Filled.Home, contentDescription = null, tint = Color.Blue, modifier = modifier)
            Icon(imageVector = Icons.Rounded.Home, contentDescription = null, tint = Color.Red, modifier = modifier)
            Icon(imageVector = Icons.Outlined.Home, contentDescription = null, tint = Color.Cyan, modifier = modifier)
            Icon(imageVector = Icons.TwoTone.Home, contentDescription = null, tint = Color.Magenta, modifier = modifier)
            Icon(imageVector = Icons.Sharp.Home, contentDescription = null, tint = Color.Green, modifier = modifier)
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