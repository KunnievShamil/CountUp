package code.sh.countup.feature.counter_creating

import cafe.adriel.voyager.core.screen.Screen
import code.sh.countup.core.ui.base.BaseUiEvent

sealed class CounterCreatingUiEvent() : BaseUiEvent {
    data class NavigateTo(val screen: Screen) : CounterCreatingUiEvent()
}