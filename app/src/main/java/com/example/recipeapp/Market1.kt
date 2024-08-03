package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun market(navigationToMarketScreen:()-> Unit){
    var sel = remember{ mutableStateOf("organic")}
    var sel_col_org = remember { mutableStateOf(0XFFFFa500) }
    var sel_col_acc = remember { mutableStateOf(0xff000000) }
    var col_org = 0XFFFFC300
    var col_acc = 0XFFFFC300
    var col = 0XFFFFFFFF
    Column(modifier = Modifier

        .padding(16.dp)
        .wrapContentSize())
    {


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
        )
        {Row(modifier = Modifier

            .padding(2.dp)
            .wrapContentSize())
        {

            Text(text = "                           ")

            Icon(painter = painterResource(id = R.drawable.baseline_notifications_24 ) , contentDescription ="notify",
                Modifier.size(38.dp) )
            Text(text = " ")//for spacing
            Icon(imageVector = Icons.Default.List, contentDescription = "menu", Modifier.size(40.dp))

        }
            Text (text = "Market",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                fontWeight = FontWeight.Light)
            Text (text = "small beautiful qote",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.padding(8.dp))


        Row (horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "❁ Organic ",Modifier
                .clickable { sel.value = "organic" },style = MaterialTheme.typography.bodyLarge, color = Color(sel_col_org.value))
            Spacer(modifier = Modifier.padding(horizontal = 30.dp))
            Text(text = "❁ Accesories",Modifier.clickable { sel.value = "Accesories" },style = MaterialTheme.typography.bodyLarge,color = Color(sel_col_acc.value))
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
        }

            Row {
                if (sel.value == "organic")

                {sel_col_org.value = 0XFFFFa500
                    sel_col_acc.value = 0xff000000
                    organic()}
                else {
                    sel_col_acc.value = 0XFFFFa500
                    sel_col_org.value = 0xff000000
                    accesories()
                }
            }



        }




    }



}








@Composable
fun organic(){
    LazyVerticalGrid(GridCells.Fixed(2),modifier=Modifier.fillMaxSize()){
        items(10){
                category ->
            organicItem()///

        }
    }
}



@Composable
// dataclass category
fun organicItem(){
    Column (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {},//navigateToDetail(category)

        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            //painter = rememberAsyncImagePainter(category.strCategoryThumb),
            painterResource(id = R.drawable.baseline_heart_broken_241),
            contentDescription =null,
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1f) )
        Text(
            text= /*category.strCategory*/"Vedanshi",
            color= Color.Black,
            style= TextStyle(fontWeight = FontWeight.Bold ),
            modifier=Modifier.padding(top=4.dp)

        )

    }
}


@Composable
fun accesories(){
    LazyVerticalGrid(GridCells.Fixed(2),modifier=Modifier.fillMaxSize()){
        items(10){
                itd ->
            accesoriesItem()///

        }
    }
}



@Composable
// dataclass category
fun accesoriesItem(){
    Column (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {},//navigateToDetail(category)

        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            //painter = rememberAsyncImagePainter(category.strCategoryThumb),
            painterResource(id = R.drawable.baseline_favorite_24),
            contentDescription =null,
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1f) )
        Text(
            text= /*category.strCategory*/"Vedanshi",
            color= Color.Black,
            style= TextStyle(fontWeight = FontWeight.Bold ),
            modifier=Modifier.padding(top=4.dp)

        )

    }
}


@Preview
@Composable
fun fkfk(){
    market {
        {}
    }
}

