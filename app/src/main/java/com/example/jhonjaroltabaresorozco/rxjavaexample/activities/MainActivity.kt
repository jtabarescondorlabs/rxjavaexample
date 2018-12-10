package com.example.jhonjaroltabaresorozco.rxjavaexample.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.jhonjaroltabaresorozco.rxjavaexample.R
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.SportsAPI
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel.Sports
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel.Team
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel.Teams
import com.example.jhonjaroltabaresorozco.rxjavaexample.root.App
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var jsonAPI: SportsAPI

    @Inject
    lateinit var api: SportsAPI

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).applicationComponent.inject(this)

        val call = api.getAllSportsCall()

        call.enqueue(object : Callback<Sports> {
            override fun onResponse(call: Call<Sports>, response: Response<Sports>) {
                val gameList = response.body()?.sports

                for (top in gameList!!) {
                    System.out.println(top.sports)
                }
            }

            override fun onFailure(call: Call<Sports>, t: Throwable) {
                t.printStackTrace()
            }
        })

        val callJson = jsonAPI.getAllSports()

        callJson.flatMap(object : Function<Teams, Observable<Team>>{
            override fun apply(t: Teams): Observable<Team> {
                return Observable.fromArray()
            }

        })


        callJson.flatMap(object : Function<Teams, Observable<Team>> {
            override fun apply(t: Teams): Observable<Team> {
                return Observable.fromIterable(t.teams)
            }
            }).flatMap(object : Function<Team, Observable<String>>{
            override fun apply(t: Team): Observable<String> {
                return Observable.just(t.idTeam + t.idLeague + t.strAlternate)
            }

        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onNext(t: String) {
                    Log.d("single response", "" + "" + t)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }


            })

    }

}
