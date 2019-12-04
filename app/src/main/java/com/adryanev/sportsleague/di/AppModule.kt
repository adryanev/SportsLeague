package com.adryanev.sportsleague.di

import com.adryanev.sportsleague.data.ApiRepository
import com.adryanev.sportsleague.data.ApiRepositoryImpl
import com.adryanev.sportsleague.data.LigaRepository
import com.adryanev.sportsleague.data.LigaRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single<LigaRepository> { LigaRepositoryImpl() }
    single<ApiRepository> { ApiRepositoryImpl(get()) }


}