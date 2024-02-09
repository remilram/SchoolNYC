package com.example.schoolnyc.repository

import androidx.lifecycle.MutableLiveData
import com.example.schoolnyc.model.School
import com.example.schoolnyc.model.SchoolsList
import com.example.schoolnyc.retrtoft.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MySchoolRepository {

    var schoolsList: List<School> = ArrayList<School>()
    var mutableListOfSchools = MutableLiveData<List<School>>()

    //Access Retrofit Call to retrieve the data
    fun getAllSchools(): MutableLiveData<List<School>> {
        val call = RetrofitClient.getRetrofitApiInterface()
            .getSchoolList()
        call.enqueue(object : Callback<SchoolsList> {
            override fun onResponse(call: Call<SchoolsList>, response: Response<SchoolsList>) {
                    val schools: SchoolsList? = response.body()
                    if (schools != null) {
                        schoolsList = schools
                        mutableListOfSchools.value = schoolsList
                    }
            }

            override fun onFailure(call: Call<SchoolsList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return mutableListOfSchools
    }
}