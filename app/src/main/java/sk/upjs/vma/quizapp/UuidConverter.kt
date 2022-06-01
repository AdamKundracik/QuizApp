package sk.upjs.vma.quizapp

import androidx.room.TypeConverter
import java.util.*

class UuidConverter {

    @TypeConverter
    fun uuidToString(uuid: UUID): String = uuid.toString()

    @TypeConverter
    fun stringToUuid(string: String): UUID = UUID.fromString(string)
}
