package com.example.test2_shoppinglist.domain
//Добавление Продукта в список
class AddShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addItem(shopItem: ShopItem){
        shopListRepository.addItem(shopItem)
    }
}