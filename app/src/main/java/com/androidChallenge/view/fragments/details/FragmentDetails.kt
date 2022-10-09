package com.androidChallenge.view.fragments.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentDetailsBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.details.FragmentDetailsViewModel
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel
import com.bumptech.glide.Glide
import javax.inject.Inject

@BindModule
class FragmentDetails : BaseFragment<FragmentDetailsBinding, FragmentDetailsViewModel>() {

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentDetailsViewModel>
    override fun getLayoutId() = R.layout.fragment_details


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, FragmentDetailsViewModel::class)
        viewModel?.setImageItem(arguments?.getParcelable(ONCLICK_KEY_BUNDLE) ?: HitsItem())
        binding.item = viewModel?.getImageItem()
        Glide.with(this).load(viewModel?.getImageItem()?.largeImageURL).into(binding.detailsImage)
    }


    companion object {
        const val ONCLICK_KEY_BUNDLE = "keyBundle"
        fun newInstance() = FragmentDetails()
    }

}