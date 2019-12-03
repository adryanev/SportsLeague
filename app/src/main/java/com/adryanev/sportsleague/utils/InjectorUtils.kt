package com.adryanev.sportsleague.utils

import android.content.Context
import com.adryanev.sportsleague.data.LigaRepository
import com.adryanev.sportsleague.ui.home.HomeViewModelFactory

object InjectorUtils {

    private fun getLigaRepository() : LigaRepository{
        return LigaRepository.getInstance()
    }


    fun provideHomeViewModelFactory() : HomeViewModelFactory{
        val repository = getLigaRepository()
        return HomeViewModelFactory(repository)
    }

}