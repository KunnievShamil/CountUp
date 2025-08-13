package code.sh.countup.domain.repository

import code.sh.countup.core.database.entity.CounterEntity
import kotlinx.coroutines.flow.Flow

interface CounterRepository {
     fun getCounters(): Flow<CounterEntity>
}