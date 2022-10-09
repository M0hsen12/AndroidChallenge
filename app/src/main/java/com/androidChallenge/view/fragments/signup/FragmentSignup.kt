package com.androidChallenge.view.fragments.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentSignupBinding
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.util.*
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.viewModel.fragments.signup.FragmentSignupViewModel
import javax.inject.Inject

@BindModule
class FragmentSignup : BaseFragment<FragmentSignupBinding, FragmentSignupViewModel>() {

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentSignupViewModel>
    override fun getLayoutId() = R.layout.fragment_signup
    val TAG = "CCC"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeData()
    }

    private fun observeData() {
        viewModel?.apply {
            userRegistrationResultLiveData.observe(viewLifecycleOwner) {
                Log.e(TAG, "observeData:success $it")
                navigateUserToHomePage(R.id.action_fragmentSignup_to_fragmentHome)
            }
            errorLiveData.observe(viewLifecycleOwner) {
                Log.e(TAG, "observeData: $it")
            }
        }

    }

    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, FragmentSignupViewModel::class)
        setUpSubmitBtn()
        setUpLoginBtn()
    }

    private fun setUpLoginBtn() {
        binding.registerLoginBtn.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun setUpSubmitBtn() {
        binding.registerSubmitBtn.setOnClickListener {
            binding.registerGroupErrorIndicator.hideTheView()

            if (!binding.registerEmail.text.isEmailValid()) {
                handleInvalidEmail()
                return@setOnClickListener
            }

            if (!binding.registerPassword.text.isPasswordValid()) {
                handleInvalidPassword()
                return@setOnClickListener
            }

            if (!binding.registerAge.text.isAgeValid()) {
                handleInvalidAge()
                return@setOnClickListener
            }

            viewModel?.registerUser(
                entityMapper(
                    email = binding.registerEmail.text.toString(),
                    password = binding.registerPassword.text.toString(),
                    age = binding.registerAge.text.toString().toInt()
                )
            )


        }

    }

    private fun handleInvalidAge() {

        binding.registerGroupErrorIndicator.showTheView()
        binding.registerErrorIndicator.text = resources.getText(R.string.invalidAge)
    }

    private fun handleInvalidEmail() {
        binding.registerGroupErrorIndicator.showTheView()
        binding.registerErrorIndicator.text = resources.getText(R.string.invalidEmail)
    }

    private fun handleInvalidPassword() {
        binding.registerGroupErrorIndicator.showTheView()
        binding.registerErrorIndicator.text = resources.getText(R.string.invalidPassword)
    }


    companion object {
        fun newInstance() = FragmentSignup()
    }

}