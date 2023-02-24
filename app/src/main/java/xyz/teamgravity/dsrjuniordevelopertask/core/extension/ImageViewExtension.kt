package xyz.teamgravity.dsrjuniordevelopertask.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import xyz.teamgravity.dsrjuniordevelopertask.R

/**
 * Loads image from url and center crops it.
 */
fun ImageView.centerCrop(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.placeholder_error)
        .placeholder(R.drawable.placeholder_image)
        .into(this)
}

/**
 * Loads image from url and fit center it.
 */
fun ImageView.fitCenter(url: String?) {
    Glide.with(context)
        .load(url)
        .fitCenter()
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
