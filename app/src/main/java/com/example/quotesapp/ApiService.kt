package com.example.quotesapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("random")
    suspend fun getQuote(): Response<Quote>
}