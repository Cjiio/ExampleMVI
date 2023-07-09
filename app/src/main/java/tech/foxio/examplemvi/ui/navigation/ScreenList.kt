package tech.foxio.examplemvi.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

const val ROOT_GRAPH_ROUTE = "ROOT"
const val SPLASH_GRAPH_ROUTE = "SPLASH"
const val GUIDE_GRAPH_ROUTE = "GUIDE"
const val AUTH_GRAPH_ROUTE = "AUTH"

sealed class ScreenList(
    val route: String,
    val title: Int? = null,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
) {
    object SplashScreen : ScreenList("SplashScreen")
    object GuideScreen : ScreenList("GuideScreen")
    object AuthPerScreen : ScreenList("AuthPerScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object RegisterScreen : ScreenList("RegisterScreen")
}