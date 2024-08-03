package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel:MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState
    val recipeViewModel2:StateViewModel= viewModel()
    val viewstate2 by recipeViewModel2.categoriesState2

    NavHost(navController = navController ,
        startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route)
        {
            WelcomeScreen {
                navController.navigate(Screen.NumberScreen.route)
            }
        }
        composable(route = Screen.NumberScreen.route)
        {
            NumberScreen {
                navController.navigate(Screen.verifyScreen.route)
            }
        }

        composable(route = Screen.verifyScreen.route)
        {
            verifyScreen {
                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navigationToListScreen = { navController.navigate(Screen.RecipeScreen.route) },
                navigationToMarketScreen = { navController.navigate(Screen.Market.route) },
                navigationToLoanScreen = { navController.navigate(Screen.Loan.route) })
            /*{
                navController.navigate(Screen.RecipeScreen.route)

            }*/
            //{navController.navigate(Screen.Market.route)}

        }


        composable(route = Screen.RecipeScreen.route)
        {
            RecipeScreen(viewstate = viewstate, viewstate2 = viewstate2, navigateToDetails = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route)
        /*{val category=navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?:
        Category("","","","")
            CategoryDetailScreen(category = category)

        }*/{
            applyScreen {
                navController.navigate(Screen.DetailScreen.route)


            }
        }
        composable(route = Screen.Market.route) {
            market {
                navController.navigate(Screen.Market.route)
            }
        }
        composable(route = Screen.Loan.route) {
            LoanScreen {
                navController.navigate(Screen.Loan.route)
            }


        }

    }}


