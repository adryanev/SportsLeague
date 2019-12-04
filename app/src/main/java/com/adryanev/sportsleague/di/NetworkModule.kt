package com.adryanev.sportsleague.di

import com.adryanev.sportsleague.BuildConfig
import com.adryanev.sportsleague.data.SportsApi
import com.adryanev.sportsleague.utils.api.ResponseHandler
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideSportsApi(get()) }
    single { provideRetrofit(get())}
    factory { ResponseHandler() }
}


fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL+"/api/v1/json/${BuildConfig.TSDB_API_KEY}/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideSportsApi(retrofit: Retrofit): SportsApi = retrofit.create(
    SportsApi::class.java)