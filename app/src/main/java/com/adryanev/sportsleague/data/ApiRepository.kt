package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.event.EventResponse
import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.data.models.api.team.TeamResponse
import com.adryanev.sportsleague.utils.api.Resource

interface ApiRepository {

    suspend fun getLeagueDetail(leagueId: Int): Resource<LeagueDetailResponse>
    suspend fun getNextMatch(leagueId: Int): Resource<EventResponse>
    suspend fun getPreviousMatch(leagueId: Int): Resource<EventResponse>
    suspend fun getTeamDetail(teamId: Int): Resource<TeamResponse>
    suspend fun getEventDetail(eventId: Int): Resource<EventResponse>
}