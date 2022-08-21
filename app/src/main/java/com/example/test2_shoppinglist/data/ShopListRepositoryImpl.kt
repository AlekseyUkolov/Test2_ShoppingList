package com.example.test2_shoppinglist.data

import com.example.test2_shoppinglist.domain.ShopItem
import com.example.test2_shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList= mutableListOf<ShopItem>()
    private var autoIncremetID=0

    override fun addItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id= autoIncremetID++ //сначала присвоим итему значение автоинкемента, а потом увеличим его на 1
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement= getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addItem(shopItem)

    }

    override fun getShopItem(shopItemID: Int): ShopItem {
        return shopList.find {
            it.id == shopItemID
        } ?: throw RuntimeException("Element with ID $shopItemID not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList() // создаем копию, чтобы из других мест программы нельзя было изменить наш список
    }

}