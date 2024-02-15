package coder.giz.android.compose.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by GizFei on 2024/2/15
 */


/**
 * “展开/收起卡片”的按钮布局。
 */
@Composable
fun CardExpandedControlButtons(allCardExpanded: MutableState<Boolean>) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { allCardExpanded.value = false },
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f),
        ) {
            Text(text = "收起所有")
        }

        Button(
            onClick = { allCardExpanded.value = true },
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f),
        ) {
            Text(text = "展开所有")
        }
    }
}