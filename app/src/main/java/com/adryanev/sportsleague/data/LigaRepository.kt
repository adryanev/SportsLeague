package com.adryanev.sportsleague.data

import androidx.lifecycle.MutableLiveData
import com.adryanev.sportsleague.data.models.local.Liga

interface LigaRepository {

    fun getLiga(): MutableLiveData<List<Liga>>
}