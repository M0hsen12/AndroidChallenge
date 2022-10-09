package com.androidChallenge.util

import android.text.Editable
import android.util.Patterns
import android.view.View


fun Editable?.isEmailValid() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun Editable?.isPasswordValid() = when {
    isNullOrEmpty() -> false
    this.length in 6..12 -> true
    else -> false
}
fun Editable?.isAgeValid() = when {
    isNullOrEmpty() -> false
    this.toString().toInt() in 18..99 -> true
    else -> false
}

fun View.showTheView (){
    this.visibility = View.VISIBLE
}
fun View.hideTheView (){
    this.visibility = View.GONE
}
