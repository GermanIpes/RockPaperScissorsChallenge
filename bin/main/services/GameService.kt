package services

import model.GameResult
import model.PlayerValue

interface GameService {
    fun startGame(): GameResult
    fun postPlayer(player: PlayerValue)
    fun getPlayer(playerNumber: Int): PlayerValue
    fun deleteAllPlayers()
}