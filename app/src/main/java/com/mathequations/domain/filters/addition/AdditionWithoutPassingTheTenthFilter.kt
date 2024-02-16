package com.mathequations.domain.filters.addition

class AdditionWithoutPassingTheTenthFilter : AdditionByPassingTheTenthFilter() {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        return !super.filter(firstNumber, secondNumber)
    }

    override fun toString(): String {
        return "Addition Without Passing The Tenth"
    }
}