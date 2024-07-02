package com.example.bottomnavigation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            nextButton.setOnClickListener {

                val name = etName.text.toString()
                if (name.isNotEmpty()) {
                    val bundle = Bundle()
                    bundle.putString("ARG_NAME", name)

                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_greetingFragment,
                        args = GreetingFragment.bundle(
                            name = name
                        )
                    )
                } else {
                    hideKeyboard()
                    Snackbar.make(root, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = requireActivity().currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}