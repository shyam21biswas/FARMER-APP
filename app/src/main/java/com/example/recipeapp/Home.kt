package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun HomeScreen( navigationToListScreen:()-> Unit,navigationToMarketScreen:()-> Unit,navigationToLoanScreen:()-> Unit
) {



        Scaffold(
            content = {
                MainView(
                    navigationToListScreen,
                    navigationToMarketScreen,
                    navigationToLoanScreen,
                    it
                )

            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    modifier = Modifier.padding(24.dp),
                    shape = RoundedCornerShape(32.dp),
                    containerColor = Color.White.copy(alpha = (1f))
                ) {
                    Row(
                        modifier = Modifier.wrapContentSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            modifier = Modifier.clickable { /*navigationToWelcomeScreen() */ })
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Add",
                            modifier = Modifier.clickable { })
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Add",
                            modifier = Modifier.clickable { })
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    }

                }
            },
            floatingActionButtonPosition = FabPosition.Center


        )
    }




@Composable
fun MainView(navigationToListScreen:()-> Unit,navigationToMarketScreen:()-> Unit,navigationToLoanScreen:()->Unit, Pd : PaddingValues){
    Box(  ) {
        Image(
            painterResource(id = R.drawable.img_1 ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize())
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(Pd))
    {


        Spacer(modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(text = "Hi,Sam")

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){ Text("description .......") }
        Spacer(modifier = Modifier.padding(40.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), Arrangement.Center, Alignment.CenterVertically)
        {
            //remove one row having space evenly ................

            Column (Modifier.padding(top = 30.dp)){


                Row (horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.wrapContentSize()){
                    Button(onClick = {navigationToListScreen()
                                     change = true }
                        ,modifier= Modifier
                            .size(165.dp)
                            .padding(8.dp),
                        shape= RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.run { buttonColors(
                            Color(0XFFE63A3A)
                        )
                        },elevation = ButtonDefaults.buttonElevation(defaultElevation = 52.dp, pressedElevation = 24.dp))
                    {
                        Text(text = "central")
                    }
                    Button(onClick = {
                        navigationToListScreen()
                        change= false


                    },modifier= Modifier
                        .size(165.dp)
                        .padding(8.dp),shape= RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.run { buttonColors(
                            Color(0XFFFFC300)
                        )
                        },elevation = ButtonDefaults.buttonElevation(defaultElevation = 52.dp, pressedElevation = 24.dp))
                    { Text(text = "State")

                    }
                }

                Row {
                    Button(onClick = {navigationToMarketScreen()},modifier= Modifier
                        .size(165.dp)
                        .padding(8.dp),shape= RoundedCornerShape(40.dp),
                        colors = ButtonDefaults.run { buttonColors(Color(0XFF84D08E)) },
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 52.dp, pressedElevation = 24.dp))
                    {
                        Text("Market")

                    }

                    Button(onClick = {navigationToLoanScreen()},modifier= Modifier
                        .size(165.dp)
                        .padding(8.dp),shape= RoundedCornerShape(40.dp),colors = ButtonDefaults.run { buttonColors(
                        Color(0XFF48C9B0)
                    )
                    },elevation = ButtonDefaults.buttonElevation(defaultElevation = 52.dp, pressedElevation = 24.dp))
                    {
                        Text(text = "LOAN")

                    }
                }
            }



        }


    }
}}


@Preview(showBackground = true)
@Composable
fun sdsdas(){
    HomeScreen(navigationToListScreen = { /*TODO*/ }, navigationToMarketScreen = { /*TODO*/ }) {}


}