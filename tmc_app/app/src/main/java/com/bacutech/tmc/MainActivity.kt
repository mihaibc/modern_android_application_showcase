package com.bacutech.tmc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bacutech.tmc.ui.theme.TMCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val moviesUrls = listOf(
        "https://www.themoviedb.org/t/p/w1280/6oH378KUfCEitzJkm07r97L0RsZ.jpg",
        "https://www.themoviedb.org/t/p/w1280/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
        "https://www.themoviedb.org/t/p/w1280/gPbM0MK8CP8A174rmUwGsADNYKD.jpg",
        "https://www.themoviedb.org/t/p/w1280/vB8o2p4ETnrfiWEgVxHmHWP9yRl.jpg",
        "https://www.themoviedb.org/t/p/w1280/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box {
                        MainView(moviesUrls)
                        MyAppTopAppBar("TMC", {})
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainView(moviesUrls: List<String>, modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val pageCount = 5
    val pagerState = rememberPagerState(pageCount = {pageCount}
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box() {
            HorizontalPager(state = pagerState) { page ->
                Box(
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 450.dp),
                        model = moviesUrls[page],
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                }
            }
            Row(
                Modifier
                    .wrapContentSize()
                    .height(10.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.spacedBy(6.dp),

                ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color)
                            .size(5.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(moviesUrls.size) { item ->
                Column(
                    modifier = Modifier.padding(start = if (item == 0) 5.dp else 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                        model = moviesUrls[item],
                        contentDescription = null,
                    )
                    Text(
                        text = "Movie no. $item",
                        modifier = modifier
                    )
                }

            }

        }

        Spacer(Modifier.height(20.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(moviesUrls.size) { item ->
                Column(
                    modifier = Modifier.padding(start = if (item == 0) 5.dp else 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                        model = moviesUrls[item],
                        contentDescription = null,
                    )
                    Text(
                        text = "Movie no. $item",
                        modifier = modifier
                    )
                }

            }

        }

        Spacer(Modifier.height(20.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(moviesUrls.size) { item ->
                Column(
                    modifier = Modifier.padding(start = if (item == 0) 5.dp else 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                        model = moviesUrls[item],
                        contentDescription = null,
                    )
                    Text(
                        text = "Movie no. $item",
                        modifier = modifier
                    )
                }

            }

        }

        Spacer(Modifier.height(20.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(moviesUrls.size) { item ->
                Column(
                    modifier = Modifier.padding(start = if (item == 0) 5.dp else 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                        model = moviesUrls[item],
                        contentDescription = null,
                    )
                    Text(
                        text = "Movie no. $item",
                        modifier = modifier
                    )
                }

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopAppBar(topAppBarText: String, onBackPressed: () -> Unit) {
    CenterAlignedTopAppBar(
        modifier = Modifier.background(Color.Transparent),
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "localizedString"
                )
            }
        },
        actions = {
            AsyncImage(
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(width = 30.dp, height = 30.dp)
                    .clip(shape = CircleShape),
                model = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn.designbump.com%2Fwp-content%2Fuploads%2F2015%2F05%2Fenhanced-buzz-wide-31664-1394838319-8.jpg&f=1&nofb=1&ipt=25f6030fb376c0166c3dfc55c26e28b21a1c05ea83098f4432e6bc1824030b67&ipo=images",
                contentDescription = null,
            )
        },
        windowInsets = WindowInsets(left = 5.dp, right = 15.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}