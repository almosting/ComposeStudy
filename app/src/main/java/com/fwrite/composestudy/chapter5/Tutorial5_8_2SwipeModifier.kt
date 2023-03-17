@file:OptIn(ExperimentalMaterialApi::class)

package com.fwrite.composestudy.chapter5

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.fwrite.composestudy.ui.components.StyleableTutorialText
import com.fwrite.composestudy.ui.theme.Blue400
import com.fwrite.composestudy.ui.theme.BlueGrey400
import kotlin.math.roundToInt

@Composable
fun Tutorial5_8Screen2() {
    // The swipeable modifier lets you drag elements which, when released,
    // animate towards typically two or more anchor points defined in an orientation.
    // A common usage for this is to implement a ‘swipe-to-dismiss’ pattern.
    //
    //It's important to note that this modifier does not move the element,
    // it only detects the gesture. You need to hold the state and represent it on screen by,
    // for example, moving the element via the offset modifier.
    //
    //The swipeable state is required in the swipeable modifier,
    // and can be created and remembered with rememberSwipeableState().
    // This state also provides a set of useful methods to programmatically
    // animate to anchors (see snapTo, animateTo, performFling, and performDrag) as well
    // as properties to observe the dragging progress.
    //
    //The swipe gesture can be configured to have different threshold types,
    // such as FixedThreshold(Dp) and FractionalThreshold(Float), and they can be
    // different for each anchor point from-to combination.
    //
    //For more flexibility, you can configure the resistance when swiping past the bounds
    // and, also, the velocityThreshold which will animate a swipe to the next state,
    // even if the positional thresholds have not been reached.

    TutorialContent()
}

@Composable
private fun TutorialContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        StyleableTutorialText(
            text = "1-) The swipeable modifier lets you drag elements which, when released, \n" +
                    "animate towards typically two or more " +
                    "anchor points defined in an orientation.\n" +
                    "A common usage for this is to implement a **swipe-to-dismiss** pattern."
        )
        SwipeableExample1()
        Spacer(modifier = Modifier.height(20.dp))
        StyleableTutorialText(
            text = "2-) A fractional threshold will be at a fraction of the " +
                    "way between the two anchors of a Composable with **Modifier.swipeable()**."
        )
        SwipeableExample2()
    }
}

@Composable
private fun SwipeableExample1() {
    val width = 96.dp
    val squareSize = 48.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.LightGray)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(Color.DarkGray)
        )
    }
}

@Composable
private fun SwipeableExample2() {

    var fraction by remember { mutableStateOf(0.3f) }

    val swipeableState = rememberSwipeableState(
        initialValue = 0,
        confirmStateChange = {
            true
        }
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Fraction")
        Spacer(modifier = Modifier.width(8.dp))
        Slider(value = fraction, onValueChange = { fraction = it })
    }

    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {

        val width = maxWidth
        val squareSize = 60.dp

        val sizePx = with(LocalDensity.current) { (width - squareSize).toPx() }
        val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states
        Box(
            modifier = Modifier
                .width(width)
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(fraction) },
                    orientation = Orientation.Horizontal
                )
                .background(Color.LightGray, RoundedCornerShape(8.dp))
        ) {
            Box(
                Modifier
                    .offset {
                        IntOffset(swipeableState.offset.value.roundToInt(), 0)
                    }
                    .size(squareSize)
                    .background(Blue400, RoundedCornerShape(8.dp))
            )
        }
    }

    val direction: Float = swipeableState.direction
    val currentValue: Int = swipeableState.currentValue
    val targetValue: Int = swipeableState.targetValue
    val overflow: Float = swipeableState.overflow.value
    val offset: Float = swipeableState.offset.value
    val progress: SwipeProgress<Int> = swipeableState.progress

    Spacer(modifier = Modifier.height(20.dp))
    Column(
        modifier = Modifier
            .background(BlueGrey400)
    ) {

        Text(
            color = Color.White,
            text =
            "direction:$direction\n" +
                    "isAnimationRunning: ${swipeableState.isAnimationRunning}\n" +
                    "currentValue: ${currentValue}\n" +
                    "targetValue: ${targetValue}\n" +
                    "overflow: ${overflow}\n" +
                    "offset: $offset\n" +
                    "progress: $progress"
        )

    }
}

@Preview
@Composable
private fun Tutorial5_8_2Preview() {
    TutorialContent()
}