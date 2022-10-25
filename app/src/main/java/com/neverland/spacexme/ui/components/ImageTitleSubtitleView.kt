package com.neverland.spacexme.ui.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.neverland.spacexme.R
import com.neverland.spacexme.databinding.ViewImageTitleSubtitleBinding

/**
 * Custom view representing a ImageTitleSubtitle
 *
 * Example usage:
 *
 * <com.neverland.spacexme.ui.components.ImageTitleSubtitleView
 *      android:id="@+id/itv_[id]"
 *      android:layout_width="0dp"
 *      android:layout_height="0dp"
 *      app:layout_constraintBottom_toBottomOf="parent"
 *      app:layout_constraintEnd_toEndOf="parent"
 *      app:layout_constraintStart_toStartOf="parent"
 *      app:layout_constraintTop_toTopOf="parent"
 *      app:image="@drawable/[some_res_id]"
 *      app:subtitle="@string/[some_res_id]"
 *      app:title="@string/[some_res_id]" />
 */
class ImageTitleSubtitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private val binding: ViewImageTitleSubtitleBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.view_image_title_subtitle,
        this,
        true
    )

    init {
        initAttributes(context, attrs)
    }

    private fun initAttributes(context: Context, attrs: AttributeSet?) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.ImageTitleSubtitleView, 0, 0)

        try {
            val imageDrawable = typedArray.getDrawable(R.styleable.ImageTitleSubtitleView_image)
            val title = typedArray.getString(R.styleable.ImageTitleSubtitleView_title)
            val subtitle = typedArray.getString(R.styleable.ImageTitleSubtitleView_subtitle)

            imageDrawable?.let { setImage(it) }
            title?.let { setTitle(it) }
            subtitle?.let { setSubtitle(it) }
        } finally {
            typedArray.recycle()
        }
    }

    fun setImage(@DrawableRes imageRes: Int) {
        binding.ivImage.setImageResource(imageRes)
    }

    fun setImage(image: Drawable) {
        binding.ivImage.setImageDrawable(image)
    }

    fun setTitle(title: String) {
        binding.tvTitle.text = title
    }

    fun setSubtitle(subtitle: String) {
        binding.tvSubtitle.text = subtitle
    }
}