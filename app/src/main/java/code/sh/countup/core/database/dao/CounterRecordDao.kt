package code.sh.countup.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import code.sh.countup.core.database.entity.CounterRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterRecordDao {

    @Insert
    suspend fun insert(counterRecordEntity: CounterRecordEntity)

    @Query("SELECT * FROM CounterRecordEntity WHERE counter_id = :id")
    fun getCounterRecords(id: Int): Flow<List<CounterRecordEntity>>
}