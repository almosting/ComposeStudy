package com.almosting.composestudy.chapter2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.almosting.composestudy.model.Snack
import com.almosting.composestudy.model.snacks
import com.almosting.composestudy.ui.components.GridSnackCard
import com.almosting.composestudy.ui.theme.backgroundColor

@Composable
fun Tutorial2_5Screen5() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        columns = GridCells.Fixed(3),
        content = {
            items(snacks) { snack: Snack ->
                GridSnackCard(snack = snack)
            }
        }
    )
}