package com.example.lofo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lofo.MainApplication
import com.example.lofo.data.FoundItem
import com.example.lofo.data.LostItem
import com.example.lofo.db.FoundDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class FoundItemViewModel : ViewModel() {
    val foundDao = MainApplication.database.getFoundDao()
    val imageList: LiveData<List<FoundItem>> = foundDao.getAllFoundItems()


    fun addItem(item: FoundItem) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("FoundItemViewModel", "Adding item:${item.title} + ${item.imageUrl}")
            foundDao.addFoundItem(item)
        }
    }

    fun deleteFoundItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            foundDao.deleteFoundItem(id)
        }
    }
}

