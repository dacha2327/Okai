package com.dacha.okai.presentation.ui.fragment.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.dacha.okai.databinding.FragmentBascetBinding


class BascetFragment : Fragment() {

    private var binding: FragmentBascetBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBascetBinding.inflate(layoutInflater)
        return binding!!.root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}