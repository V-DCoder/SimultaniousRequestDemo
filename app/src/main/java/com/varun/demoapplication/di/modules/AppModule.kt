package com.apps.demo.apixuweather.di.modules

import android.content.Context
import com.apps.demo.apixuweather.location.LocationManager
import com.apps.demo.apixuweather.repository.weatherAPIRepo.ForecastRepository
import com.apps.demo.apixuweather.viewmodel.TodaysForecastViewModel
import com.varun.demoapplication.WeatherForecastApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(val application: WeatherForecastApplication) {

    @Provides
    fun provideContext(): Context {
        return application
    }


    @Provides
    fun provideLocationManager(context: Context): LocationManager {
        return LocationManager(context)
    }

    @Provides
    fun provideViewModel( repository: ForecastRepository): TodaysForecastViewModel {
        return TodaysForecastViewModel( repository)
    }


}