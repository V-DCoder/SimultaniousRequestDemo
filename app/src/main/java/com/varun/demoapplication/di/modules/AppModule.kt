package com.varun.demoapplication.di.modules

import android.content.Context
import com.varun.demoapplication.repository.webRepo.WebRepository
import com.varun.demoapplication.viewmodel.LifeAtTrueCallerViewModel
import com.varun.demoapplication.DemoApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(val application: DemoApplication) {

    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideViewModel(repository: WebRepository): LifeAtTrueCallerViewModel {
        return LifeAtTrueCallerViewModel(repository)
    }


}