package com.fwrite.composestudy.chapter2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fwrite.composestudy.model.Snack
import com.fwrite.composestudy.model.snacksOrdered
import com.fwrite.composestudy.ui.components.SnackCard

@ExperimentalFoundationApi
@Composable
fun Tutorial2_5Screen4() {
    TutorialContent()
}

@ExperimentalFoundationApi
@Composable
private fun TutorialContent() {
    val grouped: Map<Char, List<Snack>> = snacksOrdered.groupBy { it.name[0] }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {

            grouped.forEach { (initial: Char, snacks: List<Snack>) ->

                stickyHeader {
                    SnackHeader(initial)
                }

                items(snacks) { item: Snack ->
                    SnackCard(snack = item)
                }
            }
        })
}

@Composable
private fun SnackHeader(initial: Char) {
    Text(
        text = "$initial",
        fontSize = 24.sp,
        color = Color(0xff039BE5),
        modifier = Modifier
            .background(Color(0xffE3F2FD))
            .fillMaxWidth()
            .padding(horizontal = 12.dp,vertical = 8.dp)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun Tutorial2_5_4Preview() {
    TutorialContent()
}