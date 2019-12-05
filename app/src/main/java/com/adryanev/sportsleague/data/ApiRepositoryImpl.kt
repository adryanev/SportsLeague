package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.ResponseHandler
import java.lang.Exception

class ApiRepositoryImpl(private val sportsApi: SportsApi, val responseHandler: ResponseHandler): ApiRepository {


    override suspend fun getLeagueDetail(leagueId: Int): Resource<LeagueDetailResponse> {
        return try{
            val response = sportsApi.getLeagueDetail(leagueId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }
}