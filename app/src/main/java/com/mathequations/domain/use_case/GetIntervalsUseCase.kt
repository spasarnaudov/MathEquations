package com.mathequations.domain.use_case

import com.mathequations.Constants
import com.core.presentation.model.SegmentedButtonItem
import com.mathequations.domain.model.NumbersInterval

class GetIntervalsUseCase {
    operator fun invoke(): List<SegmentedButtonItem<NumbersInterval>> {
        return listOf(
            SegmentedButtonItem(Constants.Interval.MINOS_000, NumbersInterval(-300, -100)),
            SegmentedButtonItem(Constants.Interval.MINOS_00, NumbersInterval(-100, -10)),
            SegmentedButtonItem(Constants.Interval.MINOS_0, NumbersInterval(-10, 0)),
            SegmentedButtonItem(Constants.Interval.PLUS_0, NumbersInterval(0, 10)),
            SegmentedButtonItem(Constants.Interval.PLUS_00, NumbersInterval(10, 100)),
            SegmentedButtonItem(Constants.Interval.PLUS_000, NumbersInterval(100, 300)),
        )
    }
}