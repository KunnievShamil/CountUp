package code.sh.countup.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CounterEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String
)
