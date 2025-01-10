package code.sh.countup.core.base

import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseScreenModel<S, E : BaseUiEvent>(initialState: S) :
    StateScreenModel<S>(initialState) {
    protected val mutableEvent = Channel<E>()
    val event = mutableEvent.receiveAsFlow()
}
