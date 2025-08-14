package code.sh.countup.core.database.di

import android.app.Application
import androidx.room.Room
import code.sh.countup.core.database.databases.AppDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "countup.db"

val databaseModule = module {

    single {
        Room.databaseBuilder(
            context = get<Application>(),
            klass = AppDatabase::class.java,
            name = DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().counterDao() }
    single { get<AppDatabase>().counterRecordsDao() }
}