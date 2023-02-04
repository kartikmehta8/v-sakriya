package com.example.template.model


import com.google.gson.annotations.SerializedName

data class CarResponce(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("_id")
        val id: String,
        @SerializedName("missing_details")
        val missingDetails: MissingDetails
    ) {
        data class MissingDetails(
            @SerializedName("car_number_")
            val carNumber: String,
            @SerializedName("place")
            val place: String,
            @SerializedName("police_station")
            val policeStation: String,
            @SerializedName("time")
            val time: String
        )
    }
}