package com.fwrite.composestudy.chapter2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun Tutorial2_9Screen4() {
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

    ModalDrawer(
        drawerState = drawerState,
        drawerShape = RoundedCornerShape(topEnd = 24.dp),
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
            Scaffold(
                topBar = {
                    ModalDrawerTopAppBar(openDrawer)
                }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ModalContent(openDrawer)
                    }
                }
            }
        }
    )
}