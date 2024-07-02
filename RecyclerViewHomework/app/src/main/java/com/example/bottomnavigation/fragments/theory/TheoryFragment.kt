package com.example.bottomnavigation.fragments.theory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.bottomnavigation.fragments.DetailedFragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentTheoryBinding
import com.example.bottomnavigation.fragments.theory.theoryRV.TheoryAdapter
import com.example.bottomnavigation.fragments.theory.theoryRV.TheoryRepository

class TheoryFragment : Fragment(R.layout.fragment_theory) {

    private var binding: FragmentTheoryBinding? = null
    private var adapter: TheoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTheoryBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = TheoryAdapter(
                list = TheoryRepository.items,
                glide = Glide.with(this@TheoryFragment),
                onClick = { item ->
                    val bundle = Bundle()
                    bundle.putInt("ARG_ID", item.id)
                    findNavController().navigate(
                        resId = R.id.action_theoryFragment_to_detailedFragment,
                        args = DetailedFragment.bundle(
                            theoryID = item.id
                        )
                    )
                }
            )

            rvTheory.adapter = adapter

            rvTheory.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}