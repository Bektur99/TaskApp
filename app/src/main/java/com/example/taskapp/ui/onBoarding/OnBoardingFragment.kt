package com.example.taskmanager.ui.onBoarding

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.taskapp.R
import com.example.taskapp.data.Pref
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.ui.onBoarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding


    private val adapter = OnBoardingAdapter()
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
        val adapter=OnBoardingAdapter()
            pref.saveSeen()
            findNavController().navigateUp()

        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object :OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.btnStart.isVisible = position == adapter.itemCount -1
            }
        })
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
        start()
    }

    private fun start () {
binding.btnStart.setOnClickListener {
    findNavController().navigate(R.id.action_onBoardingFragment_to_navigation_home )
}
    }
}


