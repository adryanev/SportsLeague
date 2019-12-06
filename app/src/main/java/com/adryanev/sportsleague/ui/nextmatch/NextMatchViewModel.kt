package com.adryanev.sportsleague.ui.nextmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository

class NextMatchViewModel internal constructor(apiRepository: ApiRepository, private val leagueId: Int) : ViewModel() {
    val nextMatch = liveData { emit(apiRepository.getNextMatch(leagueId)) }
}
