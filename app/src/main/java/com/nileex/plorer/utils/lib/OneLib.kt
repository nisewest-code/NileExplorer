package com.nileex.plorer.utils.lib
object OneLib {

    private var isInit = false

    fun init(application: Application){
        isInit = true
        OneSignal.initWithContext(application)
        OneSignal.setAppId(Ids.getOneId())

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications()
    }

    fun setExternalUserId(id: String){
        if (isInit) {
            OneSignal.setExternalUserId(id)
        }
    }

    fun sendTag(key: String, value: String){
        OneSignal.sendTag(key, value)
    }
}
import android.app.Application
import com.nileex.plorer.utils.string.Ids
import com.onesignal.OneSignal

