package code.sh.countup.core.di

import code.sh.countup.core.database.di.databaseModule
import code.sh.countup.core.repository.repositoryModule
import code.sh.countup.core.ui.di.viewModelModule

val appModule = listOf(
    databaseModule,
    repositoryModule,
    viewModelModule
)
