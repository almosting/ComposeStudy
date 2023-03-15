package com.fwrite.composestudy.ui.components

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

/**
 * Created on 2022/12/30.
 * @author w.feng
 */
fun getRandomColor() =  Color(
    red = Random.nextInt(256),
    green = Random.nextInt(256),
    blue = Random.nextInt(256),
    alpha = 255
)