package com.example.jhonjaroltabaresorozco.rxjavaexample.root

import com.example.jhonjaroltabaresorozco.rxjavaexample.activities.MainActivity
import com.example.jhonjaroltabaresorozco.rxjavaexample.http.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {

    fun inject(target: MainActivity)

}