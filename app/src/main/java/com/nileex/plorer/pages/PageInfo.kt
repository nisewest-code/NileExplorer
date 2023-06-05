package com.nileex.plorer.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nileex.plorer.databinding.ActivityPageInfoBinding
import com.nileex.plorer.utils.delegate.DelegateUtil

class PageInfo : AppCompatActivity() {
    private lateinit var binding: ActivityPageInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val delegate = DelegateUtil.infoDelegate(binding)
        binding.back.setOnClickListener(delegate)
        binding.play.setOnClickListener(delegate)
    }
}