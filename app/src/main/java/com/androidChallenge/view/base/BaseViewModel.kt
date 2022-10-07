package com.androidChallenge.view.base

import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*


open class BaseViewModel(
    private val mCompositeDisposable: CompositeDisposable
) : ViewModel() {

    var disposable: HashMap<Int, Disposable?> = HashMap()
    var errorLiveData = MutableLiveData<Throwable>()



    fun addDisposable(disposable: Disposable?) {
        disposable?.let {
            this.mCompositeDisposable.add(it)
        }
    }



    override fun onCleared() {
        this.mCompositeDisposable.dispose()
        super.onCleared()
    }





}
