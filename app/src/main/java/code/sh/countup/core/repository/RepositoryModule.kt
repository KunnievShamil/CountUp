package code.sh.countup.core.repository

import code.sh.countup.data.repository.CounterRecordsRepositoryImpl
import code.sh.countup.data.repository.CounterRepositoryImpl
import code.sh.countup.domain.repository.CounterRecordsRepository
import code.sh.countup.domain.repository.CounterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CounterRepository> { CounterRepositoryImpl(counterDao = get()) }
    single<CounterRecordsRepository> { CounterRecordsRepositoryImpl(counterRecordDao = get()) }
}
