package com.apps.demo.apixuweather.di

import com.apps.demo.apixuweather.di.modules.AppModule
import com.apps.demo.apixuweather.di.modules.RepositoryModule
import com.apps.demo.apixuweather.di.modules.RxJavaSchedulersModule
import com.varun.demoapplication.WeatherForecastApplication
import com.varun.demoapplication.di.modules.ActivityProvideModule
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

    fun inject(application: WeatherForecastApplication)


}