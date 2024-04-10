package com.example.mobiledevelopmentcourselabapp.presentation.view.second.model

import java.io.Serializable

interface ItemUiModel : Serializable

class model (
    val name: String,
    val photoUrl: String,
    val number: Int,
    val team: String,
    val age: Int,
    val position: PlayerPosition,
    var isExpanded:Boolean = false

    ):ItemUiModel  {
}
enum class PlayerPosition(val rusName: String){
    GOALKEEPER(rusName = "Вратарь"),
    DEFENDER(rusName = "Защитник"),
    MIDFIELD(rusName = "Полузащитник"),
    FORWARD(rusName = "Защитник")

}