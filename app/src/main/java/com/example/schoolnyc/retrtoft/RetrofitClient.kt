package com.example.schoolnyc.retrtoft

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofitInstance: SchoolService? = null
    private const val BASE_URL = "https://data.cityofnewyork.us/resource/"

    fun getRetrofitApiInterface() : SchoolService {
        if (retrofitInstance == null) {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(SchoolService::class.java)
        }
        return retrofitInstance
    }
}