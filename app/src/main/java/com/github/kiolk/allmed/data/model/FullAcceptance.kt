package com.github.kiolk.allmed.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class FullAcceptance(
    @Embedded
    val acceptance: Acceptance,
    @Relation(
        parentColumn = "patternId",
        entityColumn = "id_drug_pattern"
    )
    val pattern: DrugPattern?,
    @Relation(
        parentColumn = "drugId",
        entityColumn = "id_drug"
    )
    val drug: Drug?
)