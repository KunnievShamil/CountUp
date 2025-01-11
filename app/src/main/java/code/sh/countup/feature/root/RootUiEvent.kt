package code.sh.countup.feature.root

import cafe.adriel.voyager.core.screen.Screen
import code.sh.countup.core.ui.base.BaseUiEvent

sealed class RootUiEvent : BaseUiEvent {
    data class NavigateTo(val screen: Screen) : RootUiEvent()
}