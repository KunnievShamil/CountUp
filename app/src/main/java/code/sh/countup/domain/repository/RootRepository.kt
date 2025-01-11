package code.sh.countup.domain.repository

interface RootRepository {
    suspend fun getName(): String
}