package code.sh.countup.domain.repository

import code.sh.countup.core.database.entity.CounterRecordEntity
import kotlinx.coroutines.flow.Flow

interface CounterRecordsRepository {
    suspend fun createCounterRecord(counterRecord: CounterRecordEntity)
    fun getCounterRecords(counterId: Int): Flow<List<CounterRecordEntity>>
}