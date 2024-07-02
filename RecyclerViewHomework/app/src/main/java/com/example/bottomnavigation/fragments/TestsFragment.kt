package com.example.bottomnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentTestsBinding

class TestsFragment : Fragment(R.layout.fragment_tests) {

    private var binding: FragmentTestsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTestsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}