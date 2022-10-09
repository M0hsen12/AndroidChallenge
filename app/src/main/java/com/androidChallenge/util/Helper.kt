package com.androidChallenge.util

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.annotation.StyleRes
import androidx.databinding.DataBindingUtil
import com.androidChallenge.R
import com.androidChallenge.databinding.DialogSimpleProgressBinding
import com.androidChallenge.di.database.entity.UserEntity

fun entityMapper(email: String, password: String, age: Int) =
    UserEntity(
        email = email,
        password = password,
        age = age
    )

fun materialSimpleProgressDialog(
    context: Context,
    @StyleRes theme: Int = R.style.ThemeDialog_Dark
): Dialog {
    return Dialog(context, theme).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        val binder = DataBindingUtil.inflate<DialogSimpleProgressBinding>(
            LayoutInflater.from(context),
            R.layout.dialog_simple_progress,
            null,
            false
        )
        setContentView(binder.root)
    }
}