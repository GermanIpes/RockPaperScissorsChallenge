package services

import model.PlayerValue

interface GameService {
    fun startGame(): Int
    fun postPlayer(player: PlayerValue)
    fun getPlayer(playerNumber: Int): PlayerValue
    fun deleteAllPlayers()
}