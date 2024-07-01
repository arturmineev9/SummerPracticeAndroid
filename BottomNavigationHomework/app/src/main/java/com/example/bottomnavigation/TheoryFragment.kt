package com.example.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.bottomnavigation.databinding.FragmentTheoryBinding

class TheoryFragment : Fragment(R.layout.fragment_theory) {

    private var binding: FragmentTheoryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTheoryBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}