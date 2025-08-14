package code.sh.countup.feature.counter

import androidx.lifecycle.viewModelScope
import code.sh.countup.core.database.entity.CounterRecordEntity
import code.sh.countup.core.ui.base.BaseViewModel
import code.sh.countup.domain.repository.CounterRecordsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import kotlin.random.Random

class CounterViewModel(
    private val counterId: Int,
    private val counterRecordsRepository: CounterRecordsRepository
) : BaseViewModel<CounterUiState, CounterUiEvent>(
    initialState = CounterUiState.initial()
) {
    init {
        observeCounterRecords()
    }

    fun observeCounterRecords() {
        viewModelScope.launch(
            Dispatchers.Default
        ) {
            counterRecordsRepository.getCounterRecords(counterId).collect {
                mutableState.update { uiState ->
                    uiState.copy(
                        count = it.size
                    )
                }
            }
        }
    }

    fun onCountClick() {
        viewModelScope.launch(
            Dispatchers.Default
        ) {
            val id = Random.nextInt()
            val dateTime = LocalDateTime.now()

            counterRecordsRepository.createCounterRecord(
                CounterRecordEntity(
                    uid = id,
                    counterId = counterId,
                    age = 1,
                    dateTime = dateTime,
                )
            )
        }
    }
}