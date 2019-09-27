package com.varun.demoapplication.viewmodel

import android.location.Address
import android.util.Log
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

        compositeDisposable.add(repository.getLifeAtTrueCallerPage()
            .toObservable()
            .subscribe({ onSuccess(it) }, { onFailuar(it) })
        )


    }

    private fun onSuccess(it: Response<String>?) {
        val str = it?.body()?.filterIndexedTo(StringBuilder(), { i, c -> i % 10 == 0 }).toString()
        Log.w("", str)
        Log.w("response",it?.body().toString())
    }

    private fun onFailuar(it: Throwable?) {
        it?.printStackTrace()
    }


}