package code.sh.countup.data.repository

import code.sh.countup.domain.repository.RootRepository

class RootRepositoryImpl : RootRepository {
    override suspend fun getName(): String {
        return "Stephan"
    }
}