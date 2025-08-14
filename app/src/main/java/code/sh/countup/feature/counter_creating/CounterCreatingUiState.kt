package code.sh.countup.feature.counter_creating

data class CounterCreatingUiState(
    val name: String,
) {
    companion object {
        fun initial() = CounterCreatingUiState(
            name = ""
        )
    }
}