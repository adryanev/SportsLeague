package com.adryanev.sportsleague.data

import com.adryanev.sportsleague.utils.api.Output
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

open class BaseNetworkRepository {

    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) :  T?{
        val result = sportsApiResult(call, error)
        var output : T? = null
        when(result){
            is Output.Success ->
                output = result.output
            is Output.Error -> Timber.e("The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> sportsApiResult(call: suspend()-> Response<T>, error: String) : Output<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Output.Success(response.body()!!)
        else
            Output.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}