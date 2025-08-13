package code.sh.countup.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import code.sh.countup.core.database.entity.CounterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterDao {

    @Insert
    fun insert(counterEntity: CounterEntity)

    @Query("SELECT * FROM CounterEntity")
    fun getAllCounters(): Flow<CounterEntity>
}