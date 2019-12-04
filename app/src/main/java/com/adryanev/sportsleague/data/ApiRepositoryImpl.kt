package com.adryanev.sportsleague.data

import androidx.lifecycle.LiveData
import com.adryanev.sportsleague.data.models.api.League
import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.SportsApi

class ApiRepositoryImpl(private val sportsApi: SportsApi): BaseNetworkRepository(), ApiRepository {


    override suspend fun getLeagueDetail(leagueId: Int): List<League?>? {
        return  safeApiCall(
            call = {
                sportsApi.getLeagueDetail(leagueId).await()
            },
            error = "Gagal Mendapatkan Data Liga"
        )?.leagues?.toList()
    }
}