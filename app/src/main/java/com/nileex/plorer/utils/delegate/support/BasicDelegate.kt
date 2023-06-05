package com.nileex.plorer.utils.delegate.support

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nileex.plorer.databinding.ActivityNileExplorerPageBinding
import com.nileex.plorer.pages.PageInfo
import com.nileex.plorer.pages.PageSettingsNile
import com.nileex.plorer.utils.route.Router

class BasicDelegate(private val binding: ActivityNileExplorerPageBinding): View.OnClickListener {

    override fun onClick(v: View?) {
        when (v) {
            binding.play -> Router.routeOnPage(v.context, PageInfo::class.java)
            binding.exit -> Router.onBack(v.context)
            binding.settings -> Router.routeOnPage(v.context, PageSettingsNile::class.java)
        }
    }
}