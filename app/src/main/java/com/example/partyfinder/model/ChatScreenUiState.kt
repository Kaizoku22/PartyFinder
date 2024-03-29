package com.example.partyfinder.model

import com.example.partyfinder.data.ChatChannel
import com.example.partyfinder.datasource.datasource

data class ChatScreenUiState(
    val channelList:List<ChatChannel> =datasource.ChatChannels,
    val isMenuClicked:Boolean=false,
    val isDmTopbarMenuClicked:Boolean=false,

)