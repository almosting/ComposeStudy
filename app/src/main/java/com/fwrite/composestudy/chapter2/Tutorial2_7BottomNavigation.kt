package com.fwrite.composestudy.chapter2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fwrite.composestudy.ui.components.StyleableTutorialText
import com.fwrite.composestudy.ui.theme.ComposeStudyTheme
import com.fwrite.composestudy.ui.theme.backgroundColor

@Composable
fun Tutorial2_7Screen() {
    TutorialContent()
}

@Composable
private fun TutorialContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {

            item {
                StyleableTutorialText(
                    text = "1-) BottomNavigation only with Text"
                )
            }

            item {
                TextBottomNavigationComponent()
            }

            item {
                StyleableTutorialText(
                    text = "2-) BottomNavigation only with Icon and content color on " +
                            "BottomNavigation, and selected and unselected colors with " +
                            "BottomNavigationItem"
                )
            }

            item {
                IconBottomNavigationComponent()
            }

            item {
                StyleableTutorialText(
                    text = "3-) BottomNavigation with Icon and Text"
                )
            }

            item {
                BottomNavigationComponent()
            }
        }
    )
}

@Composable
fun TextBottomNavigationComponent() {

    var selectedIndex by remember { mutableStateOf(0) }
    val list = listOf("Home", "Map", "Settings")

    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = Color(0xff212121)
    ) {
        list.forEachIndexed { index: Int, text: String ->
            BottomNavigationItem(
                unselectedContentColor = Color(0xffFF6F00),
                selectedContentColor = Color(0xffFFE082),
                icon = {},
                label = { Text(text) },
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Preview
@Composable
private fun TextBottomNavigationComponentPreview() {
    ComposeStudyTheme {
        TextBottomNavigationComponent()
    }
}

@Composable
fun IconBottomNavigationComponent() {

    var selectedIndex by remember { mutableStateOf(0) }
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Map, Icons.Filled.Settings)

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 1.dp
    ) {
        icons.forEachIndexed { index, imageVector: ImageVector ->
            BottomNavigationItem(
                unselectedContentColor = Color(0xffEF9A9A),
                selectedContentColor = Color(0xffD32F2F),
                icon = { Icon(imageVector, contentDescription = null) },
                label = null,
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Preview
@Composable
private fun IconBottomNavigationComponentPreview() {
    ComposeStudyTheme {
        IconBottomNavigationComponent()
    }
}


@Composable
fun BottomNavigationComponent() {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabContents = listOf(
        "Home" to Icons.Filled.Home,
        "Map" to Icons.Filled.Map,
        "Settings" to Icons.Filled.Settings
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 2.dp
    ) {
        tabContents.forEachIndexed { index, pair: Pair<String, ImageVector> ->
            BottomNavigationItem(
                icon = { Icon(pair.second, contentDescription = null) },
                label = { Text(pair.first) },
                selected = selectedIndex == index,
                alwaysShowLabel = false, // Hides the title for the unselected items
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationComponentPreview() {
    ComposeStudyTheme {
        BottomNavigationComponent()
    }
}
