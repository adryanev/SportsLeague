package com.adryanev.sportsleague.ui.leaguedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository
import com.adryanev.sportsleague.data.models.api.League

class LeagueDetailViewModel internal constructor(apiRepository: ApiRepository, private val leagueId: Int): ViewModel() {


    val detail: LiveData<List<League?>?> = liveData { emit(apiRepository.getLeagueDetail(leagueId)) }
}
