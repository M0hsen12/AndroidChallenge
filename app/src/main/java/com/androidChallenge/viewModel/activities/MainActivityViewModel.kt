package com.androidChallenge.viewModel.activities

import android.util.Log
import com.androidChallenge.repository.activities.MainActivityRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    mainActivityRepository: MainActivityRepository,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {
    init {
        Log.e("TAG", "mainActivity viewModel is initialized $mainActivityRepository")
    }
}