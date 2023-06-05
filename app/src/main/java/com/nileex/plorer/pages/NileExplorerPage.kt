package com.nileex.plorer.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nileex.plorer.databinding.ActivityNileExplorerPageBinding
import com.nileex.plorer.utils.delegate.DelegateUtil
import com.nileex.plorer.utils.delegate.support.BasicDelegate

class NileExplorerPage : AppCompatActivity() {
    private lateinit var binding: ActivityNileExplorerPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNileExplorerPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val delegate = DelegateUtil.basicDelegate(binding)
        binding.exit.setOnClickListener(delegate)
        binding.play.setOnClickListener(delegate)
        binding.settings.setOnClickListener(delegate)
    }
}