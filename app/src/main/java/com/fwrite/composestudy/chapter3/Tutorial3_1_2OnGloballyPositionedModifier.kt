package com.fwrite.composestudy.chapter3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fwrite.composestudy.ui.components.StyleableTutorialText

@Composable
fun Tutorial3_1Screen2() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    Column(modifier =Modifier.fillMaxSize()) {
        StyleableTutorialText(
            text = "**onGloballyPositioned** Modifier returns position of the Composable " +
                    "inside parent, root or window. Window adds **StatusBar** height to root.",
            bullets = false)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Red))
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Yellow))
            MyComposable()
        }
    }
}

@Composable
private fun MyComposable() {


    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .border(2.dp, Color.Red)
        .onGloballyPositioned {
            val positionInParent: Offset = it.positionInParent()
            val positionInRoot: Offset = it.positionInRoot()
            val positionInWindow: Offset = it.positionInWindow()
            text =
                "positionInParent: $positionInParent\n" +
                        "positionInRoot: $positionInRoot\n" +
                        "positionInWindow: $positionInWindow"
        }
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun Tutorial3_1_2Preview() {
    TutorialContent()
}