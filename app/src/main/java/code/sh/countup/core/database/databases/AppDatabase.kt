package code.sh.countup.core.database.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import code.sh.countup.core.database.converters.LocalDateTimeConverter
import code.sh.countup.core.database.dao.CounterDao
import code.sh.countup.core.database.dao.CounterRecordDao
import code.sh.countup.core.database.dao.RootDao
import code.sh.countup.core.database.entity.CounterEntity
import code.sh.countup.core.database.entity.CounterRecordEntity
import code.sh.countup.core.database.entity.RootEntity

@Database(
    entities = [
        RootEntity::class,
        CounterEntity::class,
        CounterRecordEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rootDao(): RootDao
    abstract fun counterDao(): CounterDao
    abstract fun counterRecordsDao(): CounterRecordDao
}