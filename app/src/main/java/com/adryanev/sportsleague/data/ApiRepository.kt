package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.Resource
import retrofit2.Response

interface ApiRepository {

    suspend fun getLeagueDetail(leagueId: Int) : Resource<LeagueDetailResponse>
}