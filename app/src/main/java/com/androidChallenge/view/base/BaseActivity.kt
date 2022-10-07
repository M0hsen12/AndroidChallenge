package com.androidChallenge.view.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : DaggerAppCompatActivity() {

    lateinit var binding: T

    open var viewModel: V? = null

    open var disposable = CompositeDisposable()


    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }
    fun addDisposable(disposable: Disposable?) {
        disposable?.let {
            this.disposable.add(it)
        }
    }



    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }


}
