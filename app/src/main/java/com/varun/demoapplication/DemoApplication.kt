package com.varun.demoapplication


import android.app.Activity
import android.app.Application
import com.varun.demoapplication.di.DaggerDIApplicationComponent

import com.varun.demoapplication.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DemoApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()


        val component = DaggerDIApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {

        return dispatchingAndroidInjector
    }

}