package coder.giz.android.compose.compose_museum.c2_basic_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 教程链接：[Button](https://jetpackcompose.cn/docs/elements/button)
 *
 * Created by GizFei on 2024/2/8
 */
class CMElementButtonActivity : ComponentActivity() {

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
            Button(
                onClick = {},
                modifier = Modifier.shadow(16.dp, shape = ButtonDefaults.shape)
            ) {
                Text(text = "确认")
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp)
                    .shadow(16.dp, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "喜欢")
            }

            Button(
                onClick = {},
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "分享")
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "删除")
            }

            // 不同点击状态下的按钮状态
            val interactionState = remember { MutableInteractionSource() }
            val (text, textColor, buttonColor) = when {
                interactionState.collectIsPressedAsState().value -> {
                    ButtonState("Just Pressed", Color.Red, Color.Black)
                }
                else -> {
                    ButtonState("Just Button", Color.White, Color.Red)
                }
            }
            Button(
                onClick = {},
                interactionSource = interactionState,
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                ),
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Min)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = text,
                    color = textColor,
                )
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewContentView() {
        ContentView()
    }

}

private data class ButtonState(
    var text: String,
    var textColor: Color,
    var buttonColor: Color,
)