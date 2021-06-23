package com.dev_abdallah_el_zoka.softxpert_android_task;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapters {
    @BindingAdapter("imageFromURL")
    public static void setPaddingLeft(ImageView image, String url) {
        Glide.with(image.getContext()).load(url).into(image);
    }

}
