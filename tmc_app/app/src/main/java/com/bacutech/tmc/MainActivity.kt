package com.bacutech.tmc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bacutech.tmc.ui.theme.TMCTheme

class MainActivity : ComponentActivity() {

    val moviesUrls = listOf(
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        MyAppTopAppBar("TMC", {})
                        Greeting("Android", moviesUrls)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, moviesUrls: List<String>, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            items(moviesUrls.size) { item ->
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Green,
                            shape = RoundedCornerShape(15.dp)
                        ),

                    ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround

                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(width = 200.dp, height = 300.dp)
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopAppBar(topAppBarText: String, onBackPressed: () -> Unit) {
    TopAppBar(
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
                    Icons.Filled.ArrowBack,
                    contentDescription = "localizedString"
                )
            }
        },
        // ...
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TMCTheme {
        Greeting("Android", emptyList())
    }
}