package code.sh.countup.core.di

import code.sh.countup.data.repository.RootRepositoryImpl
import code.sh.countup.domain.repository.RootRepository
import code.sh.countup.feature.root.RootViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<RootRepository> { RootRepositoryImpl() }
    viewModel { parameters ->
        RootViewModel(
            id = parameters.get(),
            rootRepository = get()
        )
    }
}