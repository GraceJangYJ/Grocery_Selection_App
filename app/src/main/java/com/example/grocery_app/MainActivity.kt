package com.example.grocery_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1- AdapterView: RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)

        // 2 - Data Source: List of ItemModel Objects
        var groceryItems: ArrayList<ItemModel> = ArrayList()

        val v1 = ItemModel("Fruits", "Fresh Fruits from the Garden", R.drawable.fruit)
        val v2 = ItemModel("Breads", "Baked Breads from the bakery", R.drawable.bread)
        val v3 = ItemModel("Carrot", "Fresh Carrot from the farm", R.drawable.carrot)
        val v4 = ItemModel("Kiwi","Fresh Kiwi from New Zeland", R.drawable.kiwi)
        val v5 = ItemModel("Milk", "Fresh Milk from the cow", R.drawable.milk)
        val v6 = ItemModel("Peach", "Yummy Peach from the best tree", R.drawable.peach)

        groceryItems.add(v1)
        groceryItems.add(v2)
        groceryItems.add(v3)
        groceryItems.add(v4)
        groceryItems.add(v5)
        groceryItems.add(v6)

        // 3 - Adapter
        val adapter = MyAdapter(groceryItems)
        recyclerView.adapter = adapter

    }
}