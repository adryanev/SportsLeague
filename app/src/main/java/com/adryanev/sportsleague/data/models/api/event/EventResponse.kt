package com.adryanev.sportsleague.data.models.api.event


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventResponse(
    @Json(name = "events")
    var events: List<Event?>? = null
)