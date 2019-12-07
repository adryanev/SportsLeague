package com.adryanev.sportsleague.ui.detailmatch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.adryanev.sportsleague.data.ApiRepository
import com.adryanev.sportsleague.data.models.api.team.Team
import kotlinx.coroutines.launch

class DetailMatchViewModel internal constructor(
    private val apiRepository: ApiRepository,
    private val eventId: Int
) : ViewModel() {

    var teamHome = MutableLiveData<Team>()
    var teamAway = MutableLiveData<Team>()

    val evetDetail = liveData { emit(apiRepository.getEventDetail(eventId)) }


    fun getTeamHome(id: Int) {

        viewModelScope.launch {
            val response = apiRepository.getTeamDetail(id)
            teamHome.value = response.data?.teams?.get(0)
        }
    }

    fun getTeamAway(id: Int) {

        viewModelScope.launch {
            val response = apiRepository.getTeamDetail(id)
            teamAway.value = response.data?.teams?.get(0)
        }
    }


}
