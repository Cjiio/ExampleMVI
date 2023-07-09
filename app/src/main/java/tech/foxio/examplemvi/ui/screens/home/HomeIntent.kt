package tech.foxio.examplemvi.ui.screens.home

sealed class HomeIntent {
    object LoadData : HomeIntent()
}