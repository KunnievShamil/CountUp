package code.sh.countup.feature.counter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CounterScreen(counterId: Int) {

    val viewModel: CounterViewModel = koinViewModel(
        parameters = { parametersOf(counterId) }
    )

    val uiState by viewModel.state.collectAsState()

    Counter(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        count = uiState.count,
        onCountClick = viewModel::onCountClick
    )
}

@Composable
private fun Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onCountClick: () -> Unit
) {
    Box(
        modifier = modifier.clickable { onCountClick.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = count.toString(),
            fontSize = 128.sp
        )
    }
}

@Preview
@Composable
private fun CounterPreview() {
    Counter(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        count = 32,
        onCountClick = {}
    )
}