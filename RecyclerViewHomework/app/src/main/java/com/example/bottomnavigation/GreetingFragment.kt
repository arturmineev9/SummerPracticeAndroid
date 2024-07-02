package com.example.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavigation.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment(R.layout.fragment_greeting) {

    private var binding: FragmentGreetingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGreetingBinding.bind(view)

        val name = arguments?.getString(ARG_NAME) ?: "ERROR"

        binding?.run {
            greetingText.text = "Добро пожаловать, $name!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        fun bundle(name: String): Bundle = Bundle().apply {
            putString(ARG_NAME, name)
        }
    }
}