package com.example.test2_shoppinglist.domain

interface ShopListRepository {
    fun addItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemID: Int): ShopItem
    fun getShopList(): List<ShopItem>
}