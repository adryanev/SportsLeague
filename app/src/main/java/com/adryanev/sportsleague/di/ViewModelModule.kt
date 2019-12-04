package com.adryanev.sportsleague.di

import com.adryanev.sportsleague.ui.home.HomeViewModel
import com.adryanev.sportsleague.ui.leaguedetail.LeagueDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel{ LeagueDetailViewModel(get(),getProperty("leagueId")) }
}