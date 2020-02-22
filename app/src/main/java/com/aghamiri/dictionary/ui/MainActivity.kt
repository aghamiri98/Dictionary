package com.aghamiri.dictionary.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aghamiri.dictionary.R
import com.aghamiri.dictionary.data.WordViewModel
import com.aghamiri.dictionary.ui.adapters.WordAdapter
import com.aghamiri.dictionary.utils.setVerticalLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.setVerticalLayout()
        val wordAdapter = WordAdapter()
        recyclerView.adapter = wordAdapter

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        wordViewModel.datas.observe(this@MainActivity, Observer {
            wordAdapter.addData(it)
        })
        wordViewModel.getAll()

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {


            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                wordViewModel.search(s.toString())
            }
        })


    }
}
