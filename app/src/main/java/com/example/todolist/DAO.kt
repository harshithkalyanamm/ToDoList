package com.example.todolist

import androidx.room.*


@Dao

interface DAO {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun  deleteTask(entity: Entity)

    @Query("Delete from todo")
    suspend fun deleteAll()

    @Query("Select * from todo")
    suspend fun getTasks():List<Cardinfo>

}