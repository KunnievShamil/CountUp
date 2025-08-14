package code.sh.countup.feature.counter

data class CounterUiState(val count: Int) {

    companion object {
        fun initial() = CounterUiState(
            count = 0
        )
    }
}
