package sk.upjs.vma.quizapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName="players")
class QuizDB(playerName: String, var score: Int = 0): Serializable {

        var playerName: String = playerName
            set(value) {
                field = value

            }

    @PrimaryKey
    var uuid: UUID = UUID.randomUUID()

    override fun toString(): String {
        return "QuizDB(playerName=$playerName, score=$score"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QuizDB

        if (playerName != other.playerName) return false
        if (score != other.score) return false
        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        var result = score
        result = 31 * result + playerName.hashCode()
        result = 31 * result + uuid.hashCode()
        return result
    }

    companion object {
        fun emptyWeblink(): QuizDB = QuizDB(playerName = "")
    }


}