package com.nileex.plorer.utils.delegate

import com.nileex.plorer.databinding.ActivityNileExplorerPageBinding
import com.nileex.plorer.databinding.ActivityPageGameNileBinding
import com.nileex.plorer.databinding.ActivityPageInfoBinding
import com.nileex.plorer.databinding.ActivityPageSettingsNileBinding
import com.nileex.plorer.utils.delegate.support.BasicDelegate
import com.nileex.plorer.utils.delegate.support.GameDelegate
import com.nileex.plorer.utils.delegate.support.InfoDelegate
import com.nileex.plorer.utils.delegate.support.SettingsDelegate

object DelegateUtil {

    fun basicDelegate(binding: ActivityNileExplorerPageBinding) = BasicDelegate(binding)
    fun infoDelegate(binding: ActivityPageInfoBinding) = InfoDelegate(binding)
    fun settingDelegate(binding: ActivityPageSettingsNileBinding, callback:()->Unit) = SettingsDelegate(binding, callback)
    fun gameDelegate(binding: ActivityPageGameNileBinding) = GameDelegate(binding)
}