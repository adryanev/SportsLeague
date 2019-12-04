package com.adryanev.sportsleague.utils.api

import java.lang.Exception

sealed class Output<out T: Any> {
    data class Success<out T: Any>(val output: T):Output<T>()
    data class Error(val exception: Exception): Output<Nothing>()
}