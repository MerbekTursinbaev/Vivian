package com.example.instagram.data.json.orders

import com.google.gson.annotations.SerializedName

data class Orders<T> (

    @SerializedName("client_id")
    var clientId: Int,
    @SerializedName("client_name")
    var clientName: String,
    @SerializedName("client_phone")
    var clientPhone: String,
    var assistant: String,
    @SerializedName("basket_id")
    var basketId: Int,
    var type: String,
    var color: String,
    @SerializedName("total_sum")
    var totalSum: Int,
    var order: T
)