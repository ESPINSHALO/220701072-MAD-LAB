package com.example.recipe

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get recipe details from intent
        val title = intent.getStringExtra("title") ?: ""
        val description = intent.getStringExtra("description") ?: ""
        val imageResId = intent.getIntExtra("imageResId", R.drawable.ic_breakfast)

        // Set recipe details
        findViewById<TextView>(R.id.recipeTitle).text = title
        findViewById<TextView>(R.id.recipeDescription).text = description
        findViewById<ImageView>(R.id.recipeImage).setImageResource(imageResId)

        // Set ingredients and cooking steps based on recipe
        val (ingredients, steps) = getRecipeDetails(title)
        findViewById<TextView>(R.id.ingredientsList).text = ingredients
        findViewById<TextView>(R.id.cookingSteps).text = steps
    }

    private fun getRecipeDetails(recipeName: String): Pair<String, String> {
        return when (recipeName) {
            // Breakfast Items
            "Idly" -> Pair(
                "• 2 cups idli rice\n• 1 cup urad dal\n• 1 tsp fenugreek seeds\n• Salt to taste\n• Water as needed",
                "1. Soak rice and urad dal separately for 4-6 hours\n" +
                "2. Grind urad dal to a smooth batter\n" +
                "3. Grind rice to a coarse batter\n" +
                "4. Mix both batters, add salt and let ferment overnight\n" +
                "5. Grease idli plates and pour batter\n" +
                "6. Steam for 10-12 minutes\n" +
                "7. Serve hot with sambar and chutney"
            )
            "Dosa" -> Pair(
                "• 2 cups rice\n• 1 cup urad dal\n• 1/2 cup poha\n• Salt to taste\n• Oil for cooking",
                "1. Soak rice and urad dal separately for 4-6 hours\n" +
                "2. Grind urad dal to a smooth batter\n" +
                "3. Grind rice and poha to a smooth batter\n" +
                "4. Mix both batters, add salt and let ferment overnight\n" +
                "5. Heat a tawa and pour batter in circular motion\n" +
                "6. Drizzle oil and cook until crispy\n" +
                "7. Serve hot with sambar and chutney"
            )
            "Upma" -> Pair(
                "• 1 cup rava (semolina)\n• 1 onion, finely chopped\n• 1 green chili, chopped\n• 1 tsp mustard seeds\n• 1 tsp urad dal\n• Curry leaves\n• 2.5 cups water\n• Salt to taste\n• 2 tbsp oil",
                "1. Dry roast rava until light golden, set aside\n" +
                "2. Heat oil in a pan, add mustard seeds and urad dal\n" +
                "3. Add curry leaves, onion, and green chili\n" +
                "4. Sauté until onions are translucent\n" +
                "5. Add water and salt, bring to boil\n" +
                "6. Slowly add roasted rava while stirring\n" +
                "7. Cook on low heat until water is absorbed\n" +
                "8. Serve hot with chutney"
            )
            "Pongal" -> Pair(
                "• 1 cup rice\n• 1/4 cup moong dal\n• 1 tsp black pepper\n• 1 tsp cumin seeds\n• 1 inch ginger, chopped\n• 10-12 cashews\n• 2 tbsp ghee\n• Salt to taste\n• 3.5 cups water",
                "1. Dry roast moong dal for 2-3 minutes\n" +
                "2. Wash rice and roasted dal together\n" +
                "3. Pressure cook with water and salt for 4-5 whistles\n" +
                "4. Heat ghee, fry cashews until golden\n" +
                "5. Add cumin, pepper, and ginger\n" +
                "6. Add cooked rice-dal mixture\n" +
                "7. Mix well and serve hot"
            )
            "Poori" -> Pair(
                "• 2 cups whole wheat flour\n• 1/2 tsp salt\n• Water as needed\n• Oil for deep frying",
                "1. Mix flour and salt\n" +
                "2. Add water gradually to make firm dough\n" +
                "3. Rest dough for 15 minutes\n" +
                "4. Divide into small balls\n" +
                "5. Roll into small circles\n" +
                "6. Heat oil and fry until puffed and golden\n" +
                "7. Serve hot with potato curry"
            )

            // Lunch Items
            "Chicken Biryani" -> Pair(
                "• 500g chicken\n• 2 cups basmati rice\n• 2 onions\n• 2 tomatoes\n• Ginger-garlic paste\n• Biryani masala\n• Mint leaves\n• Coriander leaves\n• Ghee\n• Salt to taste",
                "1. Marinate chicken with spices for 30 minutes\n" +
                "2. Cook rice until 70% done\n" +
                "3. Cook marinated chicken until tender\n" +
                "4. Layer rice and chicken in a heavy-bottomed pan\n" +
                "5. Add mint and coriander leaves between layers\n" +
                "6. Cook on dum for 20-25 minutes\n" +
                "7. Serve hot with raita"
            )
            "Mutton Biriyani" -> Pair(
                "• 500g mutton\n• 2 cups basmati rice\n• 2 onions\n• 2 tomatoes\n• Ginger-garlic paste\n• Biryani masala\n• Mint leaves\n• Coriander leaves\n• Ghee\n• Salt to taste",
                "1. Marinate mutton with spices for 1 hour\n" +
                "2. Pressure cook mutton until tender\n" +
                "3. Cook rice until 70% done\n" +
                "4. Layer rice and mutton in a heavy-bottomed pan\n" +
                "5. Add mint and coriander leaves between layers\n" +
                "6. Cook on dum for 20-25 minutes\n" +
                "7. Serve hot with raita"
            )
            "Vegetable Biriyani" -> Pair(
                "• 2 cups basmati rice\n• Mixed vegetables (carrot, beans, peas, potato)\n• 2 onions\n• 2 tomatoes\n• Ginger-garlic paste\n• Biryani masala\n• Mint leaves\n• Coriander leaves\n• Ghee\n• Salt to taste",
                "1. Cook rice until 70% done\n" +
                "2. Sauté vegetables with spices\n" +
                "3. Layer rice and vegetables in a heavy-bottomed pan\n" +
                "4. Add mint and coriander leaves between layers\n" +
                "5. Cook on dum for 15-20 minutes\n" +
                "6. Serve hot with raita"
            )
            "Butter Chicken" -> Pair(
                "• 500g chicken\n• 2 onions\n• 2 tomatoes\n• Butter\n• Cream\n• Kasuri methi\n• Garam masala\n• Red chili powder\n• Salt to taste",
                "1. Marinate chicken with spices and yogurt\n" +
                "2. Grill or bake chicken until cooked\n" +
                "3. Make tomato-onion puree\n" +
                "4. Cook puree with butter and spices\n" +
                "5. Add cooked chicken pieces\n" +
                "6. Finish with cream and kasuri methi\n" +
                "7. Serve hot with naan or rice"
            )
            "Fish Curry" -> Pair(
                "• 500g fish\n• 2 onions\n• 2 tomatoes\n• Ginger-garlic paste\n• Turmeric powder\n• Red chili powder\n• Coriander powder\n• Coconut milk\n• Curry leaves\n• Salt to taste",
                "1. Clean and cut fish into pieces\n" +
                "2. Marinate fish with turmeric and salt\n" +
                "3. Sauté onions, ginger-garlic paste\n" +
                "4. Add tomatoes and spices\n" +
                "5. Add coconut milk and bring to boil\n" +
                "6. Add fish pieces and cook for 10 minutes\n" +
                "7. Garnish with curry leaves and serve hot"
            )

            // Dinner Items
            "Chappathi" -> Pair(
                "• 2 cups whole wheat flour\n• Water as needed\n• Salt to taste\n• Oil for cooking",
                "1. Mix flour and salt\n" +
                "2. Add water to make soft dough\n" +
                "3. Rest dough for 15 minutes\n" +
                "4. Divide into small balls\n" +
                "5. Roll into thin circles\n" +
                "6. Cook on hot tawa until brown spots appear\n" +
                "7. Apply oil and serve hot"
            )
            "Noodles" -> Pair(
                "• 200g noodles\n• 1 cup mixed vegetables\n• 2 tbsp soy sauce\n• 1 tbsp vinegar\n• 1 tsp ginger-garlic paste\n• Spring onions\n• Salt and pepper\n• Oil for cooking",
                "1. Boil noodles until al dente\n" +
                "2. Heat oil, add ginger-garlic paste\n" +
                "3. Add vegetables and stir-fry\n" +
                "4. Add soy sauce and vinegar\n" +
                "5. Add cooked noodles\n" +
                "6. Toss well and season\n" +
                "7. Garnish with spring onions"
            )
            "Pasta" -> Pair(
                "• 200g pasta\n• 1 cup tomato sauce\n• 1 onion\n• 2 cloves garlic\n• 1 tsp mixed herbs\n• Cheese\n• Salt and pepper\n• Oil for cooking",
                "1. Boil pasta until al dente\n" +
                "2. Heat oil, sauté garlic and onion\n" +
                "3. Add tomato sauce and herbs\n" +
                "4. Add cooked pasta\n" +
                "5. Mix well and season\n" +
                "6. Top with cheese\n" +
                "7. Serve hot"
            )
            "Naan & Butter Paneer" -> Pair(
                "For Naan:\n• 2 cups all-purpose flour\n• 1/4 cup yogurt\n• 1 tsp sugar\n• 1 tsp baking powder\n• Salt to taste\n\nFor Paneer:\n• 200g paneer\n• 2 onions\n• 2 tomatoes\n• Butter\n• Cream\n• Garam masala\n• Salt to taste",
                "For Naan:\n1. Mix all ingredients to make dough\n" +
                "2. Rest for 2 hours\n" +
                "3. Divide into balls\n" +
                "4. Roll and cook on hot tawa\n\n" +
                "For Paneer:\n1. Cut paneer into cubes\n" +
                "2. Make tomato-onion puree\n" +
                "3. Cook puree with butter and spices\n" +
                "4. Add paneer and cream\n" +
                "5. Simmer for 5 minutes\n" +
                "6. Serve hot with naan"
            )
            "Aapam" -> Pair(
                "• 1 cup raw rice\n• 1/4 cup cooked rice\n• 1/4 cup coconut\n• 1 tsp yeast\n• 1 tsp sugar\n• Salt to taste\n• Water as needed",
                "1. Soak raw rice for 4 hours\n" +
                "2. Grind with coconut and cooked rice\n" +
                "3. Add yeast and sugar\n" +
                "4. Let ferment for 8 hours\n" +
                "5. Heat appam pan\n" +
                "6. Pour batter and swirl\n" +
                "7. Cover and cook until done"
            )

            // Juice Items
            "Mango Shake" -> Pair(
                "• 2 ripe mangoes\n• 2 cups milk\n• 2 tbsp sugar\n• Ice cubes\n• Cardamom powder (optional)",
                "1. Peel and cut mangoes into pieces\n" +
                "2. Add mango pieces to blender\n" +
                "3. Add milk and sugar\n" +
                "4. Blend until smooth\n" +
                "5. Add ice cubes and blend again\n" +
                "6. Pour into glasses\n" +
                "7. Serve chilled"
            )
            "Lemonade" -> Pair(
                "• 4 lemons\n• 4 cups water\n• 4 tbsp sugar\n• Mint leaves\n• Ice cubes\n• Salt to taste",
                "1. Squeeze juice from lemons\n" +
                "2. Add water and sugar\n" +
                "3. Stir until sugar dissolves\n" +
                "4. Add mint leaves\n" +
                "5. Add ice cubes\n" +
                "6. Serve chilled"
            )
            "Watermelon Juice" -> Pair(
                "• 4 cups watermelon cubes\n• 1 tsp lemon juice\n• Mint leaves\n• Ice cubes\n• Salt to taste",
                "1. Remove seeds from watermelon\n" +
                "2. Blend watermelon until smooth\n" +
                "3. Add lemon juice\n" +
                "4. Strain if needed\n" +
                "5. Add ice cubes\n" +
                "6. Garnish with mint\n" +
                "7. Serve chilled"
            )
            "Orange Juice" -> Pair(
                "• 4-5 oranges\n• 1 tsp lemon juice\n• Sugar (optional)\n• Ice cubes\n• Mint leaves",
                "1. Peel and cut oranges\n" +
                "2. Extract juice using juicer\n" +
                "3. Add lemon juice\n" +
                "4. Add sugar if needed\n" +
                "5. Add ice cubes\n" +
                "6. Garnish with mint\n" +
                "7. Serve chilled"
            )
            "Pineapple Juice" -> Pair(
                "• 1 pineapple\n• 1 tsp lemon juice\n• Sugar (optional)\n• Ice cubes\n• Mint leaves",
                "1. Peel and cut pineapple\n" +
                "2. Blend until smooth\n" +
                "3. Strain to remove pulp\n" +
                "4. Add lemon juice\n" +
                "5. Add sugar if needed\n" +
                "6. Add ice cubes\n" +
                "7. Serve chilled"
            )

            // Snack Items
            "Samosa" -> Pair(
                "For Dough:\n• 2 cups all-purpose flour\n• 4 tbsp oil\n• Salt to taste\n• Water as needed\n\nFor Filling:\n• 3 potatoes, boiled and mashed\n• 1 cup green peas\n• 1 onion, finely chopped\n• 2 green chilies, chopped\n• 1 tsp ginger-garlic paste\n• 1 tsp garam masala\n• 1 tsp coriander powder\n• 1 tsp cumin seeds\n• Oil for deep frying",
                "For Dough:\n1. Mix flour, oil, and salt\n" +
                "2. Add water to make firm dough\n" +
                "3. Rest for 30 minutes\n\n" +
                "For Filling:\n1. Heat oil, add cumin seeds\n" +
                "2. Add onions, ginger-garlic paste, and green chilies\n" +
                "3. Add peas and spices\n" +
                "4. Add mashed potatoes and mix well\n" +
                "5. Cool the filling\n\n" +
                "Assembly:\n1. Divide dough into small balls\n" +
                "2. Roll into thin circles\n" +
                "3. Cut into semi-circles\n" +
                "4. Fill with potato mixture\n" +
                "5. Seal edges with water\n" +
                "6. Deep fry until golden brown\n" +
                "7. Serve hot with chutney"
            )
            "Pakora" -> Pair(
                "• 1 cup gram flour (besan)\n• 1 onion, sliced\n• 1 potato, sliced\n• 1 cup spinach leaves\n• 2 green chilies, chopped\n• 1 tsp ginger-garlic paste\n• 1 tsp red chili powder\n• 1 tsp garam masala\n• Salt to taste\n• Oil for deep frying",
                "1. Mix gram flour with spices and salt\n" +
                "2. Add water to make thick batter\n" +
                "3. Add vegetables and mix well\n" +
                "4. Heat oil in a pan\n" +
                "5. Drop spoonfuls of batter\n" +
                "6. Fry until golden and crispy\n" +
                "7. Serve hot with chutney"
            )
            "Vada Pav" -> Pair(
                "For Vada:\n• 4 potatoes, boiled and mashed\n• 1 cup gram flour\n• 2 green chilies, chopped\n• 1 tsp ginger-garlic paste\n• 1 tsp mustard seeds\n• Curry leaves\n• Salt to taste\n• Oil for deep frying\n\nFor Pav:\n• 4 pav buns\n• Butter for toasting",
                "For Vada:\n1. Heat oil, add mustard seeds and curry leaves\n" +
                "2. Add ginger-garlic paste and green chilies\n" +
                "3. Add mashed potatoes and spices\n" +
                "4. Make small balls\n" +
                "5. Dip in gram flour batter\n" +
                "6. Deep fry until golden\n\n" +
                "Assembly:\n1. Slit pav buns\n" +
                "2. Apply butter and toast\n" +
                "3. Place vada in the bun\n" +
                "4. Serve hot with chutney"
            )
            "Bhel Puri" -> Pair(
                "• 2 cups puffed rice\n• 1 cup sev\n• 1 onion, finely chopped\n• 1 tomato, finely chopped\n• 1 potato, boiled and diced\n• 2 tbsp tamarind chutney\n• 2 tbsp green chutney\n• 1 tsp chaat masala\n• Coriander leaves\n• Salt to taste",
                "1. Mix puffed rice with sev\n" +
                "2. Add chopped vegetables\n" +
                "3. Add tamarind and green chutney\n" +
                "4. Sprinkle chaat masala\n" +
                "5. Add salt to taste\n" +
                "6. Garnish with coriander\n" +
                "7. Serve immediately"
            )
            "Kachori" -> Pair(
                "For Dough:\n• 2 cups all-purpose flour\n• 4 tbsp oil\n• Salt to taste\n• Water as needed\n\nFor Filling:\n• 1 cup yellow moong dal\n• 1 tsp cumin seeds\n• 1 tsp fennel seeds\n• 1 tsp coriander powder\n• 1 tsp red chili powder\n• Oil for deep frying",
                "For Dough:\n1. Mix flour, oil, and salt\n" +
                "2. Add water to make firm dough\n" +
                "3. Rest for 30 minutes\n\n" +
                "For Filling:\n1. Soak moong dal for 2 hours\n" +
                "2. Grind to coarse paste\n" +
                "3. Heat oil, add spices\n" +
                "4. Add ground dal and cook\n" +
                "5. Cool the filling\n\n" +
                "Assembly:\n1. Divide dough into small balls\n" +
                "2. Roll into small circles\n" +
                "3. Fill with dal mixture\n" +
                "4. Seal edges\n" +
                "5. Deep fry until golden\n" +
                "6. Serve hot with chutney"
            )

            else -> Pair(
                "Ingredients not available",
                "Cooking steps not available"
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
} 