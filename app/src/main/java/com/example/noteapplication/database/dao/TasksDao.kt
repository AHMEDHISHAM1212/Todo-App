package com.example.noteapplication.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapplication.model.Task


@Dao
interface TasksDao {

    @Insert
    fun insertTask(task: Task)
    @Update
    fun updateTask(task: Task)
    @Delete
    fun deleteTask(task: Task)

    @Query("Select * from Task")
    fun getAllTasks():List<Task>

    @Query("Select * from Task where date= :dateTime ")
    fun getTaskByDate(dateTime: Long): List<Task>
}