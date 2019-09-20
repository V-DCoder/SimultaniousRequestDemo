package com.varun.demoapplication.viewmodel

import android.location.Address
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.varun.demoapplication.repository.webRepo.WebRepository
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Response
import javax.inject.Inject

class LifeAtTrueCallerViewModel @Inject constructor(
    val repository: WebRepository
) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    private var errorFound: MutableLiveData<Boolean> = MutableLiveData()
    private var showProgress: MutableLiveData<Boolean> = MutableLiveData()

    private var address: Address? = null


    fun getProgressDialogLiveData(): LiveData<Boolean> {
        return showProgress
    }

    fun getErrorLiveData(): LiveData<Boolean> {
        return errorFound
    }

    fun loadWebPage() {

        compositeDisposable.add(repository.getLifeAtTrueCallerPage().subscribe({ onSuccess(it) }, { onFailuar(it) }))
    }

    private fun onSuccess(it: Response<String>?) {

    }

    private fun onFailuar(it: Throwable?) {

    }


}