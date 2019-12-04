package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.League

interface ApiRepository {

    suspend fun getLeagueDetail(leagueId: Int) : List<League?>?
}