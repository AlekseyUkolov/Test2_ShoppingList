package com.example.test2_shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.findViewTreeOnBackPressedDispatcherOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.test2_shoppinglist.R
import com.example.test2_shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        //подписываемся на модель данных
        viewModel.shopList.observe(this){
            Log.d("MyLog","${it.toString()}")
            adapter.shopList=it
        }
    }

    fun setupRecyclerView(){ //настраиваем  RecyclerView
        val rvShopList= findViewById<RecyclerView>(R.id.rv_shop_list)//создаем RecyclerView
        adapter= ShopListAdapter()//создаем адаптер
        rvShopList.adapter=adapter //устанавливаем созданный адаптер у RecyclerView
        //настраиваем максимальный пул для каждого типа View (у нас их два item_shop_enabled и item_shop_disabled )
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED,ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TUPE_DISABLED,ShopListAdapter.MAX_POOL_SIZE)


    }


}