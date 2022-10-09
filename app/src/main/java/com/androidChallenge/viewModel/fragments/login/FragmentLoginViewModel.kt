package com.androidChallenge.viewModel.fragments.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.repository.fragments.login.LoginRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentLoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {
    private val _userLiveData = MutableLiveData<UserEntity>()
    val userLiveData = _userLiveData

    fun getUserByEmail(email: String, password: String) {
        compositeDisposable.add(
            loginRepository
                .getUserByEmail(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (isPasswordCorrect(it, password))
                        _userLiveData.postValue(it)
                    else errorLiveData.postValue(Throwable("Wrong password"))
                }, {
                    Log.e("TAG", "getUserData: Error $it")
                    errorLiveData.postValue(it)
                })
        )
    }

    private fun isPasswordCorrect(userEntity: UserEntity, password: String) =
        password == userEntity.password

}