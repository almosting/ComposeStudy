package com.fwrite.composestudy.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.fwrite.composestudy.R
import com.fwrite.composestudy.model.Snack
import com.fwrite.composestudy.model.snacks
import kotlin.random.Random

/**
 * Created on 2022/12/30.
 * @author w.feng
 */
@SuppressLint("ModifierParameter")
@Composable
fun SnackCard(
    snack: Snack,
    textColor: Color = remember(snack.id) { randomColor() },
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
) {

    println("🍭 SnackCard() id: ${snack.id}, textColor: $textColor")
    Card(
        modifier = Modifier
            .background(Color.White)
            .clickable(onClick = {}),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Box(contentAlignment = Alignment.TopEnd) {

            Column(modifier = Modifier.fillMaxSize()) {

                Image(
                    contentScale = ContentScale.Crop,
                    modifier = modifier,
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                placeholder(drawableResId = R.drawable.placeholder)
                            }).build()
                    ),
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        text = snack.name
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            fontSize = 14.sp,
                            text = "$${snack.price}"
                        )
                        Text(
                            fontSize = 14.sp,
                            text = "Tags: ${snack.tagline}"
                        )
                    }
                }
            }

            FavoriteButton(
                modifier = Modifier
                    .padding(12.dp),
                color = textColor
            )
        }
    }
}

@Composable
fun HorizontalSnackCard(
    modifier: Modifier = Modifier,
    snack: Snack,
    textColor: Color = remember(snack.id) { randomColor() },
) {
    Box(contentAlignment = Alignment.TopEnd) {

        Column {

            Image(
                contentScale = ContentScale.None,
                modifier = modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { },
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(drawableResId = R.drawable.placeholder)
                        }).build()
                ),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier.padding(2.dp),
                color = textColor,
                fontWeight = FontWeight.Bold,
                text = snack.name
            )
        }

        FavoriteButton(
            modifier = Modifier
                .padding(12.dp),
            color = textColor
        )
    }
}


@Composable
fun GridSnackCard(
    modifier: Modifier = Modifier,
    snack: Snack,
) {
    Box(contentAlignment = Alignment.TopEnd, modifier = modifier.padding(4.dp)) {


        Image(
            contentScale = ContentScale.None,
            modifier = modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { },
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = snack.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(drawableResId = R.drawable.placeholder)
                    }).build()
            ),
            contentDescription = null
        )
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63)
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}

@Preview
@Composable
fun SnackCardPreview() {
    val snack = snacks.first()
    SnackCard(snack = snack, Color.Black)
}

@Preview
@Composable
fun HorizontalSnackCardPreview() {
    val snack = snacks.first()
    HorizontalSnackCard(snack = snack, textColor = Color.Black)
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    FavoriteButton()
}
private fun randomColor() = Color(
    Random.nextInt(255),
    Random.nextInt(255),
    Random.nextInt(255)
)