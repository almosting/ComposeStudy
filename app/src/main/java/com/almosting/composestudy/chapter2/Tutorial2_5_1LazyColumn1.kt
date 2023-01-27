package com.almosting.composestudy.chapter2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.almosting.composestudy.model.Snack
import com.almosting.composestudy.model.snacks
import com.almosting.composestudy.ui.components.SnackCard

@Composable
fun Tutorial2_5Screen1() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(snacks) { item: Snack ->
                SnackCard(snack = item)
            }
        }
    )
}
