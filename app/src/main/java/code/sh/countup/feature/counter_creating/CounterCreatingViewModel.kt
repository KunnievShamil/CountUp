package code.sh.countup.feature.counter_creating

import androidx.lifecycle.viewModelScope
import code.sh.countup.core.database.entity.CounterEntity
import code.sh.countup.core.ui.base.BaseViewModel
import code.sh.countup.domain.repository.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class CounterCreatingViewModel(
    private val counterRepository: CounterRepository
) : BaseViewModel<CounterCreatingUiState, CounterCreatingUiEvent>(
    initialState = CounterCreatingUiState.initial()
) {
    fun onCreateClick() {
        viewModelScope.launch(
            Dispatchers.Default
        ) {
            val id = Random.nextInt()
            counterRepository.createCounter(
                CounterEntity(
                    uid = id,
                    name = state.value.name
                )
            ).also {
                mutableEvent.send(
                    CounterCreatingUiEvent.OnCreateCounter(
                        counterId = id
                    )
                )
            }
        }
    }

    fun onNameChange(newValue: String) {
        viewModelScope.launch {
            mutableState.update { uiState ->
                uiState.copy(name = newValue)
            }
        }
    }
}