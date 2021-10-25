package com.example.instagram.data.json.orders

import com.google.gson.annotations.SerializedName

data class Order(
    var id: Int,
    @SerializedName("basket_id")
    var basketId: Int,
    var count: Int = 1,
    @SerializedName("order_price")
    var orderPrice: Int,
    @SerializedName("client_id")
    var clientId: Int,
    @SerializedName("product_name")
    var productName: String,
)