package code.sh.countup.domain.repository

import code.sh.countup.core.database.entity.CounterEntity
import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    suspend fun createCounter(counter: CounterEntity)
    fun getCounters(): Flow<CounterEntity>
}