package com.example.schoolnyc.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

typealias SchoolsList = List<School>;

data class School(
    @SerializedName("school_name")
    @Expose
    val name: String,

    @SerializedName("dbn")
    @Expose
    val dbn: String,

    @SerializedName("phone_number")
    @Expose
    val phone_number : String
)