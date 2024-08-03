package com.example.recipeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun applyScreen(navigationToDetailScreen:()-> Unit){
    Column(modifier = Modifier

        .padding(16.dp) )
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp).wrapContentSize(), horizontalArrangement = Arrangement.Center)
        {

            Text("Central Government",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.padding(2.dp))

            Icon(painter = painterResource(id = R.drawable.baseline_notifications_24 ) , contentDescription ="notify",
                Modifier.size(38.dp) )
            Text(text = " ")//for spacing
            Icon(imageVector = Icons.Default.List, contentDescription = "menu", Modifier.size(40.dp))

        }


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text (text = "Mera Kisan bhai",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.padding(8.dp))




            Text(text="LazyVerticalGrid lets you specify a width for items, and then the grid will fit as many columns as possible. Any remaining width is distributed equally among the columns, after the number of columns is calculated. This adaptive way of sizing is especially useful for displaying sets of items across different screen sizes.\n" +
                    "\n" +
                    "If you know the exact amount of columns to be used, you can instead provide an instance of GridCells.Fixed containing the number of required columns.\n" +
                    "\n" +
                    "If your design requires only certain items to have non-standard dimensions, you can use the grid support for providing custom column spans for items. Specify the column span with the span parameter of the LazyGridScope DSL item and items methods. maxLineSpan, one of the span scope’s values, is particularly useful when you're using adaptive sizing, because the number of columns is not fixed. This example shows how to provide a full row span:", textAlign = TextAlign.Justify,
                modifier= Modifier.verticalScroll(rememberScrollState()),style = MaterialTheme.typography.bodyMedium,

                fontWeight = FontWeight.Light
            )



        }




    }



}



@Preview(showBackground = true)
@Composable
fun ksk(){
    applyScreen({})

}