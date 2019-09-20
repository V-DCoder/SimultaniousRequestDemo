package com.varun.demoapplication.di

import com.varun.demoapplication.DemoApplication
import com.varun.demoapplication.di.modules.ActivityProvideModule
import com.varun.demoapplication.di.modules.AppModule
import com.varun.demoapplication.di.modules.RepositoryModule
import com.varun.demoapplication.di.modules.RxJavaSchedulersModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AppModule::class,
        RepositoryModule::class,
        AndroidSupportInjectionModule::class,
        RxJavaSchedulersModule::class,
        ActivityProvideModule::class
    )
)
interface WeatherForecastApplicationComponent {

    fun inject(application: DemoApplication)


}