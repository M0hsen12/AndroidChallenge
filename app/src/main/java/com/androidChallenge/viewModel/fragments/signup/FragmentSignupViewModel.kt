package com.androidChallenge.viewModel.fragments.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.repository.fragments.signup.SignupRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentSignupViewModel @Inject constructor(
    private val signupRepository: SignupRepository,
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable){
    private val _userRegistrationResultLiveData = MutableLiveData<Long>()
    val userRegistrationResultLiveData = _userRegistrationResultLiveData


    fun registerUser(userEntity: UserEntity) {
        compositeDisposable.add(
            signupRepository
                .insertUser(userEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _userRegistrationResultLiveData.postValue(it)
                }, {
                    errorLiveData.postValue(it)
                })
        )

    }

}