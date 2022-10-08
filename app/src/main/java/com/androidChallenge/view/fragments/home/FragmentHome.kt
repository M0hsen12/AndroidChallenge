package com.androidChallenge.view.fragments.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentDetailsBinding
import com.androidChallenge.databinding.FragmentHomeBinding
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.details.FragmentDetailsViewModel
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel
import javax.inject.Inject

class FragmentHome : BaseFragment<FragmentHomeBinding, FragmentHomeViewModel>(){


    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentHomeViewModel>
    override fun getLayoutId() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    companion object {
        fun newInstance() = FragmentHome()
    }
}