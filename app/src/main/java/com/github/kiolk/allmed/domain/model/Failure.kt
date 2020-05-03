package com.github.kiolk.allmed.domain.model

sealed class Failure {
    open class FeatureFailer(val exception: Exception) : Failure()
    open class UnknownFailure : Failure()
    open class NetworkFailureL : Failure()
    open class ApiFailure : Failure()
}