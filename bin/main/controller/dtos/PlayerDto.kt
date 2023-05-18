package controller.dtos

import model.GameValues
import model.PlayerValue

data class PlayerDto(
    val map: Map<String, String>
) {
    private val playerNumber by map
    val gameValue by map

    fun toModel(): PlayerValue = PlayerValue(
        this.playerNumber as Int,
        this.gameValue as GameValues
    )
}