package io.github.budincsevity.mitegyekma.retriever

import io.github.budincsevity.mitegyekma.util.random
import org.jsoup.Jsoup

class PizzaMonsterFoodRetriever : FoodRetriever() {

    override fun retrieveARandomFood() {
        val foodCategory = pickARandomFoodCategory()
        val document = Jsoup.connect("$PIZZAMONSTER_URL/${foodCategory.foodUrlName}").get()

        val foods = document?.getElementsByClass("entry-title")
        val randomFoodTitle = foods?.random()?.text()

        printMenu(food = randomFoodTitle ?: "", foodCategory = foodCategory.name)
    }

    companion object {
        private const val PIZZAMONSTER_URL = "http://new.pizzamonster.hu"
        private fun pickARandomFoodCategory(): FoodType = FoodType.values().random()
    }

    private enum class FoodType(val foodUrlName: String) {
        PIZZAK("pizzak"),
        BIGGER_BURGER("bigger-burger"),
        MONSTER_BURGER("pizzaburgerek"),
        CHICKEN_BOX("chicken-box"),
        FAJITAS("fajitas"),
        TOLTOTT_SZELET("toltott-husok"),
        FRISSEN_SULT("rantott-etelek"),
        EGYTAL_ETELEK("foetelek"),
        TALAK("talak"),
        TESZTAK("grande-pasta-spagettivel");
    }
}
