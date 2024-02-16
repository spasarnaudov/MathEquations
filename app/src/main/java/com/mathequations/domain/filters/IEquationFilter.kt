package com.mathequations.domain.filters

interface IEquationFilter {
    fun filter(firstNumber: Int, secondNumber: Int): Boolean
}