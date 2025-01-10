package code.sh.countup.feature.root

import code.sh.countup.core.base.BaseScreenModel

class RootScreenModel : BaseScreenModel<RootUiState, RootUiEvent>(
    initialState = RootUiState.init()
) {
    companion object {
        fun create() = RootScreenModel()
    }
}