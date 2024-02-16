package com.mathequations.domain.use_case

import com.mathequations.domain.filters.IEquationFilter

class GetFiltersByNamesUseCase {
    operator fun invoke(selectedFilters: MutableMap<String, Boolean>, allFilters: List<IEquationFilter>): List<IEquationFilter> {
        val selectedFilters2 = selectedFilters.filter {
            it.value
        }
        return allFilters.filter {
            selectedFilters2.contains(it.toString())
        }
    }
}