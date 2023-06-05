package com.nileex.plorer.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nileex.plorer.R
import com.nileex.plorer.databinding.ActivityPageGameNileBinding
import com.nileex.plorer.model.ModelItem
import com.nileex.plorer.rv.AdapterRv
import com.nileex.plorer.storage.Storage
import com.nileex.plorer.utils.delegate.DelegateUtil
import com.nileex.plorer.utils.delegate.support.GameDelegate
import com.nileex.plorer.utils.storage.Bucket

class PageGameNile : AppCompatActivity() {
    private lateinit var binding: ActivityPageGameNileBinding
    private lateinit var delegate: GameDelegate
    private val localStorage = StorageUIGame()
    private lateinit var adapter: AdapterRv
    private var currentId = 0
    private var listSelectItem = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageGameNileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        delegate = DelegateUtil.gameDelegate(binding)
        binding.back.setOnClickListener(delegate)

        adapter = AdapterRv(this::callback)
        binding.rv.adapter = adapter

        startNewGame(false)
    }

    private fun startNewGame(b: Boolean) {
        currentId = 0
        localStorage.listImg.clear()
        localStorage.listImg.addAll(listOf(0, 0, 0, 0))
        if (!b) {
            localStorage.bonus = 0
        }
        startNewLevel()
    }

    private fun startNewLevel() {
        localStorage.list.clear()

        val listImg = Storage.listImg().toMutableList()

        val randomItem = listImg.random()
        listImg.remove(randomItem)

        val nList: MutableList<ModelItem> = mutableListOf()

        nList.add(ModelItem(randomItem, false))
        nList.add(ModelItem(randomItem, false))
        listImg.forEach {
            nList.add(ModelItem(it, false))
        }
//        (0..13).forEach { _ ->
//            nList.add(ModelItem(listImg.random(), false))
//        }

        localStorage.list.addAll(nList.shuffled())

        updateContainerImg()
        updateList()
        updateBonusUi()
    }

    private fun callback(pos: Int) {
        when (listSelectItem.size) {
            0 -> {
                listSelectItem.add(pos)
                localStorage.list[pos].isSelect = true
                updateItem(pos)
            }
            1 -> {
                val itemSelect = listSelectItem[0]
                val item = localStorage.list[pos]
                if (itemSelect == pos) {
                    localStorage.list[itemSelect].isSelect = false
                    updateItem(itemSelect)
                } else if (localStorage.list[itemSelect].res == item.res) {
                    localStorage.listImg[currentId] = item.res
                    currentId++

                    if (currentId > 3) {
                        localStorage.bonus += 1
                        startNewGame(true)
                    } else {
                        startNewLevel()
                    }
                } else {
                    localStorage.list[itemSelect].isSelect = false
                    updateItem(itemSelect)

                    Bucket.score = localStorage.bonus
                    startNewGame(false)
                }

                listSelectItem.clear()
            }
        }
    }

    private fun updateContainerImg() {
        val img1 = localStorage.listImg[0]
        val img2 = localStorage.listImg[1]
        val img3 = localStorage.listImg[2]
        val img4 = localStorage.listImg[3]

        Log.e("img1", img1.toString())
        Log.e("img2", img2.toString())
        Log.e("img3", img3.toString())
        Log.e("img4", img4.toString())

        binding.img1.setImageResource(img1)
        binding.img2.setImageResource(img2)
        binding.img3.setImageResource(img3)
        binding.img4.setImageResource(img4)
    }

    private fun updateList() {
        adapter.updateList(localStorage.list)
    }

    private fun updateItem(pos: Int) {
        adapter.updateItem(pos)
    }

    private fun updateBonusUi() {
        val bonusText = getText(R.string.bonus)
        binding.bonusText.text = "$bonusText: ${localStorage.bonus}"
    }

    private class StorageUIGame(
        var bonus: Int = 0,
        val listImg: MutableList<Int> = mutableListOf(0, 0, 0, 0),
        val list: MutableList<ModelItem> = mutableListOf()
    )
}