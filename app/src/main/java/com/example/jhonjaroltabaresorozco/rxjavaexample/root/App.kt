package com.example.jhonjaroltabaresorozco.rxjavaexample.root

import android.app.Application
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.ApiModule

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    //
    private fun initDagger(app: App): ApplicationComponent =
            DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(app))
                .apiModule(ApiModule())
                .build()

    override fun onCreate(){
        super.onCreate()
        applicationComponent = initDagger(this)



    }

}