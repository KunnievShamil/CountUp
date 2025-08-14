package code.sh.countup.data.repository

import code.sh.countup.core.database.dao.CounterRecordDao
import code.sh.countup.core.database.entity.CounterRecordEntity
import code.sh.countup.domain.repository.CounterRecordsRepository
import kotlinx.coroutines.flow.Flow

class CounterRecordsRepositoryImpl(
    private val counterRecordDao: CounterRecordDao
) : CounterRecordsRepository {
    override suspend fun createCounterRecord(counterRecord: CounterRecordEntity) {
        counterRecordDao.insert(counterRecordEntity = counterRecord)
    }

    override fun getCounterRecords(counterId: Int): Flow<List<CounterRecordEntity>> {
        return counterRecordDao.getCounterRecords(id = counterId)
    }
}