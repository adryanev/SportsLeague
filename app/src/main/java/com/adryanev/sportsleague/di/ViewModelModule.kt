package com.adryanev.sportsleague.di

import com.adryanev.sportsleague.ui.detailmatch.DetailMatchViewModel
import com.adryanev.sportsleague.ui.detailviewpager.DetailViewPagerViewModel
import com.adryanev.sportsleague.ui.home.HomeViewModel
import com.adryanev.sportsleague.ui.nextmatch.NextMatchViewModel
import com.adryanev.sportsleague.ui.previousmatch.PreviousMatchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel {
        DetailViewPagerViewModel(
            get(),
            getProperty("leagueId"),
            getProperty("leagueImage")
        )
    }
    viewModel { NextMatchViewModel(get(), getProperty("leagueId")) }
    viewModel { PreviousMatchViewModel(get(), getProperty("leagueId")) }
    viewModel { DetailMatchViewModel(get(), getProperty("eventId")) }
}