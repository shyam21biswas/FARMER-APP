package com.example.recipeapp


import androidx.annotation.ReturnThis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET






//"https://firebasestorage.googleapis.com/v0/b/veddatabase-7658d.appspot.com/o/state.json?alt=media&token=f9f0e8ca-9f8e-465e-9f44-80d724f91cac"
//private



val retrofit2 = Retrofit.Builder().baseUrl("https://firebasestorage.googleapis.com/v0/b/veddatabase-7658d.appspot.com/o/")
    .addConverterFactory(GsonConverterFactory.create()).build()
var recipeService2 = retrofit2.create(ApiService2::class.java)






interface ApiService2{
    @GET( "state.json?alt=media&token=f9f0e8ca-9f8e-465e-9f44-80d724f91cac")
    suspend fun  getCategorie2():CategoriesResponse2


}



//https://www.themealdb.com/api/json/v1/1/categories.php

//https://www.jsonkeeper.com/b/T0EZ

////https://www.jsonkeeper.com/b/TMY2
//https://www.jsonkeeper.com/b/QZYA