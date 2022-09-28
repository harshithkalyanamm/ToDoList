package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"ToDo"
        ).build()
        save_button.setOnClickListener {
            if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_description.text.toString().trim { it <= ' ' }.isNotEmpty())
             {
                var title=create_title.getText().toString()
                var description=create_description.getText().toString()
                 DataObject.setData(title, description)
                 GlobalScope.launch(){
                     database.dao().insertTask(Entity(0,title,description))
                     Log.i("harshith",database.dao().getTasks().toString())

                 }

                 val intent=Intent(this, MainActivity::class.java)
                 startActivity(intent)


            }
        }
    }
}