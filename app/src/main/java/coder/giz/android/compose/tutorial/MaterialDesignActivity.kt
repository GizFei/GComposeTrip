package coder.giz.android.compose.tutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.R
import coder.giz.android.compose.Tutorial
import coder.giz.android.compose.ui.theme.GComposeTripTheme

/**
 * Created by GizFei on 2021/9/12
 */
@Tutorial(lesson = 3, title = "Material Design")
class MaterialDesignActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 使用 Material 主题包裹布局
            GComposeTripTheme {
                MessageCard(msg = Message.GIZ)
            }
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
                // 添加边框
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = "Author: ${msg.author}",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2  // 排版风格
            )

            Spacer(modifier = Modifier.height(4.dp))

            // 使用带阴影的“卡片”包裹
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 2.dp
            ) {
                Text(
                    text = "Body: ${msg.body}",
                    style = MaterialTheme.typography.body2, // 排版风格
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    group = "TutorialPreviewGroup",
    showBackground = true,
//    showSystemUi = true,
)
@Preview(
    name = "Dark Mode",
    group = "TutorialPreviewGroup",
//    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,   // 暗黑模式预览
)
@Composable
fun MaterialDesignPreview() {
    GComposeTripTheme {
        MessageCard(msg = Message.GIZ)
    }
}
