package io.github.budincsevity.mitegyekma

import io.github.budincsevity.mitegyekma.util.Restaurant

fun main(args: Array<String>) {
    if (args.isEmpty() || args.size > 1) {
        throw IllegalArgumentException(generateManual())
    }

    Restaurant.newMealFoodRetriever(restaurant = args[0]).retrieveARandomFood()
}

private fun generateManual(): String {
    return """Usage: java -jar mit-egyek-ma.jar restaurantname
                |-restaurantname    [${Restaurant.PIZZA_MONKEY}=${Restaurant.PIZZA_MONKEY.acceptedNames} |
                |                    ${Restaurant.PIZZA_MONSTER}=${Restaurant.PIZZA_MONSTER.acceptedNames} |
                |                    ${Restaurant.PIZZA_FUTAR}=${Restaurant.PIZZA_FUTAR.acceptedNames}]
            """.trimMargin()
}
