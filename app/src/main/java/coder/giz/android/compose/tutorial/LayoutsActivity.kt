package coder.giz.android.compose.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.Tutorial
import coder.giz.android.compose.ui.theme.Teal200

/**
 * Created by GizFei on 2021/9/12
 */
@Tutorial(lesson = 2)
class LayoutsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(msg = Message.GIZ)
        }
    }

}

data class Message(val author: String, val body: String) {
    companion object {
        val GIZ = Message("Giz", "Giz Compose Trip")
    }
}

@Composable
fun MessageCard(msg: Message) {
    // 添加 padding
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            // 添加 drawable 图片资源
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Content Description",
            modifier = Modifier
                .size(40.dp)        // 设置图片宽度
                .clip(CircleShape)  // 裁剪图片成圆角
        )

        // 添加间隔
        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(text = "Author: ${msg.author}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Body: ${msg.body}")
        }
    }
}

@Preview(
    name = "LayoutsPreview",
    group = "TutorialPreviewGroup",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFF1C3BFF
)
@Composable
fun LayoutsPreview() {
    MessageCard(msg = Message.GIZ)
}

