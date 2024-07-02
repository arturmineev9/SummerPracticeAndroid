package com.example.bottomnavigation

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.bottomnavigation.databinding.ItemTheoryBinding

class TheoryHolder(
    private val binding: ItemTheoryBinding,
    private val glide: RequestManager,
    private val onClick: (TheoryModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    private val context: Context
        get() = itemView.context

    fun onBind(theory: TheoryModel) {
        binding.run {
            tvTheory.text = theory.name
            tvDescription.text = theory.shortDescription

            glide
                .load(theory.imageUrl)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(theory)
            }

        }
    }

}