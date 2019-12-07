package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.event.EventResponse
import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.data.models.api.team.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {


    @GET("lookupleague.php")
    suspend fun getLeagueDetail(@Query("id") id: Int): LeagueDetailResponse

    @GET("eventsnextleague.php")
    suspend fun getNextMatch(@Query("id") idLeague: Int): EventResponse

    @GET("eventspastleague.php")
    suspend fun getPreviousMatch(@Query("id") idLeague: Int): EventResponse

    @GET("lookupevent.php")
    suspend fun getEventDetail(@Query("id") idLeague: Int): EventResponse

    @GET("lookupteam.php")
    suspend fun getTeamById(@Query("id") idTeam: Int): TeamResponse
}