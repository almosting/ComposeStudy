package com.almosting.composestudy

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.stringResource
import com.almosting.composestudy.chapter1.Tutorial1_1Screen
import com.almosting.composestudy.chapter1.Tutorial1_2Screen
import com.almosting.composestudy.chapter2.Tutorial2_1Screen
import com.almosting.composestudy.chapter2.Tutorial2_2Screen
import com.almosting.composestudy.chapter2.Tutorial2_3Screen
import com.almosting.composestudy.chapter2.Tutorial2_4Screen
import com.almosting.composestudy.model.TutorialSectionModel

/**
 * Created on 2022/12/30.
 * @author w.feng
 */

/**
 * Create list of tutorials with titles, action that navigates to composable function
 * inside lambda.
 *
 * * Tags are for search purposes if there is a Search Component exists.
 */
@ExperimentalAnimationApi
@OptIn(ExperimentalMaterialApi::class)
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun createComponentTutorialList(onBack: () -> Unit): List<TutorialSectionModel> {
    val tutorial1_1 = TutorialSectionModel(
        title = stringResource(R.string.title1_1),
        action = {
            Tutorial1_1Screen()
        },
        description = "Create Rows, Columns and Box, how to add modifiers to " +
                "composables. Set padding, margin, alignment other properties of composables.",
        tags = listOf(
            TAG_COMPOSE,
            TAG_COMPOSE_COLUMN,
            TAG_COMPOSE_ROW,
            TAG_COMPOSE_BOX,
            TAG_COMPOSE_MODIFIER
        )
    )

    val tutorial1_2 = TutorialSectionModel(
        title = stringResource(R.string.title1_2),
        description = "Create and modify Surface to draw background for Composables," +
                " add click action to any composable. Set weight or offset modifiers.",
        action = {
            Tutorial1_2Screen()
        },
        tags = listOf(
            TAG_COMPOSE,
            TAG_COMPOSE_MODIFIER,
            TAG_COMPOSE_SURFACE,
            TAG_COMPOSE_SHAPE,
            TAG_COMPOSE_CLICKABLE
        )
    )

    val tutorial2_1 = TutorialSectionModel(
        title = stringResource(R.string.title2_1),
        description = "Create Text component with different properties such as " +
                "color, background, font weight, family, style, spacing and others.",
        action = {
            Tutorial2_1Screen()
        },
        tags = listOf(
            TAG_COMPOSE,
            TAG_TEXT,
            TAG_FONT_STYLE,
            TAG_ANNOTATED_STRING,
            TAG_HYPERLINK
        )
    )

    val tutorial2_2 = TutorialSectionModel(
        title = stringResource(R.string.title2_2),
        description = "Create Button with text and/or with image, Floating Action Button " +
                ", or Chips. Modify properties of buttons such as color, text, or state.",
        action = {
            Tutorial2_2Screen()
        },
        tags = listOf(
            TAG_COMPOSE,
            TAG_BUTTON,
            TAG_ICON_BUTTON,
            TAG_FAB_BUTTON,
            TAG_CHIP
        )
    )

    val tutorial2_3 = TutorialSectionModel(
        title = stringResource(R.string.title2_3),
        description = "Create TextField component with regular style or outlined. Set error," +
                " colors, state, icons, VisualTransformations for phone or " +
                "credit card, and IME actions.",
        action = {
            Tutorial2_3Screen()
        },
        tags = listOf(
            TAG_COMPOSE,
            TAG_TEXT_FIELD,
            TAG_OUTLINED_TEXT_FIELD,
            TAG_IME,
            TAG_VISUAL_TRANSFORMATION,
            TAG_REGEX
        )
    )

    val tutorial2_4 = TutorialSectionModel(
        title = stringResource(R.string.title2_4),
        description = "Create Image to display images, set image and crop styles. " +
                "Change shape of Image or apply ColorFilter and PorterDuff modes.",
        action = {
            Tutorial2_4Screen()
        },
        tags = listOf(
            TAG_COMPOSE,
            TAG_IMAGE,
            TAG_DRAWABLE,
            TAG_VECTOR_DRAWABLE,
            TAG_BITMAP
        )
    )

    return listOf(
        tutorial1_1,
        tutorial1_2,
        tutorial2_1,
        tutorial2_2,
        tutorial2_3,
        tutorial2_4
    )
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun createLayoutTutorialList(): List<TutorialSectionModel> {

    return listOf()
}

@Composable
fun createStateTutorialList(): List<TutorialSectionModel> {

    return listOf()
}

@Composable
fun createGestureTutorialList(): List<TutorialSectionModel> {

    return listOf(
    )
}

@Composable
fun createGraphicsTutorialList(): List<TutorialSectionModel> {

    return listOf(
    )
}
