package com.adryanev.sportsleague.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adryanev.sportsleague.data.LigaRepository

class HomeViewModelFactory(private val repository: LigaRepository):
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) = HomeViewModel(repository) as T
}