package com.example.lofo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lofo.data.LostItem

@Dao
interface  LostDao {
    @Query("SELECT * FROM LostItem")
    fun getAllostItems(): LiveData<List<LostItem>>

    @Insert
    fun addLostItem(lostItem: LostItem)

    @Query("DELETE FROM LostItem WHERE id = :id")
    fun deleteLostItem(id: Int)

}