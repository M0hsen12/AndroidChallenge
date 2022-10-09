package com.androidChallenge.viewModel.fragments.home

import android.util.Log
import android.util.Pair
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidChallenge.BuildConfig
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.models.images.Image
import com.androidChallenge.repository.fragments.home.HomeRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FragmentHomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {

    private val _imagesLiveData = MutableLiveData<Image>()
    val imagesLiveData = _imagesLiveData
    private val paginationSearch = BehaviorSubject.createDefault(FIRST_PAGE)
    fun getImages() {

        compositeDisposable.add(
            paginationSearch.flatMapSingle {
                homeRepository.getImages(
                    BuildConfig.API_KEY,
                    IMAGE_QUERY,
                    IMAGE_TYPE,
                    JSON_PRETTY,
                    IMAGE_PER_PAGE,
                    it
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _imagesLiveData.postValue(it)
                }, {
                    errorLiveData.postValue(it)

                })
        )


    }

    fun nextPageImage(page: Int) {
        paginationSearch.onNext(page)
    }

    companion object {
        const val FIRST_PAGE = 1
        const val IMAGE_PER_PAGE = 22
        const val JSON_PRETTY = "true"
        const val IMAGE_TYPE = "photo"
        const val IMAGE_QUERY = "image"
    }
}