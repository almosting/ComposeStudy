package com.fwrite.composestudy.chapter2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fwrite.composestudy.model.Place
import com.fwrite.composestudy.model.Snack
import com.fwrite.composestudy.model.places
import com.fwrite.composestudy.model.snacks
import com.fwrite.composestudy.ui.components.HorizontalSnackCard
import com.fwrite.composestudy.ui.components.PlaceCard
import com.fwrite.composestudy.ui.components.PlacesToBookComponent
import com.fwrite.composestudy.ui.theme.backgroundColor

@Composable
fun Tutorial2_5Screen3() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxHeight()
            .background(backgroundColor),
        content = {

            item {
                Text(
                    color = Color(0xffE53935),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Snacks"
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(snacks) { snack: Snack ->
                            HorizontalSnackCard(snack = snack)
                        }
                    }
                )
            }

            item {
                Text(
                    color = Color(0xff4CAF50),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Places"
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(places) { place: Place ->
                            PlaceCard(place = place)
                        }
                    }
                )
            }

            item {
                Text(
                    color = Color(0xff4CAF50),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Places to Visit"
                )
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(places) { place: Place ->
                            PlacesToBookComponent(place = place)
                        }
                    }
                )
            }

        })
}

@Preview
@Composable
private fun Tutorial2_5_3Preview() {
    TutorialContent()
}