package modules

import repository.GameRepository
import repository.impl.GameRepositoryImplementation

data class DbModule(
    val gameRepository: GameRepository
){
    companion object{
        fun create(): DbModule{
            return DbModule(
                gameRepository = GameRepositoryImplementation()
            )
        }
    }
}