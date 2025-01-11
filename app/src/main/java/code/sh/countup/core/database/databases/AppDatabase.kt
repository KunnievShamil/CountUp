package code.sh.countup.core.database.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import code.sh.countup.core.database.dao.RootDao
import code.sh.countup.core.database.entity.RootEntity

@Database(entities = [RootEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rootDao(): RootDao
}