package com.example.template.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("message")
    val message:String,
    @SerializedName("otp")
    val otp:String
)