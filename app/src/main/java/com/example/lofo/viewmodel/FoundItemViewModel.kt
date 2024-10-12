package com.example.lofo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lofo.data.FoundItem
import com.example.lofo.data.LostItem
import com.example.lofo.db.FoundDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoundItemViewModel(private val FoundDao: FoundDao) : ViewModel() {
    val foundDao=MainApplication.database.getFoundDao()
    val imageList : LiveData<List<FoundItem>> = foundDao.getAllFoundItems()

    fun addItem(item: FoundItem) {
        viewModelScope.launch(Dispatchers.IO) {
            FoundDao.addFoundItem(item)
        }
    }
    fun deleteFoundItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            FoundDao.deleteFoundItem(id)
        }
    }
}
