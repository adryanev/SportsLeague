package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {


    @GET("lookupleague.php")
    suspend fun getLeagueDetail(@Query("id") id: Int) : LeagueDetailResponse

}