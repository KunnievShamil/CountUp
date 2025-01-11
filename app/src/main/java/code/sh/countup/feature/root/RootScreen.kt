package code.sh.countup.feature.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import code.sh.countup.core.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

class RootScreen : BaseScreen() {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel: RootViewModel = koinViewModel { parametersOf("4823") }
        val uiState by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.event.collect { event ->
                when (event) {
                    is RootUiEvent.NavigateTo -> navigator.push(event.screen)
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = uiState.title)
        }
    }
}