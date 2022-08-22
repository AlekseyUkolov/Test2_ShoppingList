package com.example.test2_shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.test2_shoppinglist.R
import com.example.test2_shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        //подписываемся на модель данных
        var count=0
        //
        viewModel.shopList.observe(this){
            Log.d("MyLog","${it.toString()}")
            if(count==0){
                count++
                val item=it[0]
               // viewModel.deleteShopItem(item)
                viewModel.changeEnabledState(item)
            }



        }
    }
}