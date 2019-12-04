package com.adryanev.sportsleague.data

import androidx.lifecycle.LiveData
import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.SportsApi

class ApiRepositoryImpl(private val sportsApi: SportsApi): ApiRepository {


    override suspend fun getLeagueDetail(leagueId: Int): LiveData<LeagueDetailResponse>  = sportsApi.getLeagueDetail(leagueId)
}