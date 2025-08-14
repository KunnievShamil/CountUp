package code.sh.countup.feature.counter_creating

import code.sh.countup.core.ui.base.BaseUiEvent

sealed class CounterCreatingUiEvent() : BaseUiEvent {
    data class OnCreateCounter(val counterId: Int) : CounterCreatingUiEvent()
}