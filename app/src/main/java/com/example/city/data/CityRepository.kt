package com.example.city.data

import com.example.city.R
import com.example.city.model.Category
import com.example.city.model.Recommendation

object CityRepository {

    private val recommendations = listOf(
        // Coffee
        Recommendation(
            id = 1,
            titleResId = R.string.coffee_1_title,
            descriptionResId = R.string.coffee_1_desc,
            addressResId = R.string.coffee_1_addresses,
            imageResId = R.drawable.tasty_coffee_logo,
            category = Category.COFFEE
        ),
        Recommendation(
            id = 2,
            titleResId = R.string.coffee_2_title,
            descriptionResId = R.string.coffee_2_desc,
            addressResId = R.string.coffee_2_addresses,
            imageResId = R.drawable.coffee_moose_logo,
            category = Category.COFFEE
        ),
        Recommendation(
            id = 3,
            titleResId = R.string.coffee_3_title,
            descriptionResId = R.string.coffee_3_desc,
            addressResId = R.string.coffee_3_address,
            imageResId = R.drawable.moms_pancakes_logo,
            category = Category.COFFEE
        ),
        Recommendation(
            id = 4,
            titleResId = R.string.coffee_4_title,
            descriptionResId = R.string.coffee_4_desc,
            addressResId = R.string.coffee_4_address,
            imageResId = R.drawable.chashka_logo,
            category = Category.COFFEE
        ),
        Recommendation(
            id = 5,
            titleResId = R.string.coffee_5_title,
            descriptionResId = R.string.coffee_5_desc,
            addressResId = R.string.coffee_5_address,
            imageResId = R.drawable.brauplatz_cafe_logo,
            category = Category.COFFEE
        ),

        // Food / Restaurants
        Recommendation(
            id = 6,
            titleResId = R.string.food_1_title,
            descriptionResId = R.string.food_1_desc,
            addressResId = R.string.food_1_address,
            imageResId = R.drawable.minbo_logo,
            category = Category.FOOD
        ),
        Recommendation(
            id = 7,
            titleResId = R.string.food_2_title,
            descriptionResId = R.string.food_2_desc,
            addressResId = R.string.food_2_address,
            imageResId = R.drawable.b7_logo,
            category = Category.FOOD
        ),
        Recommendation(
            id = 8,
            titleResId = R.string.food_3_title,
            descriptionResId = R.string.food_3_desc,
            addressResId = R.string.food_3_address,
            imageResId = R.drawable.hinkalnaya_pod_parusom_logo,
            category = Category.FOOD
        ),
        Recommendation(
            id = 9,
            titleResId = R.string.food_4_title,
            descriptionResId = R.string.food_4_desc,
            addressResId = R.string.food_4_address,
            imageResId = R.drawable.kama_logo,
            category = Category.FOOD
        ),
        Recommendation(
            id = 10,
            titleResId = R.string.food_5_title,
            descriptionResId = R.string.food_5_desc,
            addressResId = R.string.food_5_address,
            imageResId = R.drawable.avalon_logo,
            category = Category.FOOD
        ),

        // Kids
        Recommendation(
            id = 11,
            titleResId = R.string.kids_1_title,
            descriptionResId = R.string.kids_1_desc,
            addressResId = R.string.kids_1_address,
            imageResId = R.drawable.dinopolis_logo,
            category = Category.KIDS
        ),
        Recommendation(
            id = 12,
            titleResId = R.string.kids_2_title,
            descriptionResId = R.string.kids_2_desc,
            addressResId = R.string.kids_2_address,
            imageResId = R.drawable.zoopark_logo,
            category = Category.KIDS
        ),
        Recommendation(
            id = 13,
            titleResId = R.string.kids_3_title,
            descriptionResId = R.string.kids_3_desc,
            addressResId = R.string.kids_3_address,
            imageResId = R.drawable.family_park_logo,
            category = Category.KIDS
        ),
        Recommendation(
            id = 14,
            titleResId = R.string.kids_4_title,
            descriptionResId = R.string.kids_4_desc,
            addressResId = R.string.kids_4_address,
            imageResId = R.drawable.vr_club_escape_logo,
            category = Category.KIDS
        ),
        Recommendation(
            id = 15,
            titleResId = R.string.kids_5_title,
            descriptionResId = R.string.kids_5_desc,
            addressResId = R.string.kids_5_address,
            imageResId = R.drawable.parki,
            category = Category.KIDS
        ),

        // Parks
        Recommendation(
            id = 16,
            titleResId = R.string.parks_1_title,
            descriptionResId = R.string.parks_1_desc,
            addressResId = R.string.parks_1_address,
            imageResId = R.drawable.parki,
            category = Category.PARKS
        ),
        Recommendation(
            id = 17,
            titleResId = R.string.parks_2_title,
            descriptionResId = R.string.parks_2_desc,
            addressResId = R.string.parks_2_address,
            imageResId = R.drawable.parki,
            category = Category.PARKS
        ),
        Recommendation(
            id = 18,
            titleResId = R.string.parks_3_title,
            descriptionResId = R.string.parks_3_desc,
            addressResId = R.string.parks_3_address,
            imageResId = R.drawable.parki,
            category = Category.PARKS
        ),
        Recommendation(
            id = 19,
            titleResId = R.string.parks_4_title,
            descriptionResId = R.string.parks_4_desc,
            addressResId = R.string.parks_4_address,
            imageResId = R.drawable.parki,
            category = Category.PARKS
        ),
        Recommendation(
            id = 20,
            titleResId = R.string.parks_5_title,
            descriptionResId = R.string.parks_5_desc,
            addressResId = R.string.parks_5_address,
            imageResId = R.drawable.berezovaya_rosha_logo,
            category = Category.PARKS
        ),

        // Shops
        Recommendation(
            id = 21,
            titleResId = R.string.shop_1_title,
            descriptionResId = R.string.shop_1_desc,
            addressResId = R.string.shop_1_address,
            imageResId = R.drawable.petrovskiy_logo,
            category = Category.SHOP
        ),
        Recommendation(
            id = 22,
            titleResId = R.string.shop_2_title,
            descriptionResId = R.string.shop_2_desc,
            addressResId = R.string.shop_2_address,
            imageResId = R.drawable.petrovskiy_logo,
            category = Category.SHOP
        ),
        Recommendation(
            id = 23,
            titleResId = R.string.shop_3_title,
            descriptionResId = R.string.shop_3_desc,
            addressResId = R.string.shop_3_address,
            imageResId = R.drawable.aksion_logo,
            category = Category.SHOP
        ),
        Recommendation(
            id = 24,
            titleResId = R.string.shop_4_title,
            descriptionResId = R.string.shop_4_desc,
            addressResId = R.string.shop_4_address,
            imageResId = R.drawable.city_mall_logo,
            category = Category.SHOP
        ),
        Recommendation(
            id = 25,
            titleResId = R.string.shop_5_title,
            descriptionResId = R.string.shop_5_desc,
            addressResId = R.string.shop_5_address,
            imageResId = R.drawable.tsum_logo,
            category = Category.SHOP
        )
    )

    fun getByCategory(category: Category): List<Recommendation> {
        return recommendations.filter { it.category == category }
    }

    fun getById(id: Int): Recommendation? {
        return recommendations.find { it.id == id }
    }
}