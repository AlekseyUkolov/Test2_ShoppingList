package com.example.test2_shoppinglist.domain
//класс продукта
data class ShopItem(
    val name: String,
    val amount: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID =-1
    }
}
