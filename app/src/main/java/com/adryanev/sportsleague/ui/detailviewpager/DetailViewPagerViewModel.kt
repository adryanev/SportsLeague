package com.adryanev.sportsleague.ui.detailviewpager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository
import java.lang.reflect.Constructor

class DetailViewPagerViewModel internal constructor (apiRepository: ApiRepository,private val leagueId: Int, private val leagueImage: String): ViewModel() {

    val leagueDetail = liveData { emit(apiRepository.getLeagueDetail(leagueId)) }



}