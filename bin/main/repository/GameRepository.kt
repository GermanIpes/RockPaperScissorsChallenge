package repository

import model.PlayerValue

interface GameRepository {
    fun postPlayer(player: PlayerValue)
    fun getPlayer(playerNumber: Int): PlayerValue
    fun deleteAllPlayers()
}