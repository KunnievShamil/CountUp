package code.sh.countup.feature.root

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import code.sh.countup.R
import code.sh.countup.core.ui.base.BaseScreen
import org.koin.compose.viewmodel.koinViewModel

class RootScreen : BaseScreen() {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel: RootViewModel = koinViewModel()
        val uiState by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.event.collect { event ->
                when (event) {
                    is RootUiEvent.NavigateTo -> navigator.push(event.screen)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                uiState.list.forEach { entity ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                viewModel.onClickDelete(entity.uid)
                            },
                        text = stringResource(
                            R.string.root_screen_root_item,
                            entity.name,
                            entity.age
                        )
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = uiState.name,
                    onValueChange = viewModel::onChangeName
                )

                OutlinedTextField(
                    value = uiState.age,
                    onValueChange = viewModel::onChangeAge
                )

                Button(
                    onClick = {
                        viewModel.onClickInsert()
                    }
                ) {
                    Text(text = "Add new item")
                }
            }
        }
    }
}