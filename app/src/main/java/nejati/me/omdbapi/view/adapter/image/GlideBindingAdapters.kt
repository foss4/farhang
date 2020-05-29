package nejati.me.sample.view.adapter

import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import nejati.me.omdbapi.R
import nejati.me.omdbapi.utility.SvgSoftwareLayerSetter


/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
object GlideBindingAdapters {


    /**
     *
     * @param view
     * @param imageDrwable
     */

    @JvmStatic
    @BindingAdapter("drwableImage")
    fun loadDrwableImage(view: ImageView, drwable: Int) {
        Glide.with(view.context)
            .load(drwable)
            .into(view)

    }

    /**
     *
     * @param view
     * @param imageUrl
     */

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadUrl(view: ImageView, drwable: String) {
        Glide.with(view.context)
            .load(drwable)
            .into(view)

    }

    @JvmStatic
    @BindingAdapter("svgImage")
    fun loadSvgImage(view: ImageView, raw: Int) {
        Glide.with(view)
            .`as`(PictureDrawable::class.java)
            .transition(withCrossFade())
            .listener(SvgSoftwareLayerSetter()).load(raw)
            .into(view)

    }
}
