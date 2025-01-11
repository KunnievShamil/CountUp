package code.sh.countup.feature.root

import code.sh.countup.core.database.entity.RootEntity

data class RootUiState(
    val name: String,
    val age: String,
    val list: List<RootEntity>
) {
    companion object {
        fun init() = RootUiState(
            name = "",
            age = "",
            list = emptyList()
        )
    }
}