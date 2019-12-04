package com.adryanev.sportsleague.data.models.api


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeagueDetailResponse(
    @Json(name = "leagues")
    var leagues: List<League?>? = null
)