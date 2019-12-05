package com.adryanev.sportsleague.data.models.api.league


import com.adryanev.sportsleague.data.models.api.league.League
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueDetailResponse(
    @Json(name = "leagues")
    var leagues: List<League?>? = null
)