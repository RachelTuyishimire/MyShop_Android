package com.example.my_shop

data class ProductResponse(
    var product: List<Products>,
    var total: Int,
    var skip: Int,
    var limit: Int
)
