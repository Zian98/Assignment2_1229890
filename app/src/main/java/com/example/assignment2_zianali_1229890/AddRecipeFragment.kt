package com.example.assignment2_zianali_1229890

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class AddRecipeFragment : DialogFragment() {

    private lateinit var listener: OnRecipeAddedListener

    interface OnRecipeAddedListener {
        fun onRecipeAdded(recipe: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnRecipeAddedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        val nameEditText: EditText = view.findViewById(R.id.recipe_name)
        val detailsEditText: EditText = view.findViewById(R.id.recipe_details)
        val cuisineSpinner: Spinner = view.findViewById(R.id.cuisine_spinner)
        val addButton: Button = view.findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val recipeName = nameEditText.text.toString()
            val recipeDetails = detailsEditText.text.toString()
            val cuisine = cuisineSpinner.selectedItem.toString()
            val fullRecipe = "$recipeName - $cuisine\n$recipeDetails"
            listener.onRecipeAdded(fullRecipe)
            dismiss()
        }

        return view
    }
}
