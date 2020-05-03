package com.github.kiolk.allmed.domain.usecase

import com.github.kiolk.allmed.domain.model.Either
import com.github.kiolk.allmed.domain.model.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.net.UnknownHostException

abstract class BaseUseCase<in Param, out Type> where Type : Any {

    abstract suspend fun run(param: Param): Either<Failure, Type>

    open operator fun invoke(
        scope: CoroutineScope,
        param: Param,
        result: (Either<Failure, Type>) -> Unit = {}
    ) {
        val backgroundJob = scope.async { run(param) }
        scope.launch { result.invoke(backgroundJob.await()) }
    }

    protected fun onWrapException(exception: Exception): Failure {
        Timber.e(exception)
        return when (exception) {
            is UnknownHostException -> Failure.NetworkFailureL()
            is HttpException -> Failure.ApiFailure()
            else -> Failure.UnknownFailure()
        }
    }
}
