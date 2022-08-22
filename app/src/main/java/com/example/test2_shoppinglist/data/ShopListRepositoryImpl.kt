package com.example.test2_shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test2_shoppinglist.domain.ShopItem
import com.example.test2_shoppinglist.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository {
    private val shopListLD: MutableLiveData<List<ShopItem>> = MutableLiveData()

    private val shopList= mutableListOf<ShopItem>()
    private var autoIncremetID=0
    //заполняем список тестовыми значениями
    init {
        for(i in 0 until 10){
            val item= ShopItem("Name_$i", Random.nextInt(0,100),true)
            //shopList.add(i,item)
            addItem(item)
        }
    }

    override fun addItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id= autoIncremetID++ //сначала присвоим итему значение автоинкемента, а потом увеличим его на 1
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement= getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addItem(shopItem)
        updateList()

    }

    override fun getShopItem(shopItemID: Int): ShopItem {
        return shopList.find {
            it.id == shopItemID
        } ?: throw RuntimeException("Element with ID $shopItemID not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    fun updateList(){
        shopListLD.value= shopList.toList() //помещаем в лайфдату копию списка
    }

}