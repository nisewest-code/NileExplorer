package com.nileex.plorer.utils.delegate.support

import android.view.View
import com.nileex.plorer.databinding.ActivityPageGameNileBinding
import com.nileex.plorer.utils.route.Router

class GameDelegate(private val binding: ActivityPageGameNileBinding): View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            binding.back -> Router.onBack(v.context)
            else -> {}
        }
    }
}