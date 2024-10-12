package com.example.lofo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lofo.data.FoundItem

@Dao
interface  FoundDao {
    @Query("SELECT * FROM FoundItem")
    fun getAllFoundItems(): LiveData<List<FoundItem>>

    @Insert
    fun addFoundItem(foundItem: FoundItem)

    @Query("DELETE FROM FoundItem WHERE id = :id")
    fun deleteFoundItem(id: Int)

}