package com.androidChallenge.view.fragments.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentLoginBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.util.hideTheView
import com.androidChallenge.util.isEmailValid
import com.androidChallenge.util.isPasswordValid
import com.androidChallenge.util.showTheView
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.login.FragmentLoginViewModel
import javax.inject.Inject

@BindModule
class FragmentLogin : BaseFragment<FragmentLoginBinding, FragmentLoginViewModel>() {

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentLoginViewModel>
    override fun getLayoutId() = R.layout.fragment_login
    private val TAG = "AAA"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeData()

    }

    private fun observeData() {
        viewModel?.apply {
            userLiveData.observe(viewLifecycleOwner) {
                navigateUserToHomePage(R.id.action_fragmentLogin_to_fragmentHome)
            }

            errorLiveData.observe(viewLifecycleOwner) {
                if (it.message?.contains("password") == true)
                    handleWrongPassword()
            }
        }
    }


    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, FragmentLoginViewModel::class)
        setUpSubmitBtn()
        setUpRegisterBtn()
    }

    private fun setUpRegisterBtn() {

        binding.loginRegister.apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentSignup)
            }
        }
    }

    private fun setUpSubmitBtn() {
        binding.loginSubmit.apply {
            setOnClickListener {
                binding.loginGroupErrorIndicator.hideTheView()

                if (!binding.loginEmail.text.isEmailValid()) {
                    handleInvalidEmail()
                    return@setOnClickListener
                }

                if (!binding.loginPassword.text.isPasswordValid()) {
                    handleInvalidPassword()
                    return@setOnClickListener
                }

                viewModel?.getUserByEmail(
                    binding.loginEmail.text.toString(),
                    binding.loginPassword.text.toString()
                )

            }
        }

    }

    private fun handleInvalidEmail() {
        binding.loginGroupErrorIndicator.showTheView()
        binding.loginErrorIndicator.text = resources.getText(R.string.invalidEmail)
    }

    private fun handleInvalidPassword() {
        binding.loginGroupErrorIndicator.showTheView()
        binding.loginErrorIndicator.text = resources.getText(R.string.invalidPassword)
    }

    private fun handleWrongPassword() {
        binding.loginGroupErrorIndicator.showTheView()
        binding.loginErrorIndicator.text = resources.getText(R.string.wrongPassword)
    }

    companion object {
        fun newInstance() = FragmentLogin()
    }
}