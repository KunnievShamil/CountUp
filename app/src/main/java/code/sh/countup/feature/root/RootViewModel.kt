package code.sh.countup.feature.root

import androidx.lifecycle.viewModelScope
import code.sh.countup.core.base.BaseViewModel
import code.sh.countup.domain.repository.RootRepository
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RootViewModel(
    private val id: String,
    private val rootRepository: RootRepository
) : BaseViewModel<RootUiState, RootUiEvent>(
    initialState = RootUiState.init()
) {
    init {
        getName()
    }

    private fun getName() {
        viewModelScope.launch {
            val name = rootRepository.getName()
            mutableState.update { uiState ->
                uiState.copy(title = "$name: $id")
            }
        }
    }
}