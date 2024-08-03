package com.example.recipeapp

sealed class Screen (var route:String){
    object WelcomeScreen : Screen("welcomescreen")
    object NumberScreen: Screen("numberscreen")
    object verifyScreen: Screen("verifyscreen")
    object HomeScreen: Screen("home")
    object Market: Screen("market")
    object Loan: Screen("loan")


    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}