package com.example.jhonjaroltabaresorozco.rxjavaexample.http.apimodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sport {

    @SerializedName("idSport")
    @Expose
    var idSport: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("strSportThumb")
    @Expose
    var strSportThumb: String? = null
    @SerializedName("strSportDescription")
    @Expose
    var strSportDescription: String? = null

    constructor(idSport: String?, strSport: String?, strSportThumb: String?,
                strSportDescription: String?) {
        this.idSport = idSport
        this.strSport = strSport
        this.strSportThumb = strSportThumb
        this.strSportDescription = strSportDescription
    }
}