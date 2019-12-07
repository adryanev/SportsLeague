package com.adryanev.sportsleague.ui.search

import androidx.lifecycle.*
import com.adryanev.sportsleague.data.ApiRepository
import com.adryanev.sportsleague.data.models.api.search.SearchResponse
import com.adryanev.sportsleague.utils.api.Resource

class SearchViewModel internal constructor(val apiRepository: ApiRepository) : ViewModel() {

    val query = MutableLiveData<String>()

    val searchResult: LiveData<Resource<SearchResponse>> = query.switchMap {
        liveData {
            val data = apiRepository.searchEvent(it)
            emit(data)
        }
    }


}
