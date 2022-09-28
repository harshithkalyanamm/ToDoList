package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"ToDo"
        ).build()
        val pos=intent.getIntExtra("id",-1)
        if(pos!=1)
        {
           val title=DataObject.getData(pos).title
           val description=DataObject.getData(pos).description
           create_title.setText(title)
           create_description.setText(description)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch{
                    database.dao().deleteTask(
                        Entity(pos+1,title, description)
                    )
                }
                myIntent()
            }
            update_button.setOnClickListener{
                DataObject.updateData(pos,
                    create_title.text.toString(),
                    create_description.text.toString())
                GlobalScope.launch{
                    database.dao().updateTask(
                        Entity(pos+1,title, description)
                    )
                }
                Toast.makeText(this,title+" "+description,Toast.LENGTH_LONG).show()
                myIntent()

            }
        }
    }
    fun myIntent(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}