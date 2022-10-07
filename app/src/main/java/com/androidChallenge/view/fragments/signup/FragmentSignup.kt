package com.androidChallenge.view.fragments.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentLoginBinding
import com.androidChallenge.databinding.FragmentSignupBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.login.FragmentLoginViewModel
import com.androidChallenge.viewModel.fragments.signup.FragmentSignupViewModel
import javax.inject.Inject
@BindModule
class FragmentSignup  : BaseFragment<FragmentSignupBinding, FragmentSignupViewModel>() {

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentSignupViewModel>
    override fun getLayoutId() = R.layout.fragment_signup



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() = FragmentSignup()
    }

}