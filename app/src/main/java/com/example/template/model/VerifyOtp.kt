package com.example.template.model


import com.google.gson.annotations.SerializedName

data class VerifyOtp(
    @SerializedName("otp")
    val otp: Int
)