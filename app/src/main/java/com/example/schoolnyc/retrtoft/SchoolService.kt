package com.example.schoolnyc.retrtoft

import com.example.schoolnyc.model.SchoolsList
import retrofit2.Call
import retrofit2.http.GET

interface SchoolService {

    @GET("s3k6-pzi2.json")
    fun getSchoolList() : Call<SchoolsList>
}