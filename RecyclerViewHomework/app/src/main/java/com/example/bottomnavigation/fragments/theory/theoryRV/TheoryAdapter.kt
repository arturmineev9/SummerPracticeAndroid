package com.example.bottomnavigation.fragments.theory.theoryRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.bottomnavigation.databinding.ItemTheoryBinding

class TheoryAdapter(
    private var list: List<TheoryModel>,
    private val glide: RequestManager,
    private val onClick: (TheoryModel) -> Unit,
) : RecyclerView.Adapter<TheoryHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TheoryHolder = TheoryHolder(
        binding = ItemTheoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: TheoryHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<TheoryModel>) {
        list = newList
        notifyDataSetChanged()
    }
}