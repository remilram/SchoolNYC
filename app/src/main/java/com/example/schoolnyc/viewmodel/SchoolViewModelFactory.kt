package com.example.schoolnyc.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.schoolnyc.repository.MySchoolRepository
import java.lang.IllegalArgumentException

class SchoolViewModelFactory(private var repository: MySchoolRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SchoolViewModel::class.java))
            return SchoolViewModel(repository) as T
        throw IllegalArgumentException("Unknown View Model class")
    }

}