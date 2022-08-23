package com.example.test2_shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.test2_shoppinglist.domain.ShopItem

class ShopListDiffCallback(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }
    override fun getNewListSize(): Int {
        return newList.size
    }
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem=oldList[oldItemPosition]
        val newItem=oldList[newItemPosition]
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem=oldList[oldItemPosition]
        val newItem=oldList[newItemPosition]
        return oldItem==newItem
    }
}