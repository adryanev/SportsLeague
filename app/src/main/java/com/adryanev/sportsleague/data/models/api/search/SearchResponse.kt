package com.adryanev.sportsleague.data.models.api.search


import com.adryanev.sportsleague.data.models.api.event.Event
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "event")
    var event: List<Event?>? = null
)