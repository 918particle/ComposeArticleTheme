package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(){
    ArticleCard(
        stringResource(id = R.string.string_1),
        stringResource(id = R.string.string_2),
        stringResource(id = R.string.string_3),
        painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    image: Painter,
    modifier: Modifier = Modifier
)
{
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        TopImage(imageVal = image)
        Messages(
            firstBlock = title,
            secondBlock = shortDescription,
            thirdBlock = longDescription,
            titleSize = 24,
            titleAlign = TextAlign.Left,
            bodyAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Messages(
    firstBlock: String,
    secondBlock: String,
    thirdBlock: String,
    titleSize: Int,
    bodySize: Int = 16,
    titleAlign: TextAlign,
    bodyAlign: TextAlign
)
{
    Message(
        name = firstBlock,
        size = titleSize,
        align = titleAlign,
        modifier = Modifier.padding(16.dp)
    )
    Message(
        name = secondBlock,
        size = bodySize,
        align = bodyAlign,
        modifier = Modifier.padding(start=16.dp,end=16.dp))
    Message(
        name = thirdBlock,
        size = bodySize,
        align = bodyAlign,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Message(
    name: String,
    size: Int,
    align: TextAlign,
    modifier: Modifier
) {
    Text(
        text = name,
        fontSize = size.sp,
        lineHeight = size.sp,
        textAlign = align,
        color = Color.DarkGray,
        modifier = modifier
    )
}

@Composable
fun TopImage(imageVal: Painter)
{
    Image(
        painter = imageVal,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        alpha = 0.85F
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        ComposeArticleApp()
    }
}