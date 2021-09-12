package coder.giz.android.compose.tutorial

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import coder.giz.android.compose.Tutorial
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2021/9/12
 */
@Tutorial(lesson = 4, "Lists And Animations")
class ListsAndAnimationsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GComposeTripTheme {
                Conversion(messages = SampleData.conversationMessages)
            }
        }
    }

}

@Composable
private fun Conversion(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

@Composable
private fun MessageCard(msg: Message) {
    Row(
        modifier = Modifier.padding(all = 8.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Content Description",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // 添加「状态变量」
        var isExpanded by remember { mutableStateOf(false) }
        // 添加「颜色渐变」动画
        val surfaceColor: Color by animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        val textColor: Color by animateColorAsState(
            targetValue = if (isExpanded) Color.White else Color.Black
        )

        // 添加点击事件
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .clickable { isExpanded = !isExpanded }
                .background(Color.Cyan)
        ) {
            Text(
                text = "Author: ${msg.author}",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 2.dp,
                // 使用「颜色渐变」的颜色
                color = surfaceColor,
                // 使用「尺寸渐变」
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = "Body: ${msg.body}",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(4.dp),
                    // 根据是否展开，改变最大行数，从而实现内容的展开与收缩
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    // 文字颜色渐变
                    color = textColor
                )
            }
        }
    }
}

@Preview
@Composable
fun ListsAndAnimationsPreview() {
    GComposeTripTheme {
        Conversion(messages = SampleData.conversationMessages)
    }
}