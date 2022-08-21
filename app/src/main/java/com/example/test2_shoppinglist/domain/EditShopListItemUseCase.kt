package com.example.test2_shoppinglist.domain

class EditShopListItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        //shopItemID идентификатор ShopItem
        shopListRepository.editShopItem(shopItem)
    }

}