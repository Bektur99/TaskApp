package com.example.taskapp.ui.onBoarding.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.R
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.ui.model.OnBoard
import com.example.taskapp.ui.utils.loadImage

class OnBoardingAdapter(private val context: Context, private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private var data = arrayListOf(
        OnBoard(
            "https://user-images.githubusercontent.com/96876621/208057403-41a19d9e-0072-4028-977c-32e1ccd306d1.png",
            "Productivity"
        ),
        OnBoard(
            "https://user-images.githubusercontent.com/96876621/208063667-a4bf40de-cf16-4c40-ad39-b51b29ac8ee0.png",
            "Made by those who use"
        ),
        OnBoard(
            "https://user-images.githubusercontent.com/96876621/208063679-b1d4fd9e-f2d5-4848-a2c7-fd94d0e21902.png",
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
            binding.ivBoarding.loadImage(onBoard.image!!)
            binding.tvTitle.text = onBoard.title
            binding.tvSkip.text = onBoard.desc
            if (adapterPosition == data.lastIndex) binding.tvSkip.text =
                context.getString(R.string.next) else context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }
    }
}