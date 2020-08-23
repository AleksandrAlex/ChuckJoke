package com.suslovalex.chuckjoke.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suslovalex.chuckjoke.model.Post
import com.suslovalex.chuckjoke.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class JokeViewModel(private val repository: Repository): ViewModel() {

    private val getNullString = "0"

    private val _response: MutableLiveData<Response<Post>> = MutableLiveData()
    val response: LiveData<Response<Post>>
    get() = _response

    private val _amountOfJokes: MutableLiveData<String> = MutableLiveData()
    val amountOfJokes: LiveData<String>
    get() = _amountOfJokes

    fun getJoke(number: String) {

        viewModelScope.launch {
            if (number.isEmpty()) {
                _response.value = repository.getJoke(getNullString)
            } else {
                _response.value = repository.getJoke(number)
            }
        }
    }


    fun reloadBtnClicked() {
        _amountOfJokes.value?.let { getJoke(it) }
    }

    var editTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
          _amountOfJokes.value = p0.toString()
        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }
}