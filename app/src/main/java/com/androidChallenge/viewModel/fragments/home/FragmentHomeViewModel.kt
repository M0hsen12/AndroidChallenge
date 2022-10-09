package com.androidChallenge.viewModel.fragments.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.repository.fragments.home.HomeRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentHomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {

    private val _userLiveData = MutableLiveData<List<UserEntity>>()
    val userLiveData = _userLiveData


    fun getUserData() {
        compositeDisposable.add(
            homeRepository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.e("TAG", "getUserData: ${it.size}" )
                    _userLiveData.postValue(it)
                }, {
                    Log.e("TAG", "getUserData: Error $it" )
                    errorLiveData.postValue(it)
                })
        )
    }

}