package modules

object ModuleLoader {

    fun loadModules(){
        val dbModule = DbModule.create()
        val serviceModule = ServiceModule.create(dbModule)
        val controllerModule = ControllerModule.create(serviceModule)

        HttpServer.start(controllerModule)
    }
}