package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random


val colorlist = arrayOf(
    0XFFff9b9b,
   // 0XFFfbc3b0,
   // 0XFFecc9c9,
    //0XFFe5a3a3,
    0XFFaaaaaa)
@Composable
fun RecipeScreen(modifier: Modifier =Modifier,
                 viewstate:MainViewModel.RecipeState,
                 viewstate2:StateViewModel.RecipeState,
                 navigateToDetails: (Category) -> Unit
    ){
    Box(modifier = Modifier.fillMaxSize()){
        if (change){
            when{
            viewstate.loading->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewstate.error != null->{
                Text("error occured")
            }else->{
                //display
                CategoryScreen(categories = viewstate.list,navigateToDetails) }
        }

        }
        else{

            when{
                viewstate2.loading->{
                    CircularProgressIndicator(modifier.align(Alignment.Center))
                }
                viewstate2.error != null->{
                    Text("error occured")
                }else->{
                //display
                CategoryScreen(categories = viewstate2.list,navigateToDetails) }
            }




        }

    ///
    }
}

@Composable
fun CategoryScreen(categories:List<Category>,navigateToDetails: (Category) -> Unit){


    // there is an error  for sccafold padding.................................

    Scaffold(
        content = {
            ///
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp))
            {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                    Arrangement.End,)
                {

                    Icon(painter = painterResource(id = R.drawable.baseline_notifications_24 ) , contentDescription ="notify",
                        Modifier.size(38.dp) )
                    Text(text = " ")//for spacing
                    Icon(imageVector = Icons.Default.List, contentDescription = "menu", Modifier.size(40.dp))

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp))
                { Text("Central Government",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium) }
                Spacer(modifier = Modifier.padding(8.dp))
                LazyVerticalGrid(GridCells.Fixed(1),modifier=Modifier.fillMaxSize().weight(0.1f)){
                    items(categories){
                            category ->
                        CategoryItem(category =  category, navigateToDetails)///

                    }
                }




            }

            //

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(24.dp)/*background(brush = Brush.horizontalGradient(colorStops = colorStops))*/, shape = RoundedCornerShape(32.dp), contentColor = Color.Black,containerColor = Color.Red.copy(alpha=0.2f),
            ) { Row(modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically){
                Spacer(modifier = Modifier.padding( horizontal = 8.dp))
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add",modifier= Modifier
                    .clickable {})
                Spacer(modifier = Modifier.padding( horizontal = 10.dp))

                Icon(imageVector = Icons.Default.DateRange, contentDescription = "Add",modifier= Modifier.clickable {  })
                Spacer(modifier = Modifier.padding( horizontal = 10.dp))

                Icon(imageVector = Icons.Default.Home, contentDescription = "Add",modifier= Modifier.clickable {  })
                Spacer(modifier = Modifier.padding( horizontal = 8.dp))
            }

            }
        },
        floatingActionButtonPosition = FabPosition.Center


    )


}



@Composable
// dataclass category
fun CategoryItem(category:Category,
                 navigateToDetail:(Category)->Unit){
    var col by remember {
        mutableStateOf( R.drawable.baseline_favorite_24) }
    var count by remember { mutableStateOf(1) }

    Column (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navigateToDetail(category) },//navigateToDetail(category)

        horizontalAlignment = Alignment.CenterHorizontally)
    { val randomIndex = Random.nextInt(colorlist.size)
        val col_card = colorlist[randomIndex]


        ElevatedCard(modifier = Modifier
            .size(330.dp, 130.dp)
            .padding(6.dp)
            .wrapContentSize()
            .clickable { navigateToDetail(category) }
            ,
            colors = CardDefaults.cardColors(containerColor = Color(col_card).copy(alpha=0.5f)),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 52.dp, pressedElevation = 24.dp)

        ) {
            Row()
            {
                Row {


                    Spacer(modifier = Modifier.padding(8.dp))
                    Image(
                        //painterResource(id = R.drawable.baseline_agriculture_24),
                        painter = rememberAsyncImagePainter(category.strCategoryThumb),
                        contentDescription =null,
                        modifier= Modifier
                            .size(60.dp)
                            .clickable { })
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Row(modifier= Modifier.wrapContentSize())
                {


                    Column {
                        Text(text= category.strCategory,
                            color= Color.Black,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Light,
                            modifier= Modifier.padding(top=4.dp) )
                        Text(
                            text= /*category.strCategory*/"vedanshi",
                            color= Color.Black,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Medium,
                            modifier= Modifier
                                .padding(top = 4.dp)
                                .clickable { }
                            //.aspectRatio(5f)
                        )

                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row(modifier = Modifier.padding(top = 6.dp))
                {

                    Image(
                        painterResource(id = col), contentDescription = "Like",
                        Modifier
                            .size(30.dp)
                            .clickable
                            {

                                count = count + 1;
                                if (count % 2 == 0) {
                                    col = R.drawable.baseline_heart_broken_24
                                } else {
                                    col = R.drawable.baseline_favorite_24
                                }
                            } )
                }
                Spacer(modifier = Modifier.padding(8.dp))



            }
            Text(text = "Luv u vedanshi",modifier = Modifier.padding( 10.dp))



        }
    }

}




