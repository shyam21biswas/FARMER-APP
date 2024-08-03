package com.example.recipeapp

import androidx.annotation.ReturnThis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
var change : Boolean = true
var cen ="https://firebasestorage.googleapis.com/v0/b/veddatabase-7658d.appspot.com/o/"
var stat= "https://firebasestorage.googleapis.com/v0/b/veddatabase-7658d.appspot.com/o/"
const val cenend = "central.json?alt=media&token=f021ecf4-fba5-4002-94cf-62fb719ad1d7"
const  val statend  = "state.json?alt=media&token=f9f0e8ca-9f8e-465e-9f44-80d724f91cac"


//"https://firebasestorage.googleapis.com/v0/b/veddatabase-7658d.appspot.com/o/state.json?alt=media&token=f9f0e8ca-9f8e-465e-9f44-80d724f91cac"
//private

    

    val retrofit = Retrofit.Builder().baseUrl(cen)
        .addConverterFactory(GsonConverterFactory.create()).build()
   var recipeService = retrofit.create(ApiService::class.java)






interface ApiService{
    @GET(cenend)
    suspend fun  getCategories():CategoriesResponse


}



//https://www.themealdb.com/api/json/v1/1/categories.php

//https://www.jsonkeeper.com/b/T0EZ

////https://www.jsonkeeper.com/b/TMY2
//https://www.jsonkeeper.com/b/QZYA