package com.example.lofo.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LostItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    val title: String,
    val imageUrl: Uri
)
