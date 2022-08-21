package com.example.test2_shoppinglist.domain
//класс продукта
data class ShopItem(
    val id: Int,
    val name: String,
    val amount: Int,
    val enabled: Boolean
)
