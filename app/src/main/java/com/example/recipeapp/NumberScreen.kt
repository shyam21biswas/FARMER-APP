package com.example.recipeapp

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NumberScreen(navigationToVerifyScreen:()-> Unit){
    var phoneNumber by remember { mutableStateOf("") }
    val orientation = LocalConfiguration.current.orientation


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 120.dp).wrapContentSize(), Arrangement.Center, Alignment.CenterHorizontally
        )
    {
        Column( modifier = Modifier

            .padding(top = 180.dp), Arrangement.Center, Alignment.CenterHorizontally){

            Text("Your Phone",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium)
            Text("number",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium)
            Text("Please enter your",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontWeight = FontWeight.Light)
            Text("number",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                label = { Text("Phone Number") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                ),
                //visualTransformation = phoneVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .size(320.dp, 100.dp)
                    .padding(16.dp)
            )



        }
        Spacer(modifier = Modifier.weight(1f))
        Row (horizontalArrangement = Arrangement.Absolute.Left, modifier = Modifier.padding(bottom = 50.dp)){
            Text(text = "                       ")



            Button(onClick = {navigationToVerifyScreen()},
                modifier = Modifier.size(70.dp),

                shape = CircleShape,
                colors = ButtonDefaults.run { buttonColors(Color(0XFF295A28)) }
            ){
                Icon(
                    Icons.Default.ArrowForward,contentDescription = null

                )
            }

        }
    }


}


@Preview
@Composable
fun sfsjs(){
    NumberScreen({})


}
