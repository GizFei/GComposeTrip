package coder.giz.android.compose.compose_museum.c1_start

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * 教程链接：[初识 Jetpack Compose](https://jetpackcompose.cn/docs/tutorial)
 *
 * Created by GizFei on 2024/2/1
 */
class CMStartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                Conversation(messages = MsgData.messages)
            }
        }
    }

}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        targetValue = if (isExpanded) Color(0xFFCCCCCC) else MaterialTheme.colorScheme.surface,
        label = ""
    )

    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable {
                isExpanded = !isExpanded
            },
        color = surfaceColor,
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.compose_museum_logo),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFC1FFDA))
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.animateContentSize()
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {
            MessageCard(msg = it)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
)
@Composable
fun PreviewMessageCard() {
    GComposeTripTheme {
        Conversation(messages = MsgData.messages)
    }
}

private object MsgData {
    val messages = listOf(
        Message("Jetpack Compose 博物馆", "我们开始更新啦1"),
        Message("Jetpack Compose 博物馆", "我们开始更新啦2我们开始更新啦2"),
        Message("Jetpack Compose 博物馆", "我们开始更新啦3我们开始更新啦3我们开始更新啦3我们开始更新啦3"),
        Message("Jetpack Compose 博物馆", "我们开始更新啦4我们开始更新啦4我们开始更新啦4我们开始更新啦4我们开始更新啦4"),
        Message("Jetpack Compose 博物馆", "我们开始更新啦5我们开始更新啦5我们开始更新啦5我们开始更新啦5我们开始更新啦5我们开始更新啦5"),
        Message("Jetpack Compose 博物馆", "我们开始更新啦6我们开始更新啦6我们开始更新啦6我们开始更新啦6我们开始更新啦6我们开始更新啦6我们开始更新啦6"),
    )
}