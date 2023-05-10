package modules

import services.GameService
import services.impl.GameServiceImplementation

data class ServiceModule(
    val gameService: GameService
) {
    companion object{
        fun create(dbModule: DbModule): ServiceModule {
            return ServiceModule(
                gameService = GameServiceImplementation(dbModule.gameRepository)
            )
        }
    }
}