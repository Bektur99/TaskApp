package com.example.taskapp.ui.onBoarding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.R
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.ui.model.OnBoard
import com.example.taskapp.ui.utils.loadImage

class OnBoardingAdapter() :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private var data = arrayListOf(
        OnBoard(
            R.raw.lottie,
            "Productivity"
        ),
        OnBoard(
            R.raw.lottie,
            "Made by those who use"
        ),
        OnBoard(
            R.raw.lottie,
            "Sync with other devices"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            onBoard.image?.let { binding.ivBoarding.setAnimation(it) }
            binding.tvTitle.text = onBoard.title
        }
    }
}