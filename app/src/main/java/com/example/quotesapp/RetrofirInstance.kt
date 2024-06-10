package com.example.quotesapp

import android.security.AppUriAuthenticationPolicy
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofirInstance {
    const val BASE_URL = "https://zenquotes.io/api/"

    private fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val quoteapi: ApiService = getInstance().create(ApiService::class.java)
}