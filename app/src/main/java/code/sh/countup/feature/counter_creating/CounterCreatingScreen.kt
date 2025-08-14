package code.sh.countup.feature.counter_creating

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import code.sh.countup.R
import code.sh.countup.core.ui.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel

class CounterCreatingScreen : BaseScreen() {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel: CounterCreatingViewModel = koinViewModel()
        val uiState by viewModel.state.collectAsState()

        CounterCreating(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            nameValue = uiState.name,
            onCreateClick = viewModel::onCreateClick,
            onNameChange = viewModel::onNameChange
        )
    }
}

@Composable
private fun CounterCreating(
    modifier: Modifier = Modifier,
    nameValue: String,
    onCreateClick: () -> Unit,
    onNameChange: (String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nameValue,
            onValueChange = onNameChange
        )

        Button(onClick = onCreateClick) {
            Text(
                text = stringResource(
                    R.string.counter_creating_screen_create_counter
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CounterCreatingPreview() {
    CounterCreating(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        nameValue = "Подтягивания",
        onCreateClick = {

        },
        onNameChange = {

        }
    )
}