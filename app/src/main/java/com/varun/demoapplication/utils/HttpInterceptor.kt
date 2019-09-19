package com.apps.demo.apixuweather.utils


import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val oldRequest = chain.request()
        val updatedURL = oldRequest.url().newBuilder()

            .addEncodedQueryParameter("days","4")
            .build()
        return chain.proceed(oldRequest.newBuilder().url(updatedURL).build())
    }
}