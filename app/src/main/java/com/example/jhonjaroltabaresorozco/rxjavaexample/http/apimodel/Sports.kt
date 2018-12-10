package com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sports {

    @SerializedName("sports")
    @Expose
    var sports: List<Sports>? = null

}