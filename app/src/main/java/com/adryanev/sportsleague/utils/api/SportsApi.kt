package com.adryanev.sportsleague.utils.api

import androidx.lifecycle.LiveData
import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {


    @GET("/lookupleague.php")
    suspend fun getLeagueDetail(@Query("id") id: Int) : LiveData<LeagueDetailResponse>

}