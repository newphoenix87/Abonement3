package com.example.abonement3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Item::class], version = 1)

abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDB(context:Context): MainDb{
            return Room.databaseBuilder(
                context.applicationContext,MainDb::class.java,"test.db").build()

        }
    }
}