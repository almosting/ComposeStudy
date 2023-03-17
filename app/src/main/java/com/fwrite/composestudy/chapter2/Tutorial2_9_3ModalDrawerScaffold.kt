package com.fwrite.composestudy.chapter2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun Tutorial2_9Screen3() {
    TutorialContent()
}

@ExperimentalMaterialApi
@Composable
private fun TutorialContent() {
    ModalDrawerComponent()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
private fun ModalDrawerComponent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val openDrawer: () -> Unit = { coroutineScope.launch { drawerState.open() } }
    val closeDrawer: () -> Unit = { coroutineScope.launch { drawerState.close() } }
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            ModalDrawerTopAppBar(openDrawer)
        },

        ) {
        ModalDrawer(
            drawerElevation = 24.dp,
            drawerShape = CutCornerShape(topEnd = 24.dp),
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerContentHeader()
                Divider()
                ModelDrawerContentBody(
                    selectedIndex,
                    onSelected = {
                        selectedIndex = it
                    },
                    closeDrawer = closeDrawer
                )
            },
            content = {
                Column(modifier = Modifier.fillMaxSize()) {
                    ModalContent(openDrawer)
                }

            }
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun Tutorial2_9_3Preview() {
    TutorialContent()
}
