package com.example.assignment2_zianali_1229890

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter

private const val ARG_RECIPES = "recipes"

class RecipeListFragment : Fragment() {

    private var recipes: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            recipes = it.getStringArrayList(ARG_RECIPES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        val listView: ListView = view.findViewById(R.id.recipe_list_view)

        val recipeData = recipes!!.map { recipe ->
            val parts = recipe.split(" - ")
            val name = parts[0]
            val cuisine = parts[1].split("\n")[0]
            mapOf("name" to name, "cuisine" to cuisine)
        }

        val adapter = SimpleAdapter(
            requireContext(),
            recipeData,
            R.layout.item_recipe,
            arrayOf("name", "cuisine"),
            intArrayOf(R.id.recipe_name, R.id.cuisine_type)
        )

        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedRecipe = recipes!![position]
            val intent = Intent(activity, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE_NAME", selectedRecipe)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(recipes: List<String>) =
            RecipeListFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_RECIPES, ArrayList(recipes))
                }
            }
    }
}
