package com.example.instagram.retrofit.ui.order.basket

import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.data.json.orders.Order

class Basket(product: Catalog) {

    var id = product.id
    var price = product.price
    var count = product.count

    var product : MutableList<Catalog> = mutableListOf()

    fun addOrder() {
        product.forEach {
            if (it.id == id) {
                count++
            } else{
                product.add(it)
            }
        }
    }

    fun onRemoved() {

    }
}