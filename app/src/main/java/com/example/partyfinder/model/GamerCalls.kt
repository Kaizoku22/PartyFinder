package com.example.partyfinder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class GamerCalls(
    val gamerCallID:String,
    @PrimaryKey val gamerID:String = "",
    val gamerTag:String,
    val partySize:Int,
    val callDes:String,
    val gameName:String,
    val ProfilePic:String,
    val callDuration:String
)