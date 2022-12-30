package com.almosting.composestudy

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.almosting.composestudy.model.TutorialSectionModel

/**
 * Created on 2022/12/30.
 * @author w.feng
 */
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun TutorialNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.BASICS_START
) {
    val mainViewModel: HomeViewModel = viewModel()

    if (mainViewModel.tutorialList.isEmpty()) {

        val componentTutorialList: List<TutorialSectionModel> = createComponentTutorialList {
            navController.navigateUp()
        }
        val layoutTutorialList = createLayoutTutorialList()
        val stateTutorialList = createStateTutorialList()
        val gestureTutorialList = createGestureTutorialList()
        val graphicsTutorialList = createGraphicsTutorialList()

        mainViewModel.tutorialList.add(componentTutorialList)
        mainViewModel.tutorialList.add(layoutTutorialList)
        mainViewModel.tutorialList.add(stateTutorialList)
        mainViewModel.tutorialList.add(gestureTutorialList)
        mainViewModel.tutorialList.add(graphicsTutorialList)
    }

    NavHost(
        navController = navController,
        modifier = modifier.statusBarsPadding(),
        startDestination = startDestination
    ) {
        composable(route = Destinations.BASICS_START){
            HomeScreen(
                viewModel = mainViewModel,
                navigateToTutorial = { tutorialTitle ->
                    navController.navigate(tutorialTitle)
                }
            )
        }

        mainViewModel.tutorialList.forEach { list ->
            list.forEach { model ->
                composable(route = model.title) {
                    // This column is used for setting navigation padding since
                    // NavHost only has statusBarsPadding to let main screen list have
                    // inset at the bottom with WindowInsetsSides.Bottom
                    Column(Modifier.navigationBarsPadding()) {
                        // 🔥 These are @Composable screens such as Tutorial2_1Screen()
                        model.action?.invoke()
                    }
                }
            }
        }
    }

}

object Destinations {
    const val BASICS_START = "start_destinations"
}