package com.example.lofo.viewmodel
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.lofo.data.LostItem
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LostItemViewModel : ViewModel() {
    val lostDao=MainApplication.database.getLostDao()
    val imageList : LiveData<List<LostItem>> = lostDao.getAllostItems()

    fun addItem(item: LostItem){
        viewModelScope.launch (Dispatchers.IO){
            lostDao.addLostItem(item)
        }
    }
    fun deleteLostItem(id: Int){
        viewModelScope.launch (Dispatchers.IO){
            lostDao.deleteLostItem(id)
        }
    }
}
