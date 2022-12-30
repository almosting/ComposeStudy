package com.almosting.composestudy

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

/**
 * Created on 2022/12/30.
 * @author w.feng
 */
@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun MainScreen(){
    Scaffold { paddingValues: PaddingValues ->
        TutorialNavGraph(modifier = Modifier.padding(paddingValues))
    }
}