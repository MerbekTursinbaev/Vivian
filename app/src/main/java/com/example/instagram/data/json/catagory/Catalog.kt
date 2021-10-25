package com.example.instagram.data.json.catagory

data class Catalog(
    var id: Int,
    var category_id: Int,
    var name: String,
    var description: String,
    var full_image: String,
    var image: String,
    var price: Int,
    var brand: String,
    var mode_app: String,
    var keeping: Int,
    var conditions: String,
    var point: Int,
    var count: Int = 1
)