package com.nileex.plorer.model

import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView

class NileExplorerCustom(val webView: WebView, callback: (item: NileExplorerCustom)->Unit) {

    init {
        webView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        callback(this)
    }
    fun initSettings() {
        CookieManager.getInstance().setAcceptThirdPartyCookies( webView, true)
        CookieManager.getInstance().setAcceptCookie(true)
        webView.setOnTouchListener { _, _ ->
            CookieManager.getInstance().flush()
            false
        }
    }
}