package com.example.lofo.pages

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.lofo.R
import com.example.lofo.data.FoundItem
import com.example.lofo.ui.theme.darkgrey
import com.example.lofo.ui.theme.white
import com.example.lofo.viewmodel.FoundItemViewModel



@Composable
fun FoundItemDisplayScreen(modifier: Modifier,viewModel: FoundItemViewModel) {
   val foundItems by viewModel.imageList.observeAsState(emptyList())
  LazyVerticalGrid(columns = GridCells.Fixed(2),
      modifier = modifier
          .padding(horizontal = 8.dp, vertical = 15.dp)
          .fillMaxSize())  {

        items(foundItems){
            item->
            FoundItemCard(item)
        }
    }
}

@Composable
fun FoundItemCard(item: FoundItem) {
    Card(
        elevation = CardDefaults
            .cardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = darkgrey),
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Column(
            modifier = Modifier
                .background(darkgrey)
                .padding(1.dp)
                .fillMaxWidth()
        ) {
            // Use Coil to load the image
            Image(
                painter = rememberAsyncImagePainter(model = item.imageUrl),
                contentDescription = item.title,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                color = white
            )
        }
    }
}

