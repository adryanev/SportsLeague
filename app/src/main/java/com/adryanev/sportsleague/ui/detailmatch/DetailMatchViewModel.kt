package com.adryanev.sportsleague.ui.detailmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adryanev.sportsleague.data.ApiRepository

class DetailMatchViewModel internal constructor(
    apiRepository: ApiRepository,
    private val eventId: Int
) : ViewModel() {

    val evetDetail = liveData { emit(apiRepository.getEventDetail(eventId)) }
}
