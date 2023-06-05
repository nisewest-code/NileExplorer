package com.nileex.plorer.utils.delegate.support

import android.view.View
import com.nileex.plorer.databinding.ActivityPageInfoBinding
import com.nileex.plorer.pages.PageGameNile
import com.nileex.plorer.utils.route.Router

class InfoDelegate(private val binding: ActivityPageInfoBinding): View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            binding.back -> Router.onBack(v.context)
            binding.play -> Router.routeOnPage(v.context, PageGameNile::class.java)
        }
    }
}