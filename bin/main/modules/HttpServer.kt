package modules

import io.javalin.Javalin

object HttpServer {
    const val PORT = 80

    fun start(controllerModule: ControllerModule) {
        Javalin.create { config ->
            config.plugins.enableCors { cors ->
                cors.add {
                    it.anyHost()
                }
            }
        }.routes {
            controllerModule.gameController.routes()
        }.start(PORT)
    }
}