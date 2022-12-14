package com.example.test2_shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemID: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}