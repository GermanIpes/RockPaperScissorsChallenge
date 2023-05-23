package controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.Context
import io.javalin.plugin.openapi.dsl.document
import io.javalin.plugin.openapi.dsl.documented
import model.PlayerValue
import services.GameService

class GameController(
    private val gameService: GameService
) {
    fun routes() {
        path("/v1/GameResult") {
            get(documented(getGameResultDoc, ::getGameResult))
        }
        path("/v1/Player/{playerId}") {
            get(documented(getPlayerDoc, ::getPlayer))
        }
        path("/v1/Players") {
            post(documented(postPlayer, ::postPlayer))
            delete(documented(deleteAllPlayersDoc, ::deleteAllPlayers))
        }
    }

    private val postPlayer = document().json<PlayerValue>("200")
    private val getGameResultDoc = document().json<String>("200")
    private val getPlayerDoc = document().json<String>("200")
    private val deleteAllPlayersDoc = document().json<String>("200")

    private fun postPlayer(ctx: Context){
        val mapper = jacksonObjectMapper()
        val player = mapper.readValue(ctx.body(), PlayerValue::class.java)
        println("The player with id:${player.playerNumber} is being processed")
        ctx.json(gameService.postPlayer(player))
    }

    private fun getGameResult(ctx: Context){
        ctx.json(gameService.startGame())
    }

    private fun getPlayer(ctx: Context){
        ctx.json(gameService.getPlayer(ctx.pathParam("playerId").toInt()))
    }

    private fun deleteAllPlayers(ctx: Context){
        ctx.json(gameService.deleteAllPlayers())
    }
}