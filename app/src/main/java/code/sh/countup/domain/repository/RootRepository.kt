package code.sh.countup.domain.repository

import code.sh.countup.core.database.entity.RootEntity
import kotlinx.coroutines.flow.Flow

interface RootRepository {
    suspend fun getAllRoots(): Flow<List<RootEntity>>
    suspend fun insertRoot(rootEntity: RootEntity)
    suspend fun deleteRoot(id: Int)
}