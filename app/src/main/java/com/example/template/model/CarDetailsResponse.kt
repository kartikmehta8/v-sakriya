package com.example.template.model


import com.google.gson.annotations.SerializedName

data class CarDetailsResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("car_Details")
        val carDetails: CarDetails,
        @SerializedName("_id")
        val id: String,
        @SerializedName("missing_details")
        val missingDetails: MissingDetails,
        @SerializedName("owner")
        val owner: Owner
    ) {
        data class CarDetails(
            @SerializedName("car_model")
            val carModel: String,
            @SerializedName("car_number")
            val carNumber: String,
            @SerializedName("color")
            val color: String,
            @SerializedName("engine_number")
            val engineNumber: String
        )

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

        data class Owner(
            @SerializedName("name")
            val name: String,
            @SerializedName("phone")
            val phone: String
        )
    }
}