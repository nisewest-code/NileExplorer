package com.nileex.plorer.rv

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nileex.plorer.model.ModelItem


class HolderItem(itemView: View, private val callback: (pos: Int)->Unit) : RecyclerView.ViewHolder(itemView) {

    fun updateView(item: ModelItem, pos: Int){
        itemView.setOnClickListener {
            callback(pos)
        }
        (itemView as ImageView).setImageResource(item.res)
        val startScale = if (item.isSelect) 1f else 0.8f
        val endScale = if (item.isSelect) 0.8f else 1f
        val anim: Animation = ScaleAnimation(
            startScale, endScale,  // Start and end values for the X axis scaling
            startScale, endScale,  // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 1f
        ) // Pivot point of Y scaling

        anim.fillAfter = true // Needed to keep the result of the animation

        anim.duration = 800
        itemView.startAnimation(anim)
    }
}