package com.github.kiolk.allmed.di.module

import com.github.kiolk.allmed.domain.usecase.AddDragPatternUseCase
import com.github.kiolk.allmed.domain.usecase.GetAcceptanceUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { AddDragPatternUseCase(get(), get()) }
    factory { GetAcceptanceUseCase(get()) }
}