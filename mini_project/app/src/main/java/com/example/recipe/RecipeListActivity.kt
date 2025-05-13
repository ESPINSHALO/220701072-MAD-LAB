package com.example.recipe

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.appcompat.widget.Toolbar

class RecipeListActivity : AppCompatActivity() {
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Get the category from the intent
        category = intent.getStringExtra("category") ?: "Breakfast"
        supportActionBar?.title = category

        // Set the appropriate background based on category
        val backgroundRes = when (category.lowercase()) {
            "breakfast" -> R.drawable.bg_breakfast
            "lunch" -> R.drawable.bg_lunch
            "dinner" -> R.drawable.bg_dinner
            "juice" -> R.drawable.bg_juice
            "snacks" -> R.drawable.bg_breakfast
            else -> R.drawable.bg_breakfast
        }
        findViewById<ConstraintLayout>(R.id.rootLayout).setBackgroundResource(backgroundRes)

        // Initialize RecyclerView
        recipeRecyclerView = findViewById(R.id.recipeRecyclerView)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)

        // Get recipes for the selected category
        val recipes = getRecipesForCategory(category)
        recipeRecyclerView.adapter = RecipeAdapter(recipes)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getRecipesForCategory(category: String): List<Recipe> {
        return when (category.lowercase()) {
            "breakfast" -> listOf(
                Recipe("Idly", "Soft and fluffy steamed rice cakes served with sambar and chutney", R.drawable.ic_breakfast),
                Recipe("Dosa", "Crispy crepes made from fermented rice and lentil batter", R.drawable.ic_breakfast),
                Recipe("Upma", "Savory semolina porridge with vegetables and spices", R.drawable.ic_breakfast),
                Recipe("Pongal", "Creamy rice and lentil dish with black pepper and cumin", R.drawable.ic_breakfast),
                Recipe("Poori", "Deep-fried puffed bread served with potato curry", R.drawable.ic_breakfast)
            )
            "lunch" -> listOf(
                Recipe("Chicken Biryani", "Fragrant rice dish with tender chicken and aromatic spices", R.drawable.ic_lunch),
                Recipe("Mutton Biriyani", "Rich and flavorful rice dish with tender mutton pieces", R.drawable.ic_lunch),
                Recipe("Vegetable Biriyani", "Colorful biryani loaded with fresh vegetables and spices", R.drawable.ic_lunch),
                Recipe("Butter Chicken", "Tender chicken in a rich, creamy tomato-based curry", R.drawable.ic_lunch),
                Recipe("Fish Curry", "Fresh fish cooked in a spicy coconut-based gravy", R.drawable.ic_lunch)
            )
            "dinner" -> listOf(
                Recipe("Chappathi", "Soft and fluffy flatbread made from whole wheat flour", R.drawable.ic_dinner),
                Recipe("Noodles", "Stir-fried noodles with vegetables and your choice of protein", R.drawable.ic_dinner),
                Recipe("Pasta", "Italian pasta with rich tomato sauce and herbs", R.drawable.ic_dinner),
                Recipe("Naan & Butter Paneer", "Soft bread served with creamy cottage cheese curry", R.drawable.ic_dinner),
                Recipe("Aapam", "Soft and fluffy rice pancakes with crispy edges", R.drawable.ic_dinner)
            )
            "juice" -> listOf(
                Recipe("Mango Shake", "Creamy and sweet mango milkshake", R.drawable.ic_juice),
                Recipe("Lemonade", "Refreshing lemon drink with mint and honey", R.drawable.ic_juice),
                Recipe("Watermelon Juice", "Fresh and hydrating watermelon drink", R.drawable.ic_juice),
                Recipe("Orange Juice", "Freshly squeezed orange juice with pulp", R.drawable.ic_juice),
                Recipe("Pineapple Juice", "Sweet and tangy pineapple drink", R.drawable.ic_juice)
            )
            "snacks" -> listOf(
                Recipe("Samosa", "Crispy pastry filled with spiced potatoes and peas", R.drawable.ic_breakfast),
                Recipe("Pakora", "Crispy fritters made with gram flour and vegetables", R.drawable.ic_breakfast),
                Recipe("Vada Pav", "Spicy potato fritter served in a soft bun", R.drawable.ic_breakfast),
                Recipe("Bhel Puri", "Tangy and spicy puffed rice chaat", R.drawable.ic_breakfast),
                Recipe("Kachori", "Deep-fried pastry filled with spiced moong dal", R.drawable.ic_breakfast)
            )
            else -> emptyList()
        }
    }
}

class RecipeAdapter(private val recipes: List<Recipe>) : 
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.recipeCard)
        val titleText: TextView = view.findViewById(R.id.recipeTitle)
        val descriptionText: TextView = view.findViewById(R.id.recipeDescription)
        val recipeImage: ImageView = view.findViewById(R.id.recipeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.titleText.text = recipe.title
        holder.descriptionText.text = recipe.description
        holder.recipeImage.setImageResource(recipe.imageResId)

        holder.cardView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, RecipeDetailActivity::class.java).apply {
                putExtra("title", recipe.title)
                putExtra("description", recipe.description)
                putExtra("imageResId", recipe.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = recipes.size
}

data class Recipe(
    val title: String,
    val description: String,
    val imageResId: Int
) 