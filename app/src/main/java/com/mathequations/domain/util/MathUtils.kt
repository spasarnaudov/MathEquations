package com.mathequations.domain.util

import kotlin.math.abs

object MathUtils {
    fun passingTheTenth(firstNumber: Int, secondNumber: Int): Boolean {
        val firstDigit = firstNumber % 10
        val secondDigit = secondNumber % 10
        if (isPositive(firstDigit) && isPositive(secondDigit)) {
            if (firstDigit + secondDigit > 10) {
                return true
            }
        } else if (isNegative(firstDigit) && isNegative(secondDigit)) {
            if (firstDigit + secondDigit > 10) {
                return true
            }
        } else if (isNegative(firstDigit) && isPositive(secondDigit)) {
            if (abs(firstDigit) > abs(secondDigit)) {
                return false
            } else if (abs(firstDigit) < abs(secondDigit)) {
                return true
            }
        } else if (isPositive(firstDigit) && isNegative(secondDigit)) {
            if (abs(firstDigit) > abs(secondDigit)) {
                return false
            } else if (abs(firstDigit) < abs(secondDigit)) {
                return true
            }
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return false
        }
        return passingTheTenth(firstNumber / 10, secondNumber / 10)
    }

    fun isSubtractionWithBorrowing(minuend: Int, subtrahend: Int): Boolean {
        if (minuend == 0 && subtrahend == 0) return false

        val lastDigitMinuend = minuend % 10
        val lastDigitSubtrahend = subtrahend % 10

        if (isPositive(lastDigitMinuend) && isPositive(lastDigitSubtrahend)) {
            if (lastDigitSubtrahend > lastDigitMinuend) return true
        } else if (isNegative(lastDigitMinuend) && isNegative(lastDigitSubtrahend)) {
            if (abs(lastDigitSubtrahend) > abs(lastDigitMinuend)) return true
        } else if (isNegative(lastDigitMinuend) && isPositive(lastDigitSubtrahend)) {
            return false
        } else if (isPositive(lastDigitMinuend) && isNegative(lastDigitSubtrahend)) {
            return false
        }

        return isSubtractionWithBorrowing(minuend / 10, subtrahend / 10)
    }

    private fun isPositive(number: Int): Boolean {
        return number > 0
    }

    private fun isNegative(number: Int): Boolean {
        return number < 0
    }
}