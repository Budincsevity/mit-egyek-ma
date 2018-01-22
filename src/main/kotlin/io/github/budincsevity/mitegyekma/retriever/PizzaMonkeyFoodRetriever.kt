package io.github.budincsevity.mitegyekma.retriever

import io.github.budincsevity.mitegyekma.util.random
import org.jsoup.Jsoup

class PizzaMonkeyFoodRetriever : FoodRetriever() {

    override fun retrieveARandomFood() {
        val foodCategory = pickARandomFoodCategory()
        val document = Jsoup.connect("$PIZZAMONKEY_URL/${foodCategory.name.toLowerCase()}").get()

        val foods = document?.getElementsByClass("food__title")
        val randomFoodTitle = foods?.random()?.text()

        printMenu(food = randomFoodTitle ?: "", foodCategory = foodCategory.name)
    }

    companion object {
        private const val PIZZAMONKEY_URL = "http://pizzamonkey.hu/etelek"
        private fun pickARandomFoodCategory(): FoodType = FoodType.values().random()
    }

    private enum class FoodType {
        EGYTAL,
        SULTEK,
        TOLTOTTEK,
        GRILL,
        ROLAD,
        BOSEGTALAK,
        KORETEK,
        SAVANYUSAG,
        PIZZAK,
        TESZTAK;
    }
}
