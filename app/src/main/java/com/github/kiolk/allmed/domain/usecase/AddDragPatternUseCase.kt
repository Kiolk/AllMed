package com.github.kiolk.allmed.domain.usecase

import com.github.kiolk.allmed.data.datasource.drug.DragRepository
import com.github.kiolk.allmed.data.datasource.dragpattern.DrugPatternRepository
import com.github.kiolk.allmed.data.exstentions.*
import com.github.kiolk.allmed.data.model.Acceptance
import com.github.kiolk.allmed.data.model.DrugPattern
import com.github.kiolk.allmed.domain.model.Either
import com.github.kiolk.allmed.domain.model.Failure
import java.lang.Exception
import java.util.*
import kotlin.random.Random

class AddDragPatternUseCase(
    private val drugPatternRepository: DrugPatternRepository,
    private val dragRepository: DragRepository
) : BaseUseCase<AddDragPatternUseCase.Params, Boolean>() {

    override suspend fun run(param: Params): Either<Failure, Boolean> {
        return try {
            val drug = dragRepository.getAllDrugs()[Random.nextInt(3)]

            val start = Date(1588511711000)
            val end = Date(1588511711000 + (1000 * 60 * 60 * 24 * Random.nextInt(9)))
            val times = 3
            val interval = (4 * 1000 * 60 * 60).toLong()
            val dozen = Random.nextInt(3)
            val drag = DrugPattern(
                null,
                start,
                end,
                drug.id ?: 0,
                times,
                interval,
                dozen,
                "ml"
            )
            val acceptance = generateAcceptances(drag)

            drugPatternRepository.savePattern(drag)
            drugPatternRepository.saveAcceptance(acceptance)
            Either.Right(true)
        } catch (exception: Exception) {
            Either.Left(onWrapException(exception))
        }
    }

    private fun generateAcceptances(drugPattern: DrugPattern): List<Acceptance> {
        val startTime = drugPattern.start.startDay()
        val endTime = drugPattern.end.endDate()
        val diff = endTime - startTime
        val days = diff / ONE_DAY_MILLISECONDS
        val activeTime = 24 - START_DAY_SINCE - (24 - END_DAY_UNTIL)
        val rangeForAccept =
            (activeTime - drugPattern.interval * drugPattern.times) / drugPattern.times
        val dragInterval =
            if (rangeForAccept < 0) activeTime / drugPattern.times else drugPattern.interval
        val dayPattern: MutableList<Triple<Long, Long, Long>> = mutableListOf()
        var nextStartAcceptanceTime = START_DAY_SINCE
        for (time in 0..drugPattern.times) {
            var nextEndAcceptanceTime = 0L
            if (rangeForAccept > 0) {
                nextEndAcceptanceTime = nextStartAcceptanceTime + rangeForAccept
                dayPattern.add(
                    Triple(
                        nextStartAcceptanceTime,
                        nextStartAcceptanceTime + rangeForAccept / 2,
                        nextStartAcceptanceTime + rangeForAccept
                    )
                )
            } else {
                nextEndAcceptanceTime = nextStartAcceptanceTime
                dayPattern.add(
                    Triple(
                        nextStartAcceptanceTime,
                        nextStartAcceptanceTime,
                        nextStartAcceptanceTime
                    )
                )
            }
            nextStartAcceptanceTime = nextEndAcceptanceTime + dragInterval
        }

        val result = mutableListOf<Acceptance>()

        for (order in 0..days) {
            for (time in 0 until drugPattern.times) {
                val accept = dayPattern[time]
                val day = order * ONE_DAY_MILLISECONDS
                val acceptance = Acceptance(
                    null,
                    drugPattern.id ?: 0,
                    drugPattern.drugId,
                    "",
                    Date(),
                    Date(startTime + day + accept.first),
                    Date(startTime + day + accept.third)
                )
                result.add(acceptance)
            }
        }
        return result
    }

    class Params
}