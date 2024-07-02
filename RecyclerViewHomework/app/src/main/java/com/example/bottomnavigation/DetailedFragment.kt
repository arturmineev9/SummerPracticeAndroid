package com.example.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.bottomnavigation.databinding.FragmentDetailedBinding
import com.example.bottomnavigation.databinding.FragmentGreetingBinding
import com.google.android.material.snackbar.Snackbar

class DetailedFragment() : Fragment(R.layout.fragment_detailed) {

    private var binding: FragmentDetailedBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailedBinding.bind(view)

        val theoryID = requireArguments().getInt(ARG_ID)
        val item = TheoryRepository.getItemById(theoryID)
        item?.let {
            binding?.run {
                Glide.with(this@DetailedFragment).load(it.imageUrl).into(ivImageDetailed)
                tvTheoryDetailed.text = it.name
                tvShortDescription.text = it.shortDescription
                tvLongDescription.text = it.longDescription

                ivBackButton.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(theoryID: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, theoryID)
        }
    }
}