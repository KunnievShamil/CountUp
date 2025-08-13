package code.sh.countup.core.database.converters

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class LocalDateTimeConverter {

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime?): Long? {
        val defaultZoneId = ZoneId.systemDefault()
        return value?.atZone(defaultZoneId)?.toInstant()?.toEpochMilli()
    }

    @TypeConverter
    fun toLocalDateTime(value: Long?): LocalDateTime? {
        return value?.let {
            Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDateTime()
        }
    }
}