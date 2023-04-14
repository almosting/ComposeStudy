package com.fwrite.composestudy.chapter2

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fwrite.composestudy.R
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun Tutorial2_10Screen2() {
    TutorialContent()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
private fun TutorialContent() {

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.HalfExpanded
    )
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        TopAppBar(elevation = 8.dp, title = {
            Text("Modal BottomSheet")
        },

            actions = {
                IconButton(onClick = {
                    if (modalBottomSheetState.isVisible) {
                        coroutineScope.launch { modalBottomSheetState.hide() }
                    } else {
                        coroutineScope.launch { modalBottomSheetState.show() }
                    }
                }) {
                    Icon(imageVector = Icons.Filled.Expand, contentDescription = null)
                }
            })
    }) {

        ModalBottomSheetLayout(sheetState = modalBottomSheetState,
            sheetElevation = 8.dp,
            scrimColor = Color(0xccAAABBB),
            sheetContent = {
                // 🔥 Uncomment to see states on modal bottom sheet content
//                MainContent(modalBottomSheetState, Color(0xff4CAF50))
                SheetContent()
            }) {
            MainContent(modalBottomSheetState)
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun MainContent(
    modalBottomSheetState: ModalBottomSheetState, color: Color = Color(0xffE91E63)
) {

    // 🔥🔥 Don't read from state in recomposition use derivedStateOf instead
    // This is for demonstrating properties modalBottomSheetState
    // Check Tutorial 4-5-2 for derivedStateOf
    val currentValue: ModalBottomSheetValue = modalBottomSheetState.currentValue
    val targetValue: ModalBottomSheetValue = modalBottomSheetState.targetValue
    modalBottomSheetState.isVisible

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(top = 16.dp)
    ) {
        Text(
            color = Color.White,
            text = "currentValue: ${currentValue}\n" + "targetValue: ${targetValue}\n"
                    + "isExpanded: ${modalBottomSheetState.isVisible}"
        )
    }
}


@ExperimentalMaterialApi
@Composable
private fun SheetContent() {
    Column(
        // 🔥🔥  Height of this Composable cannot be less than half height of screen
        // if initialValue is ModalBottomSheetValue.HalfExpanded
        // or it crashes with java.lang.IllegalArgumentException:
        // The initial value must have an associated anchor.
//        modifier =Modifier.height(200.dp)
    ) {

        LazyColumn {

            items(userList) { item: String ->
                ListItem(icon = {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.avatar_1_raster),
                        contentDescription = null
                    )
                }, secondaryText = {
                    Text(text = "Secondary text")
                }) {
                    Text(text = item, fontSize = 18.sp)
                }
            }
        }
    }
}

val userList = listOf(
    "User1",
    "User2",
    "User3",
    "User4",
    "User5",
    "User6",
    "User7",
    "User8",
    "User9",
    "User10",
    "User11",
    "User12",
    "User13",
    "User14",
    "User15",
)

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Preview
@Composable
private fun Tutorial2_10_2Preview() {
    TutorialContent()
}
