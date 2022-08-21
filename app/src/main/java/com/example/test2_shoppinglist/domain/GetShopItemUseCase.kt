package com.example.test2_shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemID: Int): ShopItem{
        return  shopListRepository.getShopItem(shopItemID)
    }
}