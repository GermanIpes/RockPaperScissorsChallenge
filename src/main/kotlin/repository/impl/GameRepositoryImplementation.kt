package repository.impl

import model.PlayerValue
import repository.GameRepository

class GameRepositoryImplementation: GameRepository {
    override fun postPlayer(player: PlayerValue) {
        if (player.playerNumber == 1) player1 = player
        else player2 = player
    }

    override fun getPlayer(playerNumber: Int): PlayerValue {
        return if (playerNumber == 1) player1!!
        else player2!!
    }

    override fun deleteAllPlayers() {
        player1 = null
        player2 = null
    }


    companion object{
        var player1: PlayerValue? = null
        var player2: PlayerValue? = null
    }
}