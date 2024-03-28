package com.example.noteapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapplication.database.dao.TasksDao
import com.example.noteapplication.model.Task

@Database(entities = [Task::class], version = 1 , exportSchema = true)
abstract class TasksDatabase: RoomDatabase() {
    abstract fun tasksDao(): TasksDao

    //use singleton to create an object from my DB
    companion object{
        private var instance:TasksDatabase?= null

        fun getInstance(context: Context):TasksDatabase{
            if (instance==null){
                //initialize
                instance =Room.databaseBuilder(context,
                    TasksDatabase::class.java,
                    "tasksDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}