package code.sh.countup.feature.counter_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import code.sh.countup.R
import code.sh.countup.core.database.entity.CounterEntity
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CounterListScreen(
    onClickCounter: (Int) -> Unit,
    onClickCreateCounter: () -> Unit
) {
    val viewModel: CounterListViewModel = koinViewModel()
    val uiState by viewModel.state.collectAsState()

    CounterList(
        modifier = Modifier.fillMaxSize(),
        counters = uiState.counters,
        onCounterClick = onClickCounter,
        onCreateCounterClick = onClickCreateCounter
    )
}

@Composable
private fun CounterList(
    modifier: Modifier = Modifier,
    counters: List<CounterEntity>,
    onCounterClick: (Int) -> Unit,
    onCreateCounterClick: () -> Unit
) {
    Column(modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                count = counters.size,
                key = { index -> counters[index].uid }
            ) { index ->
                CounterItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .padding(horizontal = 16.dp)
                        .clickable { onCounterClick.invoke(counters[index].uid) },
                    position = index + 1,
                    counter = counters[index]
                )
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = onCreateCounterClick
        ) {
            Text(
                text = stringResource(
                    id = R.string.counter_list_screen_create_new_counter
                )
            )
        }
    }
}

@Composable
private fun CounterItem(
    modifier: Modifier,
    position: Int,
    counter: CounterEntity
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$position:")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = counter.name)
    }
}

@Preview
@Composable
private fun CounterListPreview() {
    val counters = (1..10).map { index ->
        CounterEntity(
            uid = index,
            name = "Counter $index",
        )
    }

    CounterList(
        modifier = Modifier
            .fillMaxSize(),
        counters = counters,
        onCounterClick = {},
        onCreateCounterClick = {}
    )
}