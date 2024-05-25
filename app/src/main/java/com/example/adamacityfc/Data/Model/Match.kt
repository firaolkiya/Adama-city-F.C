package com.example.adamacityfc.Data.Model

data class Match(
    val matchType: String,
    val matchId: Int,
    val isPlayed: Boolean? = false,
    val othersTeamName:String,
    val adamaScore:Int=0,
    val othersScore:Int=0,
    val date: String
)