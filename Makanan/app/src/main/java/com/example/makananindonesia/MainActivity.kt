package com.example.makananindonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
   
    private var list: ArrayList<Foods> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods.setHasFixedSize(true)

        list.addAll(FoodsData.listData)
        showRecycler()
    }

    private fun showRecycler() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val foodAdapter = FoodAdapter(list)
        rvFoods.adapter = foodAdapter
    }
}