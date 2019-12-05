package com.adryanev.sportsleague.data.models.api.event


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Event(
    @Json(name = "dateEvent")
    var dateEvent: String? = null,
    @Json(name = "dateEventLocal")
    var dateEventLocal: String? = null,
    @Json(name = "idAwayTeam")
    var idAwayTeam: String? = null,
    @Json(name = "idEvent")
    var idEvent: String? = null,
    @Json(name = "idHomeTeam")
    var idHomeTeam: String? = null,
    @Json(name = "idLeague")
    var idLeague: String? = null,
    @Json(name = "idSoccerXML")
    var idSoccerXML: String? = null,
    @Json(name = "intAwayScore")
    var intAwayScore: String? = null,
    @Json(name = "intAwayShots")
    var intAwayShots: String? = null,
    @Json(name = "intHomeScore")
    var intHomeScore: String? = null,
    @Json(name = "intHomeShots")
    var intHomeShots: String? = null,
    @Json(name = "intRound")
    var intRound: String? = null,
    @Json(name = "intSpectators")
    var intSpectators: String? = null,
    @Json(name = "strAwayFormation")
    var strAwayFormation: String? = null,
    @Json(name = "strAwayGoalDetails")
    var strAwayGoalDetails: String? = null,
    @Json(name = "strAwayLineupDefense")
    var strAwayLineupDefense: String? = null,
    @Json(name = "strAwayLineupForward")
    var strAwayLineupForward: String? = null,
    @Json(name = "strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: String? = null,
    @Json(name = "strAwayLineupMidfield")
    var strAwayLineupMidfield: String? = null,
    @Json(name = "strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: String? = null,
    @Json(name = "strAwayRedCards")
    var strAwayRedCards: String? = null,
    @Json(name = "strAwayTeam")
    var strAwayTeam: String? = null,
    @Json(name = "strAwayYellowCards")
    var strAwayYellowCards: String? = null,
    @Json(name = "strBanner")
    var strBanner: String? = null,
    @Json(name = "strCircuit")
    var strCircuit: String? = null,
    @Json(name = "strCity")
    var strCity: String? = null,
    @Json(name = "strCountry")
    var strCountry: String? = null,
    @Json(name = "strDate")
    var strDate: String? = null,
    @Json(name = "strDescriptionEN")
    var strDescriptionEN: String? = null,
    @Json(name = "strEvent")
    var strEvent: String? = null,
    @Json(name = "strEventAlternate")
    var strEventAlternate: String? = null,
    @Json(name = "strFanart")
    var strFanart: String? = null,
    @Json(name = "strFilename")
    var strFilename: String? = null,
    @Json(name = "strHomeFormation")
    var strHomeFormation: String? = null,
    @Json(name = "strHomeGoalDetails")
    var strHomeGoalDetails: String? = null,
    @Json(name = "strHomeLineupDefense")
    var strHomeLineupDefense: String? = null,
    @Json(name = "strHomeLineupForward")
    var strHomeLineupForward: String? = null,
    @Json(name = "strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: String? = null,
    @Json(name = "strHomeLineupMidfield")
    var strHomeLineupMidfield: String? = null,
    @Json(name = "strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: String? = null,
    @Json(name = "strHomeRedCards")
    var strHomeRedCards: String? = null,
    @Json(name = "strHomeTeam")
    var strHomeTeam: String? = null,
    @Json(name = "strHomeYellowCards")
    var strHomeYellowCards: String? = null,
    @Json(name = "strLeague")
    var strLeague: String? = null,
    @Json(name = "strLocked")
    var strLocked: String? = null,
    @Json(name = "strMap")
    var strMap: String? = null,
    @Json(name = "strPoster")
    var strPoster: String? = null,
    @Json(name = "strResult")
    var strResult: String? = null,
    @Json(name = "strSeason")
    var strSeason: String? = null,
    @Json(name = "strSport")
    var strSport: String? = null,
    @Json(name = "strTVStation")
    var strTVStation: String? = null,
    @Json(name = "strThumb")
    var strThumb: String? = null,
    @Json(name = "strTime")
    var strTime: String? = null,
    @Json(name = "strTimeLocal")
    var strTimeLocal: String? = null,
    @Json(name = "strTweet1")
    var strTweet1: String? = null,
    @Json(name = "strTweet2")
    var strTweet2: String? = null,
    @Json(name = "strTweet3")
    var strTweet3: String? = null,
    @Json(name = "strVideo")
    var strVideo: String? = null
)