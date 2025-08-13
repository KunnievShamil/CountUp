package code.sh.countup.data.repository

import code.sh.countup.core.database.dao.CounterDao
import code.sh.countup.core.database.entity.CounterEntity
import code.sh.countup.domain.repository.CounterRepository
import kotlinx.coroutines.flow.Flow

class CounterRepositoryImpl(
    private val counterDao: CounterDao
) : CounterRepository {
    override fun getCounters(): Flow<CounterEntity> {
        return counterDao.getAllCounters()
    }
}