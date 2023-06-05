package com.nileex.plorer.utils.storage

import android.content.Context
import android.content.SharedPreferences
import com.nileex.plorer.utils.string.PrefKeys
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class PrefNile {

    companion object {
        private var mPreference: SharedPreferences? = null
        suspend fun initPref(context: Context) {
            coroutineScope {
                val param = async {
                    context.applicationContext
                        .getSharedPreferences(
                            PrefKeys.getPrefKeyAppName(),
                            Context.MODE_PRIVATE
                        )
                }
                mPreference = param.await()
            }
        }

        fun saveStartUrl(url: String?) {
            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyStartUrl(), url)
                .apply()
        }

        fun getStartUrl(): String {
            return mPreference?.getString(
                PrefKeys.getPrefKeyStartUrl(),
                ""
            ) ?: ""
        }

        fun saveLastUrl(url: String?) {
            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyLastUrl(), url)
                .apply()
        }

        fun getLastUrl(): String {

            return mPreference?.getString(
                PrefKeys.getPrefKeyLastUrl(),
                ""
            ) ?: ""
        }

        fun saveStatus(url: String?) {

            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyStatus(), url)
                .apply()
        }

        fun getStatus(): String {

            return mPreference!!.getString(
                PrefKeys.getPrefKeyStatus(),
                ""
            ) ?: ""
        }

        fun saveCampaign(url: String?) {

            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyCampaign(), url)
                .apply()
        }

        fun getCampaign(): String {

            return mPreference!!.getString(
                PrefKeys.getPrefKeyCampaign(),
                ""
            ) ?: ""
        }

        fun saveFbclid(string: String?) {

            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyFbclid(), string)
                .apply()
        }

        fun getFbclid(): String {

            return mPreference!!.getString(
                PrefKeys.getPrefKeyFbclid(),
                "null"
            ) ?: "null"
        }

        fun savePixelId(string: String?) {
            mPreference!!.edit()
                .putString(PrefKeys.getPrefKeyPixelId(), string)
                .apply()
        }

        fun getPixelId(): String {

            return mPreference!!.getString(
                PrefKeys.getPrefKeyPixelId(),
                "null"
            ) ?: "null"
        }

        fun saveMusic(value: Boolean){


            mPreference!!.edit().putBoolean(PrefKeys.getPrefMusic(), value).apply()
        }

        fun isMusic(): Boolean {

            return mPreference!!.getBoolean(
                PrefKeys.getPrefMusic(),
                false
            ) ?: false
        }

        fun saveScore(value: Int){
            val oldScore = getScore()
            if (oldScore<value) {
                mPreference!!.edit().putInt(PrefKeys.getPrefScore(), value).apply()
            }
        }
        fun getScore():Int{
            return mPreference!!.getInt(PrefKeys.getPrefScore(), 0)
        }
    }

}