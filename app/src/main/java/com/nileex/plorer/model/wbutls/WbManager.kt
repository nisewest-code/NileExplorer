package com.nileex.plorer.model.wbutls

import android.app.Activity
import android.content.Intent
import android.webkit.WebView
import androidx.activity.result.ActivityResultLauncher
import com.nileex.plorer.databinding.ActivityPageLaunchBinding
import com.nileex.plorer.model.NielHelperExplorer
import com.nileex.plorer.model.NileExplorerCustom
import com.nileex.plorer.model.SNileExplorer
import com.nileex.plorer.pages.PageLaunch

object WbManager {
    fun wbCustom(context: PageLaunch, binding: ActivityPageLaunchBinding, listener: ActivityResultLauncher<Intent>): WbCustom{
        return WbCustom(context, binding, listener)
    }

    fun nileExplorerCustom(webView: WebView, callback: (item: NileExplorerCustom)->Unit): NileExplorerCustom{
        return NileExplorerCustom(webView, callback)
    }

    fun nielHelperExplorer(webView: WebView?, callback: (item: NielHelperExplorer)->Unit): NielHelperExplorer {
        return NielHelperExplorer(webView,  callback)
    }

    fun sNileExplorer(activity: MutableList<Activity?>, uri:String): SNileExplorer {
        return SNileExplorer(activity, uri)
    }
}