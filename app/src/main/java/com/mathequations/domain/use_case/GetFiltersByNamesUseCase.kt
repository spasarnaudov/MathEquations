package com.mathequations.domain.use_case

import com.mathequations.domain.filters.AbstractEquationFilter

class GetFiltersByNamesUseCase {
    operator fun invoke(selectedFilters: MutableMap<String, Boolean>, allFilters: List<AbstractEquationFilter>): List<AbstractEquationFilter> {
        val selectedFilters2 = selectedFilters.filter {
            it.value
        }
        return allFilters.filter {
            selectedFilters2.contains(it.name)
        }
    }
}