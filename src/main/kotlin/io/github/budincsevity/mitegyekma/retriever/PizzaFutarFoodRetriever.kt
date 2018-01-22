package io.github.budincsevity.mitegyekma.retriever

import io.github.budincsevity.mitegyekma.util.random
import org.jsoup.Jsoup

class PizzaFutarFoodRetriever : FoodRetriever() {

    override fun retrieveARandomFood() {
        val foodCategory = pickARandomFoodCategory()
        val document = Jsoup.connect("$PIZZAFUTAR_URL/${foodCategory.name.toLowerCase()}").get()

        val foods = document?.getElementsByClass("pizza_arlista")?.get(0)?.children()?.get(0)?.children()
        val randomFood = foods?.random()
        val randomFoodTitle = randomFood?.children()?.get(0)?.text()

        printMenu(food = randomFoodTitle ?: "", foodCategory = foodCategory.name)
    }

    companion object {
        private const val PIZZAFUTAR_URL = "http://www.pizzafutar.co.hu"
        private fun pickARandomFoodCategory(): FoodType = FoodType.values().random()
    }

    private enum class FoodType {
        PIZZA,
        SALATA,
        GYROS,
        ROSTELYOS,
        TESZTA,
        LEVES,
        DESSZERT;
    }
}
