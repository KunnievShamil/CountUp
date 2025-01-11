package code.sh.countup.core.ui.di

import code.sh.countup.feature.root.RootViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        RootViewModel(
            rootRepository = get()
        )
    }
}