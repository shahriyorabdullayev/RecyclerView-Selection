package me.shakhriyor.selectedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.shakhriyor.selectedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { SingleSelectionAdapter() }
    private val multiAdapter by lazy { MultiSelectionAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvSingle.adapter = adapter
        adapter.submitList(getData())

        binding.rvMulti.adapter = multiAdapter
        multiAdapter.submitList(getData())
    }

    private fun getData(): MutableList<Item> {
        return ArrayList<Item>().apply {
            add(Item(name = "Text1"))
            add(Item(name = "Text2"))
            add(Item(name = "Text3"))
            add(Item(name = "Text4"))
            add(Item(name = "Text5"))
            add(Item(name = "Text6"))
            add(Item(name = "Text7"))
            add(Item(name = "Text8"))
            add(Item(name = "Text9"))
            add(Item(name = "Text10"))
            add(Item(name = "Text11"))
            add(Item(name = "Text12"))
            add(Item(name = "Text13"))
            add(Item(name = "Text14"))
        }
    }
}