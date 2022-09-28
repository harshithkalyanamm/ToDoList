package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"ToDo"
        ).build()
        add.setOnClickListener {
            val intent = Intent(this,CreateCard::class.java)
            startActivity(intent)
        }


        recycler_view.adapter=Adapter(DataObject.getAllData())
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}