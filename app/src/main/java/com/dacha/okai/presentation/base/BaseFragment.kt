package com.dacha.okai.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dacha.okai.presentation.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes layoutUd : Int) : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupRequests()
        setupSubscribers()
        setupListeners()
    }

    protected open fun initialize() {}

    protected open fun setupRequests() {}

    protected open fun setupSubscribers() {}

    protected open fun setupListeners() {}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError : (message : String) -> Unit ,
        onSuccess : (data : T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    when (it) {
                        is UIState.Error -> {
                            onError(it.message)
                        }
                        is UIState.Loading -> {
                            onLoading()
                        }
                        is UIState.Success -> {
                            onSuccess(it.data)
                        }
                        is UIState.Empty -> {

                        }
                    }
                }
            }
        }
    }
}