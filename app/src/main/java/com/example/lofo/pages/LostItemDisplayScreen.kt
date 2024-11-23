package com.example.lofo.pages

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.example.lofo.R
import com.example.lofo.data.FoundItem
import com.example.lofo.data.LostItem
import com.example.lofo.ui.theme.darkgrey
import com.example.lofo.ui.theme.white
import com.example.lofo.viewmodel.LostItemViewModel



@Composable
fun LostItemDisplayScreen(modifier: Modifier,viewModel: LostItemViewModel) {
        val lostItems by viewModel.imageList.observeAsState(emptyList())
      LazyVerticalGrid(
          columns = GridCells.Fixed(2),
          modifier = modifier
              .padding(horizontal = 8.dp, vertical = 9.dp)
              .fillMaxSize()
      ){
            items(lostItems) { item ->
                LostItemCard(item)
            }
        }
    }

@Composable
fun LostItemCard(item: LostItem) {
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
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            // Use Coil to load the image
            Image(
                painter = rememberAsyncImagePainter(
                    model = item.imageUrl,
                ),
                contentDescription = item.title,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxSize()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                color = white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}






