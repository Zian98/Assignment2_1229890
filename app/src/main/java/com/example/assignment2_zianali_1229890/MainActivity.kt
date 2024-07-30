package com.example.assignment2_zianali_1229890

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), AddRecipeFragment.OnRecipeAddedListener {

    private val recipes = mutableListOf(
        "Spaghetti Carbonara - Italian\nIngredients: Spaghetti, eggs, pancetta, Parmesan cheese, black pepper\nInstructions: Boil spaghetti. Fry pancetta. Mix eggs and cheese. Combine all with spaghetti.",
        "Chicken Tikka Masala - Indian\nIngredients: Chicken, yogurt, onion, tomato, cream, spices\nInstructions: Marinate chicken. Cook onion and spices. Add tomato and cream. Combine with chicken.",
        "Tacos - Mexican\nIngredients: Tortillas, beef, lettuce, cheese, tomato, sour cream\nInstructions: Cook beef. Warm tortillas. Assemble with toppings.",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
//                R.id.nav_recipe_list -> {
//                    loadFragment(RecipeListFragment.newInstance(recipes))
//                    true
//                }
                R.id.nav_add_recipe -> {
                    AddRecipeFragment().show(supportFragmentManager, "AddRecipeFragment")
                    true
                }
                else -> false
            }
        }
        // Load default fragment
        loadFragment(RecipeListFragment.newInstance(recipes))
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun onRecipeAdded(recipe: String) {
        recipes.add(recipe)
        loadFragment(RecipeListFragment.newInstance(recipes))
    }
}
