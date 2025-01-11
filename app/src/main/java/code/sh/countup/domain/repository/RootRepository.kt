package code.sh.countup.domain.repository

import code.sh.countup.core.database.entity.RootEntity

interface RootRepository {
    suspend fun getAllRoots(): List<RootEntity>
    suspend fun insertRoot(rootEntity: RootEntity)
    suspend fun deleteRoot(id: Int)
}