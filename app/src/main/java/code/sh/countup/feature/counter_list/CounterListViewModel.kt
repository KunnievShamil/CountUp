package code.sh.countup.feature.counter_list

import androidx.lifecycle.viewModelScope
import code.sh.countup.core.ui.base.BaseViewModel
import code.sh.countup.domain.repository.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterListViewModel(
    private val counterRepository: CounterRepository
) : BaseViewModel<CounterListUiState, CounterListUiEvent>(
    initialState = CounterListUiState.initial()
) {
    init {
        loadCounters()
    }

    private fun loadCounters() {
        viewModelScope.launch(Dispatchers.Default) {
            counterRepository.getCounters().collect { counters ->
                mutableState.update { uiState ->
                    uiState.copy(
                        counters = counters
                    )
                }
            }
        }
    }
}