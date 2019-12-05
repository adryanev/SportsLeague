package com.adryanev.sportsleague.ui.leaguedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository
import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.Resource

class LeagueDetailViewModel internal constructor(apiRepository: ApiRepository, private val leagueId: Int): ViewModel() {


    val detail: LiveData<Resource<LeagueDetailResponse>> = liveData { emit(apiRepository.getLeagueDetail(leagueId)) }
}
