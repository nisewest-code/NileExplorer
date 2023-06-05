package com.nileex.plorer.utils.delegate.support

import android.view.View
import com.nileex.plorer.databinding.ActivityPageSettingsNileBinding
import com.nileex.plorer.utils.route.Router

class SettingsDelegate(private val binding: ActivityPageSettingsNileBinding, private val callback:()->Unit): View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            binding.back -> Router.onBack(v.context)
            binding.btnMusic -> callback()
        }
    }
}