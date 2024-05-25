package com.example.adamacityfc.Data.Model

data class Player(
    val name: String,
    val age:Int,
    val image: Int,
    val role:String,
    val goal:Int,
    val shootToTarget: Int,
    val assists: Int,
    val shirtNumber: Int,
    val totalPlayed:Int,
    val minutes:Float,
    val passingAccuracy: Float?=0.4f
)