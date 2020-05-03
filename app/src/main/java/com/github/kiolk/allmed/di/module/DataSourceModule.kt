package com.github.kiolk.allmed.di.module

import com.github.kiolk.allmed.data.datasource.dragpattern.DefaultDrugPatternRepository
import com.github.kiolk.allmed.data.datasource.drug.DefaultDrugRepository
import com.github.kiolk.allmed.data.datasource.drug.DragRepository
import com.github.kiolk.allmed.data.datasource.drug.DrugDataSource
import com.github.kiolk.allmed.data.datasource.dragpattern.DrugPatternDataSource
import com.github.kiolk.allmed.data.datasource.dragpattern.DrugPatternRepository
import com.github.kiolk.allmed.data.datasource.dragpattern.local.LocalDrugPatternDataSource
import com.github.kiolk.allmed.data.datasource.drug.local.LocalDrugDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    //drug
    single<DrugDataSource> { LocalDrugDataSource(get()) }
    single<DragRepository> { DefaultDrugRepository(get()) }

    //drugPattern
    single<DrugPatternDataSource> { LocalDrugPatternDataSource(get(), get()) }
    single<DrugPatternRepository> { DefaultDrugPatternRepository(get()) }
}