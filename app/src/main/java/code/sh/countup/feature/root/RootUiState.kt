package code.sh.countup.feature.root

data class RootUiState(
    val title: String
) {
    companion object {
        fun init() = RootUiState(
            title = "Hello Android!"
        )
    }
}
