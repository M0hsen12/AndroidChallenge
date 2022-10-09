package com.androidChallenge.viewModel.fragments.details

import androidx.lifecycle.ViewModel
import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.repository.fragments.details.DetailsRepository
import com.androidChallenge.repository.fragments.home.HomeRepository
import com.androidChallenge.view.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FragmentDetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {

    var imagesItem = HitsItem()

    fun setImageItem(hitsItem: HitsItem) { //for surviving the rotation
        this.imagesItem = hitsItem
    }

    fun getImageItem() = imagesItem
}