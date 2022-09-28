package com.example.todolist

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDo")

data class Entity (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var description:String

)






