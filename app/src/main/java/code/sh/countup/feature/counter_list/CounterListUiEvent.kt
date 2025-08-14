package code.sh.countup.feature.counter_list

import cafe.adriel.voyager.core.screen.Screen
import code.sh.countup.core.ui.base.BaseUiEvent

sealed class CounterListUiEvent : BaseUiEvent {
    data class NavigateTo(val screen: Screen) : CounterListUiEvent()
}