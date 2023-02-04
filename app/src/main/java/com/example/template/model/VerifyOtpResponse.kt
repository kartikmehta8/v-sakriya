package com.example.template.model

import com.google.gson.annotations.SerializedName

data class VerifyOtpResponse(
    @SerializedName("msg")
    val msg: String
)
