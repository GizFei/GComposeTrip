package coder.giz.android.compose.tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 练习白板
 *
 * Created by GizFei on 2021/9/13
 */

/**
 * 文本视图
 */
@Composable
private fun TextView(text: String) {
    Text(text = text)
}

/**
 * 列视图
 * · 标题
 * · 其他内容
 */
@Composable
private fun ColumnView(title: String, content: @Composable () -> Unit) {
    Column {
        TextView(text = "Title: $title")
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

private val numberView: Int @Composable get() {
    TextView(text = "NumberView: return 2")
    return 2
}

@Preview
@Composable
fun TutorialWhiteBoardPreview() {
    val number = numberView
    println("number: $number")
    ColumnView(title = "ColumnView 1") {
        Text(text = "This is first content composable function that emits a Text UI element in ColumnView 1.")
        Text(text = "This is second content composable function that emits a Text UI element. in ColumnView 1.")
    }
    ColumnView(title = "ColumnView 2") {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "This is first content composable function that emits a Text UI element in ColumnView 2.",
            color = Color.Cyan
        )
        Text(
            text = "This is second content composable function that emits a Text UI element. in ColumnView 2.",
            color = Color.Cyan
        )
    }
}