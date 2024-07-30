package com.example.assignment2_zianali_1229890

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableLiveData<MutableList<Pair<String, String>>>(mutableListOf())
    val recipes: LiveData<MutableList<Pair<String, String>>> get() = _recipes

    fun addRecipe(name: String, details: String) {
        _recipes.value?.add(name to details)
        _recipes.value = _recipes.value
    }
}
