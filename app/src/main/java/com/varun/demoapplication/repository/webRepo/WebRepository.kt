package com.varun.demoapplication.repository.webRepo

import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import retrofit2.Response

interface WebRepository {

    fun getLifeAtTrueCallerPage(): Single<Response<String>>
    fun getLifeAtTrueCallerPagePublisher(): PublishSubject<Response<String>>
}