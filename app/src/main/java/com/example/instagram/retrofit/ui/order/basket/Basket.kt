package com.example.instagram.retrofit.ui.order.basket

import com.example.instagram.data.json.catagory.Catalog

class Basket() {

    var basket: MutableList<Catalog> = mutableListOf()

    fun addOrder(product: Catalog, onDone: (product: Catalog) -> Unit) {
        val count = basket.find { it.id == product.id }
        if (count == null) {
            basket.add(product)
            onDone.invoke(product)
        } else {
            val index = basket.indexOf(count)
            basket[index].count++
            onDone.invoke(basket[index])
        }
    }

    fun onRemove(product: Catalog, onDone: (product: Catalog) -> Unit) {
        val count = basket.find { it.id == product.id }
        val index = basket.indexOf(count)
        basket[index].count--
        onDone.invoke(basket[index])
    }

    fun getProductCount(product: Catalog) : Int {
        val count = basket.find { it.id == product.id }
        return count?.count?:0
    }

}