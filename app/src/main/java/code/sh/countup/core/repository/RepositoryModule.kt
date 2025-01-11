package code.sh.countup.core.repository

import code.sh.countup.data.repository.RootRepositoryImpl
import code.sh.countup.domain.repository.RootRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RootRepository> { RootRepositoryImpl(get()) }
}
