package code.sh.countup.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class CounterRecordEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "counter_id") val counterId: Int,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "date") val dateTime: LocalDateTime
)
