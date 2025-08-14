package code.sh.countup.feature.counter_list

import code.sh.countup.core.database.entity.CounterEntity

data class CounterListUiState(val counters: List<CounterEntity>) {

    companion object {
        fun initial() = CounterListUiState(
            counters = emptyList()
        )
    }
}