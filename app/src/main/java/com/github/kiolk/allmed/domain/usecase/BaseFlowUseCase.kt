package com.github.kiolk.allmed.domain.usecase

import kotlinx.coroutines.flow.Flow

abstract class BaseFlowUseCase<out Type, in Params> {

    abstract suspend fun execute(param: Params): Flow<Type>
}