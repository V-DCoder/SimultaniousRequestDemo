package com.apps.demo.apixuweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.varun.demoapplication.viewmodel.LifeAtTrueCallerViewModel
import javax.inject.Inject


class ViewModelFactory @Inject constructor(var forecastViewModel: LifeAtTrueCallerViewModel) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel: ViewModel
        if (modelClass == LifeAtTrueCallerViewModel::class.java) {
            viewModel = forecastViewModel
        } else {
            throw RuntimeException("unsupported view model class: $modelClass this factory is designed to work with 1 class only")
        }

        return viewModel as T
    }


}