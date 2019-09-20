package com.varun.demoapplication.repository.webRepo

import io.reactivex.Single
import retrofit2.Response

interface WebRepository {

    fun getLifeAtTrueCallerPage(): Single<Response<String>>
}