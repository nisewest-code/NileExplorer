package com.nileex.plorer.utils.storage

import android.app.Application

object Bucket {
    var startUrl = ""
        set(value) {
            field = value
            PrefNile.saveStartUrl(value)
        }
        get() {
            field = PrefNile.getStartUrl()
            return field
        }
    var lastUrl = ""
        set(value) {
            field = value
            PrefNile.saveLastUrl(value)
        }
        get() {
            field = PrefNile.getLastUrl()
            return field
        }
    var status = ""
        set(value) {
            field = value
            PrefNile.saveStatus(value)
        }
        get() {
            field = PrefNile.getStatus()
            return field
        }
    var campaign = ""
        set(value) {
            field = value
            PrefNile.saveCampaign(value)
        }
        get() {
            field = PrefNile.getCampaign()
            return field
        }
    var fbclid = ""
        set(value) {
            field = value
            PrefNile.saveFbclid(value)
        }
        get() {
            field = PrefNile.getFbclid()
            return field
        }
    var pixelId = ""
        set(value) {
            field = value
            PrefNile.savePixelId(value)
        }
        get() {
            field = PrefNile.getPixelId()
            return field
        }
    var isMusic = false
        set(value) {
            field = value
            PrefNile.saveMusic(value)
        }
        get() {
            field = PrefNile.isMusic()
            return field
        }

    var score = 0
        set(value) {
            field = value
            PrefNile.saveScore(value)
        }
        get() {
            field = PrefNile.getScore()
            return field
        }

    suspend fun init(context: Application) {
        PrefNile.initPref(context)
    }
}