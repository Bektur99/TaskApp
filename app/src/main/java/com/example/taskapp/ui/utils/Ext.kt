package com.example.taskapp.ui.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.taskapp.R

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_profile).into(this)
}