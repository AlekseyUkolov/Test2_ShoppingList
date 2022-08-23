package com.example.test2_shoppinglist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.test2_shoppinglist.R
import com.example.test2_shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<TextView>(R.id.tv_name)
        var tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
    var count = 0
    //список который мы будем отображать
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    //эта функция указывает как создавать View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("MyLog", "onCreateViewHolder called: ${++count}")
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TUPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown type view: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ShopItemViewHolder(view)
    }
    //эта функция указывает как наполнять элементы , уставнавливать текст и значения View
    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.amount.toString()
        viewHolder.view.setOnLongClickListener() {
            true
        }
    }
    override fun getItemCount(): Int {
        return shopList.size
    }
    //функция возвращает тип Вью, по которому в onCreate мы определим какой шаблон использовать для View
    //метод нужен чтобы определить какой макет нужен для конкретного элемента
    override fun getItemViewType(position: Int): Int {
        val shopItem = shopList[position]
        if (shopItem.enabled) {
            return VIEW_TYPE_ENABLED
        } else {
            return VIEW_TUPE_DISABLED
        }
    }
    companion object {
        const val VIEW_TYPE_ENABLED = 1 //для типа шаблона item_shop_enabled
        const val VIEW_TUPE_DISABLED = 0 //для типа шаблона item_shop_disabled
        const val MAX_POOL_SIZE= 10      //максимальный размер пула Recycler для каждого типа
    }
}