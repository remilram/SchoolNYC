package com.example.schoolnyc

import com.example.schoolnyc.adapter.SchoolAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolnyc.databinding.ActivityMainBinding
import com.example.schoolnyc.model.School
import com.example.schoolnyc.repository.MySchoolRepository
import com.example.schoolnyc.viewmodel.SchoolViewModel
import com.example.schoolnyc.viewmodel.SchoolViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : SchoolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = MySchoolRepository()

        val factory = SchoolViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(SchoolViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //Recycler

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.schools.observe(this) {
            binding.recyclerView.adapter = SchoolAdapter(it) {school : School -> schoolSelected(school)}
        }


    }

    private fun schoolSelected(school: School) {
        // Intent go to new activity
        Toast.makeText(this, "School Phone Number is ${school.phone_number}",Toast.LENGTH_SHORT).show()

    }
}