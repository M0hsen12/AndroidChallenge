package com.androidChallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.androidChallenge.R
import com.androidChallenge.databinding.ActivityMainBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.view.base.BaseActivity
import com.androidChallenge.view.fragments.home.FragmentHome
import com.androidChallenge.viewModel.activities.MainActivityViewModel
import javax.inject.Inject

@BindModule
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<MainActivityViewModel>
    override fun getLayoutId() = R.layout.activity_main



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()


    }

    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, MainActivityViewModel::class)

    }
}