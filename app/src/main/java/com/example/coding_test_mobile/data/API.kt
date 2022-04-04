package com.example.coding_test_mobile.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("live")
    suspend fun getExchangeInfo(
        @Query("access_key") key: String = "ee50cd7cc73c9b7a7bb3d9617cfb6b9c",

        ): Response<ExchangeInfo>

}