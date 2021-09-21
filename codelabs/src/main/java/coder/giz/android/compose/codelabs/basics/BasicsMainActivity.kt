package coder.giz.android.compose.codelabs.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.codelabs.ui.theme.GComposeTripTheme

/**
 * [Jetpack Compose basics](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#0)
 *
 * Created by GizFei on 2021/9/19
 */
class BasicsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
                MyScreenContent(names = listOf("Michael", "Jane", "David"))
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    GComposeTripTheme {
        // 使用 Surface 添加背景颜色
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column {
        Greeting(name = "Android")
        Divider(color = Color.Black)
        Greeting(name = "There")
    }
}

@Composable
fun MyScreenContent(names: List<String>) {
    val countState = remember { mutableStateOf(0) }

    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter()
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
            count = countState.value,
            updateCount = { countState.value++ }
        )
        Divider(color = Color.Transparent, thickness = 32.dp)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(24.dp)
    )
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    Button(onClick = { count.value++ }) {
        Text(text = "I've been clicked ${count.value} times.")
    }
}

/**
 * 状态提升
 */
@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times.")
    }
}

@Preview(
    showBackground = true,
    group = "Default"
)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent(names = listOf("Michael", "Jane", "David"))
    }
}

// region ======== 6. Flexible Layouts ========
@Composable
fun MyFlexibleScreenContent(names: List<String> = List(100) { "Hello Android #$it" }) {
    val countState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names = names, modifier = Modifier.weight(1f))
        CounterInFlexible(
            count = countState.value,
            updateCount = { newCount ->
                countState.value = newCount
            }
        )
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun CounterInFlexible(count: Int, updateCount: (Int) -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        ),
        onClick = { updateCount(count + 1) }
    ) {
        Text(text = "I've been clicked $count times.")
    }
}

@Preview(
    name = "Flexible Layouts Preview",
    group = "Flexible Layouts",
    device = Devices.PIXEL_2
)
@Composable
fun FlexibleLayoutsPreview() {
    MyApp {
        MyFlexibleScreenContent()
    }
}
// endregion

// region ======== 7. Animating your list ========
@Composable
fun MyAnimatingListContent(names: List<String> = List(100) { "Hello Android #$it" }) {
    val countState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        NameListInAnimatingList(names = names, modifier = Modifier.weight(1f))
        CounterInFlexible(
            count = countState.value,
            updateCount = { newCount ->
                countState.value = newCount
            }
        )
    }
}

@Composable
fun GreetingWithAnimation(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Transparent
    )

    Text(
        text = "Hello $name!",
        modifier = Modifier
            .background(color = backgroundColor)
            .padding(24.dp)
            .clickable { isSelected = !isSelected }
    )
}

@Composable
fun NameListInAnimatingList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            GreetingWithAnimation(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Preview(
    group = "Animating Your List",
    name = "Animating Your List Preview"
)
@Composable
fun AnimatingYourListPreview() {
    MyApp {
        MyAnimatingListContent()
    }
}
// endregion