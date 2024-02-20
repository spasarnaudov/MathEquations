package com.mathequations.domain.util

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
            if (getModule(firstDigit) > getModule(secondDigit)) {
                return false
            } else if (getModule(firstDigit) < getModule(secondDigit)) {
                return true
            }
        } else if (isPositive(firstDigit) && isNegative(secondDigit)) {
            if (getModule(firstDigit) > getModule(secondDigit)) {
                return false
            } else if (getModule(firstDigit) < getModule(secondDigit)) {
                return true
            }
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return false
        }
        return passingTheTenth(firstNumber / 10, secondNumber / 10)
    }

    fun nonPassingTheTenth(firstNumber: Int, secondNumber: Int): Boolean {
        val firstDigit = firstNumber % 10
        val secondDigit = secondNumber % 10
        if (isPositive(firstDigit) && isPositive(secondDigit)) {
            if (firstDigit + secondDigit <= 10) {
                return true
            }
        } else if (isNegative(firstDigit) && isNegative(secondDigit)) {
            if (firstDigit + secondDigit <= 10) {
                return true
            }
        } else if (isNegative(firstDigit) && isPositive(secondDigit)) {
            if (getModule(firstDigit) > getModule(secondDigit)) {
                return true
            } else if (getModule(firstDigit) < getModule(secondDigit)) {
                return false
            }
        } else if (isPositive(firstDigit) && isNegative(secondDigit)) {
            if (getModule(firstDigit) > getModule(secondDigit)) {
                return true
            } else if (getModule(firstDigit) < getModule(secondDigit)) {
                return false
            }
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return true
        }
        return nonPassingTheTenth(firstNumber / 10, secondNumber / 10)
    }

    private fun isPositive(number: Int): Boolean {
        return number > 0
    }

    private fun isNegative(number: Int): Boolean {
        return number < 0
    }

    private fun getModule(number: Int): Int {
        return if (number < 0) {
            -1 * number
        } else {
            number
        }
    }
}