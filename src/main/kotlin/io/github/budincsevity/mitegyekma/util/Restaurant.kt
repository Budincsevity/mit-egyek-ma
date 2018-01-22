package io.github.budincsevity.mitegyekma.util

import io.github.budincsevity.mitegyekma.retriever.FoodRetriever
import io.github.budincsevity.mitegyekma.retriever.PizzaFutarFoodRetriever
import io.github.budincsevity.mitegyekma.retriever.PizzaMonkeyFoodRetriever
import io.github.budincsevity.mitegyekma.retriever.PizzaMonsterFoodRetriever

enum class Restaurant(val acceptedNames: List<String>, val foodRetriever: FoodRetriever) {
    PIZZA_MONKEY(arrayListOf("pizzamonkey", "monkey", "pm"), PizzaMonkeyFoodRetriever()),
    PIZZA_MONSTER(arrayListOf("pizzamonster", "monster"), PizzaMonsterFoodRetriever()),
    PIZZA_FUTAR(arrayListOf("pizzafutar", "futar", "pf"), PizzaFutarFoodRetriever());

    companion object {
        fun newMealFoodRetriever(restaurant: String): FoodRetriever {
            Restaurant.values().forEach {
                when {
                    it.acceptedNames.contains(restaurant) -> return it.foodRetriever
                }
            }

            return PIZZA_MONKEY.foodRetriever
        }
    }
}
