package com.github.kiolk.allmed.domain.usecase

import com.github.kiolk.allmed.data.datasource.dragpattern.DrugPatternRepository
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.domain.model.Either
import com.github.kiolk.allmed.domain.model.Failure
import java.util.*

class GetAcceptanceUseCase(private val drugPatternRepository: DrugPatternRepository): BaseUseCase<GetAcceptanceUseCase.Params, List<Acceptance>>() {

    override suspend fun run(param: Params): Either<Failure, List<Acceptance>> {
        return try {
            Either.Right(drugPatternRepository.getAcceptanceByDate(param.date))
        }catch (exception: Exception) {
            Either.Left(onWrapException(exception))
        }
    }

    data class Params(val date: Date)
}