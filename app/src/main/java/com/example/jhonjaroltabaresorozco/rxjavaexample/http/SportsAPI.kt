package com.example.jhonjaroltabaresorozco.rxjavaexample.http

import com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel.Sports
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel.Teams
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface SportsAPI {

    @GET("all_sports.php")
    fun getAllSportsCall(): Call<Sports>

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    fun getAllSports(): Observable<Teams>

}