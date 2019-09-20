package com.varun.demoapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.varun.demoapplication.viewmodel.LifeAtTrueCallerViewModel
import com.apps.demo.apixuweather.viewmodel.ViewModelFactory
import com.varun.demoapplication.R
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
//https://truecaller.blog/2018/01/22/life-as-an-android-engineer/
    lateinit var todaysForecastViewModel: LifeAtTrueCallerViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todaysForecastViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(LifeAtTrueCallerViewModel::class.java)
        initObservers()

        todaysForecastViewModel.loadWebPage()

    }


    private fun initObservers() {

    }


}
