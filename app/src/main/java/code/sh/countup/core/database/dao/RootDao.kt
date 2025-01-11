package code.sh.countup.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import code.sh.countup.core.database.entity.RootEntity

@Dao
interface RootDao {
    @Query("SELECT * From RootEntity")
    suspend fun getAll(): List<RootEntity>

    @Insert
    suspend fun insert(rootEntity: RootEntity)

    @Query("DELETE FROM RootEntity WHERE uid = :id")
    suspend fun delete(id: Int)
}