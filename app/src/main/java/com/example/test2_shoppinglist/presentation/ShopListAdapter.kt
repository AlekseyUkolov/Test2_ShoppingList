package com.example.test2_shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.test2_shoppinglist.R
import com.example.test2_shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem,ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem)->Unit)? = null
    var onShopItemClickListener: ((ShopItem)->Unit)? = null
    //эта функция указывает как создавать View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown type view: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ShopItemViewHolder(view)
    }
    //эта функция указывает как наполнять элементы , уставнавливать текст и значения View
    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.amount.toString()
        viewHolder.view.setOnLongClickListener() {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener(){
            onShopItemClickListener?.invoke(shopItem)
        }
    }
    //функция возвращает тип Вью, по которому в onCreate мы определим какой шаблон использовать для View
    //метод нужен чтобы определить какой макет нужен для конкретного элемента
    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        if (shopItem.enabled) {
            return VIEW_TYPE_ENABLED
        } else {
            return VIEW_TYPE_DISABLED
        }
    }
    companion object {
        const val VIEW_TYPE_ENABLED = 1 //для типа шаблона item_shop_enabled
        const val VIEW_TYPE_DISABLED = 0 //для типа шаблона item_shop_disabled
        const val MAX_POOL_SIZE= 10      //максимальный размер пула Recycler для каждого типа
    }
}