package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.event.EventResponse
import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.data.models.api.search.SearchResponse
import com.adryanev.sportsleague.data.models.api.team.TeamResponse
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.ResponseHandler

class ApiRepositoryImpl(private val sportsApi: SportsApi, val responseHandler: ResponseHandler) :
    ApiRepository {


    override suspend fun getLeagueDetail(leagueId: Int): Resource<LeagueDetailResponse> {
        return try {
            val response = sportsApi.getLeagueDetail(leagueId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getNextMatch(leagueId: Int): Resource<EventResponse> {
        return try {
            val response = sportsApi.getNextMatch(leagueId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getPreviousMatch(leagueId: Int): Resource<EventResponse> {
        return try {
            val response = sportsApi.getPreviousMatch(leagueId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }

    }

    override suspend fun getTeamDetail(teamId: Int): Resource<TeamResponse> {
        return try {
            val response = sportsApi.getTeamById(teamId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getEventDetail(eventId: Int): Resource<EventResponse> {
        return try {
            val response = sportsApi.getEventDetail(eventId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun searchEvent(query: String): Resource<SearchResponse> {
        return try {
            val response = sportsApi.searchEvent(query)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}