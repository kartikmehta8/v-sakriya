package com.example.template.model


import com.google.gson.annotations.SerializedName

data class carRequest(
    @SerializedName("police_station")
    val policeStation: String
)