package com.androidChallenge.viewmodel.fragments.home

import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.viewmodel.fragments.home.FakeHomeViewModel.Companion.EXCEPTION_MSG
import com.androidChallenge.viewmodel.fragments.home.FakeHomeViewModel.Companion.THROW_EXCEPTION_ID
import org.junit.Assert
import org.junit.Test

/*
1.getImageList_success_ConfirmData
2.getDriverList_success_EssentialItemIsNotEmpty
3.getImageList_Failed_confirmData
4.getImageList_Failed_throwException

 */

class HomeViewModelTest {
    // SYSTEM IN CHECK
    // HomeViewModel

    //Dependencies
    private var viewModel :FakeHomeViewModel
    private var imagesList:List<HitsItem>
    init {
        viewModel = FakeHomeViewModel()
        viewModel.build()
        imagesList  = viewModel.getImageList()
    }

    @Test
    fun getImageList_success_ConfirmData() {
        val list = imagesList
        assert(list.isNotEmpty())

    }

    @Test
    fun getDriverList_success_EssentialItemIsNotEmpty() {
        val list = imagesList
        assert(list.isNotEmpty())
        list.forEach {
            assert(it.user.isNotEmpty())
            assert(it.previewURL.isNotEmpty())
            assert(it.id != 0)
        }
    }

    @Test
    fun getDriverList_Failed_confirmEmptyData() {

        val list = emptyList<HitsItem>()
        assert(list.isEmpty())
        list.forEach {
            assert(it.user.isEmpty())
            assert(it.previewURL.isEmpty())
            assert(it.id == 0)
        }
    }
    @Test
    fun getDriverList_Failed_throwException() {
        viewModel.setUpImageForException()
        val expectedMessage = "Exception on method"
        val list = imagesList
        list.find { it.id != THROW_EXCEPTION_ID }
        val throwable = Assert.assertThrows(java.lang.IllegalArgumentException::class.java) {
            list.forEach {
                if (it.id != THROW_EXCEPTION_ID)
                    throw IllegalArgumentException(EXCEPTION_MSG)
            }
        }

        assert(throwable.message == expectedMessage)

    }
}