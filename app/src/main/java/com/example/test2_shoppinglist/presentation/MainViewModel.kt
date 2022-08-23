package com.example.test2_shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test2_shoppinglist.data.ShopListRepositoryImpl
import com.example.test2_shoppinglist.data.ShopListRepositoryImpl.getShopList
import com.example.test2_shoppinglist.domain.DeleteShopItemUseCase
import com.example.test2_shoppinglist.domain.EditShopListItemUseCase
import com.example.test2_shoppinglist.domain.GetShopListUseCase
import com.example.test2_shoppinglist.domain.ShopItem

class MainViewModel:ViewModel() {
    private val repository= ShopListRepositoryImpl

    private val getShopListUseCase= GetShopListUseCase(repository)
    private val deleteShopItemUseCase= DeleteShopItemUseCase(repository)
    private val editShopListItemUseCase= EditShopListItemUseCase(repository)

    val shopList= getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem=shopItem.copy(enabled = !shopItem.enabled)
        editShopListItemUseCase.editShopItem(newItem)
    }
}