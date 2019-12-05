package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.Resource

interface ApiRepository {

    suspend fun getLeagueDetail(leagueId: Int) : Resource<LeagueDetailResponse>
}