package com.varun.demoapplication.utils

import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("2018/01/22/life-as-an-android-engineer/")
    fun getLifeAtTrueCaller(): Single<Response<String>>

    @GET("2018/01/22/life-as-an-android-engineer/")
    fun getLifeAtTrueCallerPublisher(): PublishSubject<Response<String>>

}