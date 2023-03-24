package com.dacha.okai.presentation.ui.fragment.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is asdas"
    }
    val text: LiveData<String> = _text
}