package com.aghamiri.dictionary.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aghamiri.dictionary.R
import com.aghamiri.dictionary.data.entities.Word
import kotlinx.android.synthetic.main.word_item.view.*
import java.util.*

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var data: List<Word> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.word_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size


    fun addData(data: List<Word>) {
        this.data = data
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Word) = with(itemView) {

            txtEnTitle.text = item.enWord
            txtFaTitle.text = item.faWord
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}