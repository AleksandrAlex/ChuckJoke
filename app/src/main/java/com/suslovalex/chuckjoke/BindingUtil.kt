package com.suslovalex.chuckjoke

import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter


@BindingAdapter("app:getAmountJoke")
fun EditText.getAmountJoke(watcher: TextWatcher){
    this.addTextChangedListener(watcher)
}


