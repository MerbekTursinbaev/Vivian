package com.example.instagram.data.json

data class MyResponse<T> (
    var successful: Boolean,
    var code: Int,
    var message: String,
    var payload: T
)