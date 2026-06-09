package com.training.ptojectone.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?){
    Glide.with(this.context)
        .load(url)
        .into(this)
}