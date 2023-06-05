package com.nileex.plorer.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nileex.plorer.R
import com.nileex.plorer.databinding.ActivityPageSettingsNileBinding
import com.nileex.plorer.utils.SoundService
import com.nileex.plorer.utils.delegate.DelegateUtil
import com.nileex.plorer.utils.delegate.support.SettingsDelegate
import com.nileex.plorer.utils.storage.Bucket

class PageSettingsNile : AppCompatActivity() {
    private lateinit var binding: ActivityPageSettingsNileBinding
    private lateinit var delegate: SettingsDelegate
    private var isMusic = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageSettingsNileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        delegate = DelegateUtil.settingDelegate(binding, this::cl)
        binding.back.setOnClickListener(delegate)
        isMusic = Bucket.isMusic

        binding.btnMusic.setOnClickListener(delegate)
        update()
    }

    private fun cl(){
        if (isMusic) {
            stopService(Intent(this, SoundService::class.java))
            Bucket.isMusic = false
        } else {
            startService(Intent(this, SoundService::class.java))
            Bucket.isMusic = true
        }
        isMusic = !isMusic
        update()
    }

    private fun update(){
        if (isMusic){
            binding.btnMusic.text = getString(R.string.off)
        } else {
            binding.btnMusic.text = getString(R.string.on)
        }
    }
}