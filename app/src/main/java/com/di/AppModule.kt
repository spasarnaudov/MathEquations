package com.di

import com.mathequations.domain.use_case.GenerateMathEquationsUseCase
import com.mathequations.domain.use_case.GetMathOperationsUseCase
import com.mathequations.domain.use_case.MathEquationUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMathEquationUseCases(): MathEquationUseCases {
        return MathEquationUseCases(
            generateMathEquationsUseCase = GenerateMathEquationsUseCase(),
            getMathOperationsUseCase = GetMathOperationsUseCase(),
        )
    }

}