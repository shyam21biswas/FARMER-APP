package com.example.recipeapp


import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp

@Composable

fun buyScreen(navigationToMarketScreen:()-> Unit){


    Column(modifier = Modifier

        .padding(16.dp)
        .wrapContentSize())
    {


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.Start
        )
        {
            Row(
                modifier = Modifier

                    .padding(2.dp)
                    .wrapContentSize()
            )
            {

                Text(
                    text = "Your Market            ",
                    style = MaterialTheme.typography.headlineLarge,

                    fontWeight = FontWeight.Light
                )
                Text(text = " ")

                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = "notify",
                    Modifier.size(38.dp)
                )
                Text(text = " ")//for spacing
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "menu",    
                    Modifier.size(40.dp)
                )

            }
            Text (text = "ORGANIC",
                style = MaterialTheme.typography.titleLarge,

                fontWeight = FontWeight.Light)

            Spacer(modifier = Modifier.padding(8.dp))
            Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentSize()){
                Button(onClick = {      }
                    ,modifier= Modifier
                        .size(180.dp)
                        .padding(8.dp),
                    shape= RoundedCornerShape(40.dp),
                    colors = ButtonDefaults.run { buttonColors(
                        Color(0XFFFFFFFF
                    ))
                    },elevation = ButtonDefaults.buttonElevation(defaultElevation = 52.dp, pressedElevation = 24.dp))
                {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_agriculture_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(180
                                .dp)

                    )
                }
Spacer(modifier = Modifier.padding(8.dp))

                Column(modifier = Modifier.padding(8.dp)){Text(text = "Item_Name" ,
                    style = MaterialTheme.typography.titleLarge,

                    fontWeight = FontWeight.Light)
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                    
                    Text(text = "Rs 107/-",style = MaterialTheme.typography.headlineMedium,

                        fontWeight = FontWeight.Light)}








    }



}
    }
}

@Preview(showBackground = true)
@Composable
fun sds(){
    buyScreen {
        {}
    }
}