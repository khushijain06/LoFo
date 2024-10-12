package com.example.lofo.pages

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.lofo.R
import com.example.lofo.data.FoundItem
import com.example.lofo.data.LostItem
import com.example.lofo.ui.theme.black
import com.example.lofo.ui.theme.blue
import com.example.lofo.ui.theme.darkgrey
import com.example.lofo.ui.theme.red
import com.example.lofo.ui.theme.white
import com.example.lofo.viewmodel.FoundItemViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoundItemInputScreen(viewModel: FoundItemViewModel,navHostController: NavHostController) {
    //  val navController = rememberNavController()
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var title by remember { mutableStateOf("") }
    //launcher to pick image from gallery
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        imageUri = uri
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = darkgrey, titleContentColor = white,
            ),
            title = {
                Text(text = "Add Found Items")
            },
            navigationIcon = {
                IconButton(onClick = { navHostController.navigate("Home") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_arrow_back_24),
                        contentDescription = "back"
                    )
                }
            }
        )
        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                imageUri?.let { uri ->
                    Image(
                        painter = rememberAsyncImagePainter(model = uri),
                        contentDescription = "Selected Image",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                    )
                }
                Spacer(modifier = Modifier.height(22.dp))
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text(text = "Title of Item Found", color = blue) },
                    shape = RoundedCornerShape(25.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = blue,
                        unfocusedBorderColor = Color(0xFF2E2E2E),
                        focusedTextColor = Color(0xffffffff),
                        unfocusedTextColor = Color(0xffffffff)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    onClick = { galleryLauncher.launch("image/*") },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = blue,
                        disabledContentColor = Color.Transparent,
                    ),
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = "Add Image",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                //Button to pick image from gallery
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier.padding(16.dp))
                ElevatedButton(
                    onClick = {
                        viewModel.addItem(FoundItem(title= title,imageUrl = imageUri!!))
                        Toast.makeText(context, "Item Added", Toast.LENGTH_SHORT).show()
                        title = ""
                        imageUri = null
                    }, enabled = imageUri != null && title.isNotEmpty(),
                    elevation = ButtonDefaults.elevatedButtonElevation(6.dp),
                    colors = ButtonDefaults.elevatedButtonColors(blue),
                    modifier = Modifier.padding(4.dp).fillMaxWidth()
                )
                {
                    Text(text = "Submit", fontSize = 17.sp, color = Color.White)
                }
            }
        }
    }
}
