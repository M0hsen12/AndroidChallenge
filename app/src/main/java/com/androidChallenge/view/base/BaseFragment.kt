package com.androidChallenge.view.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment


abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {

    lateinit var binding: T

    open var viewModel: V? = null


    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    fun navigateUserToHomePage(resId: Int) {
        findNavController().navigate(resId)
    }


}