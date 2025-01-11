package code.sh.countup.feature.root

import androidx.lifecycle.viewModelScope
import code.sh.countup.core.database.entity.RootEntity
import code.sh.countup.core.ui.base.BaseViewModel
import code.sh.countup.domain.repository.RootRepository
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class RootViewModel(
    private val rootRepository: RootRepository
) : BaseViewModel<RootUiState, RootUiEvent>(
    initialState = RootUiState.init()
) {

    init {
        getList()
    }

    fun onChangeName(name: String) {
        viewModelScope.launch {
            mutableState.update { uiState ->
                uiState.copy(name = name)
            }
        }
    }

    fun onChangeAge(age: String) {
        viewModelScope.launch {
            mutableState.update { uiState ->
                uiState.copy(age = age)
            }
        }
    }

    fun onClickInsert() {
        viewModelScope.launch {
            val id = Random.nextInt()
            rootRepository.insertRoot(
                rootEntity = RootEntity(
                    uid = id,
                    name = state.value.name,
                    age = state.value.age
                )
            )
            getList()
        }
    }

    fun onClickDelete(id: Int) {
        viewModelScope.launch {
            rootRepository.deleteRoot(id)
        }
    }

    private fun getList() {
        viewModelScope.launch {
            val list = rootRepository.getAllRoots()
            mutableState.update { uiState ->
                uiState.copy(
                    list = list
                )
            }
        }
    }
}