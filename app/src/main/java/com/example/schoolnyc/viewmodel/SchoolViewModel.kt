package com.example.schoolnyc.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.schoolnyc.model.School
import com.example.schoolnyc.repository.MySchoolRepository

class SchoolViewModel(private var repository: MySchoolRepository) : ViewModel() {

    //val schools = repository.schools
    var schools = repository.getAllSchools()

}
