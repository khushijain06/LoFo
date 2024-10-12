package com.example.lofo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lofo.data.FoundItem
import com.example.lofo.data.LostItem
import com.example.lofo.viewmodel.UriConverter

@TypeConverters(UriConverter::class)
@Database(entities = [FoundItem::class, LostItem::class], version = 1)
abstract class Database : RoomDatabase() {

    companion object {
        const val NAME = "lofo_db"
    }
    abstract fun getLostDao() :LostDao
    abstract fun getFoundDao() :FoundDao

}