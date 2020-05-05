package com.github.kiolk.allmed.presentation.adapter.doctor

import com.github.kiolk.allmed.data.exstentions.ONE_DAY_MILLISECONDS
import com.github.kiolk.allmed.presentation.enums.Status
import com.github.kiolk.allmed.presentation.model.Diagnostic
import com.github.kiolk.allmed.presentation.model.Doctor
import java.util.*

val stubDoctor = Doctor(
    "https://shkolazhizni.ru/img/content/i133/133728_or.jpg",
    "Крутых Александр Анатольевич",
    "Врач терапевт",
    Date(),
    "Люди лечили друг друга с незапамятных времен, но как наука медицина стала формироваться в Древнем Риме и Древней Греции"
)

val stubDoctor2 = Doctor(
    "https://story.ru/upload/iblock/420/420752915ee2b81eaf844afb9af2e906.jpg",
    "Онегин Евгений Сергеевич",
    "Хирург",
    Date(),
    "Per aspersa ad astra."
)

val completedDiagnostic = listOf(
    Diagnostic("Общий биохимический анализ крови", Date(System.currentTimeMillis() - ONE_DAY_MILLISECONDS * 4), Status.COMPLETED),
    Diagnostic("Биопсия", Date(System.currentTimeMillis() - ONE_DAY_MILLISECONDS * 7), Status.COMPLETED),
    Diagnostic("Анализ мочи", Date(System.currentTimeMillis() - ONE_DAY_MILLISECONDS * 25), Status.COMPLETED)
)

val scheduledDiagnostic = listOf(
    Diagnostic("Повторный прием врача терапевта", Date(System.currentTimeMillis() + ONE_DAY_MILLISECONDS * 4), Status.SCHEDULED),
    Diagnostic("Флюорография органов грудной клетки", Date(System.currentTimeMillis() + ONE_DAY_MILLISECONDS * 7), Status.SCHEDULED)
)

val canceled = listOf(
    Diagnostic("Прием врача терапевта", Date(System.currentTimeMillis() - ONE_DAY_MILLISECONDS * 9), Status.CANCELED)
)