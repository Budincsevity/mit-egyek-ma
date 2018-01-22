package io.github.budincsevity.mitegyekma.retriever

abstract class FoodRetriever {
    abstract fun retrieveARandomFood()

    protected fun printMenu(food: String, foodCategory: String) {
        print("Ma egy $food-t eszek a(z) $foodCategory közül")
    }
}
