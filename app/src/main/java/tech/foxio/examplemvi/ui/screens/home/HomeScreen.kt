package tech.foxio.examplemvi.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val dataState by homeViewModel.dataState.collectAsState()
    Column {
        Text(text = dataState.data)
        Button(
            onClick = {
                homeViewModel.sendUIIntent(homeIntent = HomeIntent.LoadData)
            }
        ) {
            Text(text ="Load Data")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}