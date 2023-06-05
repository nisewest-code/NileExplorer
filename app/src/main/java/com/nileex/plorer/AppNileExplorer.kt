package com.nileex.plorer

import android.app.Application
import com.bugsee.library.Bugsee
import com.nileex.plorer.utils.device.DeviceUtil
import com.nileex.plorer.utils.lib.OneLib
import com.nileex.plorer.utils.network.Analytics
import com.nileex.plorer.utils.storage.Bucket
import com.nileex.plorer.utils.string.Ids
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppNileExplorer: Application() {

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.Default).launch {
            Bucket.init(this@AppNileExplorer)
        }
        Analytics.init(this)

//        Bugsee.launch(this, Ids.bugId())

        DeviceUtil.checkDevice(
            this, callbackFail = {},
            callbackSuccess = {
                OneLib.init(this)
            }
        )

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
    }
}