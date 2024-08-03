package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun WelcomeScreen(navigationToNumberScreen:()-> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 60.dp).wrapContentSize(), Arrangement.Center, Alignment.CenterHorizontally)
    {
        Column( modifier = Modifier

            .padding(top = 90.dp), Arrangement.Center, Alignment.CenterHorizontally){



            Image(
                painter = painterResource(id = R.drawable.baseline_agriculture_24),
                contentDescription = null,
                modifier = Modifier
                    .size(180
                        .dp)

            )

            Text("Kisan bhai",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                fontWeight = FontWeight.Medium)
            Text("kisan hai toh desh hai",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {navigationToNumberScreen()},modifier= Modifier
            .size(320.dp, 60.dp)
            .padding(2.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.run { buttonColors(Color(0XFF295A28)) }
        ){
            Text("Welcome",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Light)
        }

    }



}

