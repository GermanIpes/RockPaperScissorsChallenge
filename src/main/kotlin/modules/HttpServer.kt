package modules

import io.javalin.Javalin

object HttpServer {
    const val PORT = 8080

    fun start(controllerModule: ControllerModule){
        Javalin.create().routes {
            controllerModule.gameController.routes()
        }.start(PORT)
    }
}