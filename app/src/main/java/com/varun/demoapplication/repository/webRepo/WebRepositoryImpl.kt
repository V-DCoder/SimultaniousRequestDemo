package com.varun.demoapplication.repository.webRepo

import com.varun.demoapplication.utils.APIService
import io.reactivex.Scheduler
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject


class WebRepositoryImpl
@Inject constructor(
    private val service: APIService, private val subscriberOn: Scheduler,
    private val observerOn: Scheduler
) : WebRepository {
    override fun getLifeAtTrueCallerPage(): Single<Response<String>> {
        return service.getLifeAtTrueCaller().subscribeOn(subscriberOn).observeOn(observerOn)
    }
}