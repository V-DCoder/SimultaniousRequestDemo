package com.varun.demoapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.apps.demo.apixuweather.viewmodel.TodaysForecastViewModel
import com.apps.demo.apixuweather.viewmodel.ViewModelFactory
import com.varun.demoapplication.R
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
//https://truecaller.blog/2018/01/22/life-as-an-android-engineer/
    lateinit var todaysForecastViewModel: TodaysForecastViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todaysForecastViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(TodaysForecastViewModel::class.java)
        initObservers()


    }


    private fun initObservers() {

    }


}
