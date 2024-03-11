package coder.giz.android.compose.compose_museum.c3_layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coder.giz.android.compose.common.TutorialBaseActivity
import coder.giz.android.compose.ui.theme.GComposeTripTheme
import coder.giz.android.compose.widget.CardExpandedControlButtons
import coder.giz.android.compose.widget.FeatureExampleCard
import kotlinx.coroutines.launch

/**
 * Created by GizFei on 2024/2/15
 */
class CMLayoutPagerActivity : TutorialBaseActivity() {

    companion object {
        private const val TAG = "CMLayoutPagerActivity"
    }

    override fun getToolbarTitle(): String = "Pager"

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun ContentView() {
        Column {
            val allCardExpanded = remember { mutableStateOf(false) }

            CardExpandedControlButtons(allCardExpanded = allCardExpanded)

            FeatureExampleCard(
                featName = "Pager基本使用",
                featIntro = "创建一个5页的HorizontalPager",
                isExpanded = allCardExpanded,
            ) {
                HorizontalPager(
                    state = rememberPagerState { 5 },
                    modifier = Modifier
                        .height(200.dp)
                ) { page ->
                    Text(
                        text = "Page: $page",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

            FeatureExampleCard(
                featName = "Pager & TabRow",
                featIntro = "HorizontalPager配合TabRow使用",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    val pages = (0..5).map { "Tab $it" }
                    val pagerState = rememberPagerState { pages.size }
                    val coroutineScope = rememberCoroutineScope()

                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        modifier = Modifier
                            .wrapContentWidth(),
                    ) {
                        pages.forEachIndexed { index, s ->
                            Tab(
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                            ) {
                                Text(
                                    text = s,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp, vertical = 8.dp)
                                )
                            }
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .height(200.dp)
                    ) { page ->
                        Text(
                            text = "Page: $page",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }
            }

            FeatureExampleCard(
                featName = "Pager & TabRow",
                featIntro = "HorizontalPager配合TabRow使用",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    val pages = (0..3).map { "Tab $it" }
                    val pagerState = rememberPagerState { pages.size }
                    val coroutineScope = rememberCoroutineScope()

                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        modifier = Modifier
                            .wrapContentWidth()
                            .clip(CircleShape),
                        containerColor = Color(0xff1E76DA),
                        contentColor = Color.White,
                        indicator = { Box {} },
                    ) {
                        pages.forEachIndexed { index, s ->
                            val isSelected = pagerState.currentPage == index
                            Tab(
                                selected = isSelected,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                modifier = if (isSelected) {
                                    Modifier
                                        .padding(2.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                } else {
                                    Modifier
                                        .padding(2.dp)
                                },
                                text = {
                                    Text(
                                        text = s,
                                        modifier = Modifier
//                                            .padding(horizontal = 8.dp, vertical = 8.dp),
                                    )
                                },
                                selectedContentColor = Color(0xff6FAAEE),
                                unselectedContentColor = Color.White,
                            )
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .height(200.dp)
                    ) { page ->
                        Text(
                            text = "Page: $page",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }
            }

            FeatureExampleCard(
                featName = "Pager & TabRow",
                featIntro = "HorizontalPager配合TabRow使用",
                isExpanded = allCardExpanded,
            ) {
                Column {
                    val pages = (0..5).map { "Tab $it" }
                    val pagerState = rememberPagerState { pages.size }
                    val coroutineScope = rememberCoroutineScope()

                    ScrollableTabRow(
                        selectedTabIndex = pagerState.currentPage,
                        modifier = Modifier
                            .wrapContentWidth()
                            .clip(CircleShape),
                        containerColor = Color(0xff1E76DA),
                        contentColor = Color.White,
                        edgePadding = 16.dp,
                        indicator = {
                            Box {}
//                            YFLog.d(TAG, "TabPositions: ${it.toPrettyJson()}")
                        },
                    ) {
                        pages.forEachIndexed { index, s ->
                            val isSelected = pagerState.currentPage == index
                            Tab(
                                selected = isSelected,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                modifier = if (isSelected) {
                                    Modifier
                                        .padding(2.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                } else {
                                    Modifier
                                        .padding(2.dp)
                                },
                                text = {
                                    Text(
                                        text = s,
                                        modifier = Modifier,
                                    )
                                },
                                selectedContentColor = Color(0xff6FAAEE),
                                unselectedContentColor = Color.White,
                            )
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .height(200.dp)
                    ) { page ->
                        Text(
                            text = "Page: $page",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }
            }

            FeatureExampleCard(
                featName = "Pager & TabRow",
                featIntro = "HorizontalPager配合TabRow使用"
            ) {
                Column {
                    val pages = (0..5).map { "Tab $it" }
                    val pagerState = rememberPagerState { pages.size }
                    val coroutineScope = rememberCoroutineScope()

                    ScrollableTabRow(
                        selectedTabIndex = pagerState.currentPage,
                        modifier = Modifier
                            .wrapContentWidth()
                            .clip(RoundedCornerShape(8.dp))
                            ,
                        containerColor = Color(0xfff3f3f2),
                        contentColor = Color.Black,
                        edgePadding = 0.dp,
                        indicator = {
                            Box {}
                        },
                        divider = {},   // 取消底部分割线
                    ) {
                        pages.forEachIndexed { index, s ->
                            val isSelected = pagerState.currentPage == index
                            Tab(
                                selected = isSelected,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                },
                                modifier = if (isSelected) {
                                    Modifier
                                        .padding(4.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color.White)
                                } else {
                                    Modifier
                                        .padding(2.dp)
                                },
                                text = {
                                    Text(
                                        text = s,
                                        modifier = Modifier,
                                    )
                                },
                                selectedContentColor = Color(0xff6FAAEE),
                                unselectedContentColor = Color.Black,
                            )
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .height(200.dp)
                    ) { page ->
                        Text(
                            text = "Page: $page",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }
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