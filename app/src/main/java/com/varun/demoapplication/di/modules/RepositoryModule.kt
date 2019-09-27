package com.varun.demoapplication.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.varun.demoapplication.repository.RepositoryImpl
import com.varun.demoapplication.repository.webRepo.WebRepository
import com.varun.demoapplication.repository.webRepo.WebRepositoryImpl
import com.varun.demoapplication.utils.APIService
import com.varun.demoapplication.utils.ConverterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    fun provideRepository(webRepository: WebRepository): RepositoryImpl {
        return RepositoryImpl(webRepository)
    }

    @Provides
    fun provideForcastRepository(
        APIService: APIService, @Named(SUBCRIBER_ON) subscriberOn: Scheduler,
        @Named(OBSERVER_ON) observerOn: Scheduler
    ): WebRepository {
        return WebRepositoryImpl(APIService, subscriberOn, observerOn)
    }


    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
        return builder
            .build()

    }


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ConverterFactory())
            .baseUrl(getBaseUrl())
            .client(okHttpClient)
            .build()
    }

    protected fun getBaseUrl(): String {
        return "https://truecaller.blog/"
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }


}