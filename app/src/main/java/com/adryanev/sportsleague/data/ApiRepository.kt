package com.adryanev.sportsleague.data

import androidx.lifecycle.LiveData
import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse

interface ApiRepository {

    suspend fun getLeagueDetail(leagueId: Int) : LiveData<LeagueDetailResponse>
}