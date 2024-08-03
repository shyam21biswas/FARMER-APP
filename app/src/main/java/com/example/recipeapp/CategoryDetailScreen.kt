package com.example.recipeapp

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(category: Category){

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Text(text=category.strCategory)
        Image(
            painter= rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = category.strCategory,
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        val context = LocalContext.current

        val openUrl = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }


        Button(onClick =  {val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            openUrl.launch(intent)}, colors = ButtonDefaults.run { buttonColors(Color(0XFF84D08E))})
        {
            Text(text = "APPLY", )//textAlign = TextAlign.Center)


        }



        Text(text=category.strCategoryDescription, textAlign = TextAlign.Justify,
            modifier=Modifier.verticalScroll(rememberScrollState())
        )

        }



    }



