package com.number_generator.domain.use_case

import kotlin.random.Random

class SelectiveNumberGenerator(
    private val includedNumbers: ArrayList<Int> = ArrayList()
) {

    fun includeNumber(number: Int) {
        includedNumbers.add(number)
    }

    fun excludeNumber(number: Int) {
        includedNumbers.remove(number)
    }

    fun contains(number: Int): Boolean {
        return includedNumbers.contains(number)
    }

    fun generate(): Int? {
        return if (includedNumbers.isNotEmpty()) {
            val index = Random.nextInt(includedNumbers.size)
            includedNumbers.elementAt(index)
        } else {
            null // or throw an exception if preferred
        }
    }
}