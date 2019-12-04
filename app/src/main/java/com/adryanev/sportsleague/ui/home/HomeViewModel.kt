package com.adryanev.sportsleague.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adryanev.sportsleague.data.LigaRepository
import com.adryanev.sportsleague.data.LigaRepositoryImpl
import com.adryanev.sportsleague.data.models.local.Liga

class HomeViewModel internal constructor(ligaRepository: LigaRepository): ViewModel() {

    val liga :LiveData<List<Liga>> = ligaRepository.getLiga()
}