package com.csi.bottomnavigationactivity.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csi.bottomnavigationactivity.R
import com.csi.bottomnavigationactivity.db.Card
import com.csi.bottomnavigationactivity.db.Note

class CardRVAdapter(
    private val cardClickInterface: CardClickInterface
) : RecyclerView.Adapter<CardRVAdapter.ViewHolder>() {

    private val allCards = ArrayList<Card>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textQuestAnswer: TextView = itemView.findViewById(R.id.text_quest_answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = allCards[position]
        holder.textQuestAnswer.text = item.question
        holder.itemView.setOnClickListener {
            cardClickInterface.onCardClick(item)
        }
    }

    override fun getItemCount(): Int {
        return allCards.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Card>) {
        // on below line we are clearing
        // our notes array list
        allCards.clear()
        // on below line we are adding a
        // new list to our all notes list.
        allCards.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }
}

interface CardClickInterface {
    fun onCardClick(card: Card)
}