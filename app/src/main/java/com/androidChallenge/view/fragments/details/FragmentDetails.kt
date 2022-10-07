package com.androidChallenge.view.fragments.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentDetailsBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.details.FragmentDetailsViewModel
import javax.inject.Inject
@BindModule
class FragmentDetails : BaseFragment<FragmentDetailsBinding,FragmentDetailsViewModel>(){

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentDetailsViewModel>
    override fun getLayoutId() = R.layout.fragment_details


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    companion object {
        fun newInstance() = FragmentDetails()
    }

}