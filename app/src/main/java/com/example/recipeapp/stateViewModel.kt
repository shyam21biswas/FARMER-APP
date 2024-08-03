package com.example.recipeapp


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StateViewModel: ViewModel() {
    private val _categorieState2 = mutableStateOf(RecipeState())
    val categoriesState2: State<RecipeState> = _categorieState2

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService2.getCategorie2()
                _categorieState2.value = _categorieState2.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null

                )
            } catch (e: Exception) {
                _categorieState2.value = _categorieState2.value.copy(
                    loading = false,
                    error = "error${e.message}"
                )
            }
        }
    }


    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

}
