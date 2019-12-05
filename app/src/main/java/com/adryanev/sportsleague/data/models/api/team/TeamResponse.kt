package com.adryanev.sportsleague.data.models.api.team


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamResponse(
    @Json(name = "teams")
    var teams: List<Team?>? = null
)