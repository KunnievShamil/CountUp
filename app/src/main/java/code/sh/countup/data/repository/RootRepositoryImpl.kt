package code.sh.countup.data.repository

import code.sh.countup.core.database.dao.RootDao
import code.sh.countup.core.database.entity.RootEntity
import code.sh.countup.domain.repository.RootRepository

class RootRepositoryImpl(
    private val rootDao: RootDao
) : RootRepository {

    override suspend fun getAllRoots(): List<RootEntity> {
        return rootDao.getAll()
    }

    override suspend fun insertRoot(rootEntity: RootEntity) {
        rootDao.insert(rootEntity)
    }

    override suspend fun deleteRoot(id: Int) {
        rootDao.delete(id)
    }
}