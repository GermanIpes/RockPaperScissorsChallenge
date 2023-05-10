package modules

import controller.GameController

data class ControllerModule(
    val gameController: GameController
) {
    companion object{
        fun create(serviceModule: ServiceModule): ControllerModule {
            return ControllerModule(
                gameController = GameController(serviceModule.gameService)
            )
        }
    }
}