package services.impl

import model.GameResult
import model.GameValues
import model.PlayerValue
import repository.GameRepository
import services.GameService

data class GameServiceImplementation(
    val db: GameRepository
): GameService {
    override fun startGame(): GameResult {
        val computer1 = db.getPlayer(playerNumber = 1)
        val computer2 = db.getPlayer(playerNumber = 2)
        return if (computer1.gameValue == computer2.gameValue) {
            GameResult.DRAW
        } else {
            val gameResult = evaluateGameResult(computer1.gameValue, computer2.gameValue)
            if (gameResult) GameResult.FIRST_COMPUTER_WINS
            else GameResult.SECOND_COMPUTER_WINS
        }
    }

    override fun postPlayer(player: PlayerValue) {
        println("The request has arrived!")
        db.postPlayer(player)
    }

    override fun getPlayer(playerNumber: Int): PlayerValue = db.getPlayer(playerNumber)

    override fun deleteAllPlayers() = db.deleteAllPlayers()

    private fun evaluateGameResult(firstComputerValue :GameValues, secondComputerValue: GameValues): Boolean{
        val result:Boolean
        when (firstComputerValue){
            GameValues.ROCK -> {
                result = secondComputerValue == GameValues.LIZARD || secondComputerValue == GameValues.SCISSORS
            }
            GameValues.SCISSORS -> {
                result = secondComputerValue == GameValues.PAPER || secondComputerValue == GameValues.LIZARD
            }
            GameValues.PAPER -> {
                result = secondComputerValue == GameValues.ROCK || secondComputerValue == GameValues.SPOCK
            }
            GameValues.LIZARD -> {
                result = secondComputerValue == GameValues.SPOCK || secondComputerValue == GameValues.PAPER
            }
            GameValues.SPOCK -> {
                result = secondComputerValue == GameValues.ROCK || secondComputerValue == GameValues.SCISSORS
            }
        }
        return result
    }
}