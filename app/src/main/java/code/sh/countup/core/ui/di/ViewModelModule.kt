package code.sh.countup.core.ui.di

import code.sh.countup.feature.counter.CounterViewModel
import code.sh.countup.feature.counter_creating.CounterCreatingViewModel
import code.sh.countup.feature.counter_list.CounterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        CounterCreatingViewModel(
            counterRepository = get()
        )
    }

    viewModel { (counterId: Int) ->
        CounterViewModel(
            counterId = counterId,
            counterRecordsRepository = get()
        )
    }

    viewModel {
        CounterListViewModel(
            counterRepository = get()
        )
    }
}