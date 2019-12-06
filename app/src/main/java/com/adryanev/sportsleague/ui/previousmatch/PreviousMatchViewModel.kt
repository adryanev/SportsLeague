package com.adryanev.sportsleague.ui.previousmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository

class PreviousMatchViewModel internal constructor(apiRepository: ApiRepository, private val leagueId:Int): ViewModel() {
    val previousMatch = liveData { emit(apiRepository.getPreviousMatch(leagueId)) }

}
