package io.github.budincsevity.mitegyekma.util

import java.util.concurrent.ThreadLocalRandom

fun ClosedRange<Int>.random() = ThreadLocalRandom.current().nextInt(start, endInclusive - 1)
fun <T> Array<T>.random(): T = this[(0 until this.size).random()]
fun <T> List<T>.random(): T = this[(0 until this.size).random()]
