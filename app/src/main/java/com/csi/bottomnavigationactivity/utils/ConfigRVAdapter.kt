package com.csi.bottomnavigationactivity.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csi.bottomnavigationactivity.R
import com.csi.bottomnavigationactivity.db.Config

class ConfigRVAdapter(
    private val configClickDeleteInterface: ConfigClickDeleteInterface,
    private val configClickInterface: ConfigClickInterface
) :
    RecyclerView.Adapter<ConfigRVAdapter.ViewHolder>() {

    // on below line we are creating a
    // variable for our all notes list.
    private val allCfg = ArrayList<Config>()

    // on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are creating an initializing all our
        // variables which we have added in layout file.
        val configTV: TextView = itemView.findViewById(R.id.idTVConfig)
        val dateTV: TextView = itemView.findViewById(R.id.idTVDate)
        val deleteIV: TextView = itemView.findViewById(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // on below line we are setting data to item of recycler view.
        holder.configTV.text = allCfg[position].nameConfig
        holder.dateTV.text = "Last Updated : " + allCfg[position].timeStamp
        // on below line we are adding click listener to our delete image view icon.
        holder.deleteIV.setOnClickListener {
            // on below line we are calling a note click
            // interface and we are passing a position to it.
            configClickDeleteInterface.onDeleteIconClick(allCfg[position])
        }

        // on below line we are adding click listener
        // to our recycler view item.
        holder.itemView.setOnClickListener {
            // on below line we are calling a note click interface
            // and we are passing a position to it.
            configClickInterface.onConfigClick(allCfg[position])
        }
    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our list size.
        return allCfg.size
    }

    // below method is use to update our list of notes.
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Config>) {
        // on below line we are clearing
        // our notes array list
        allCfg.clear()
        // on below line we are adding a
        // new list to our all notes list.
        allCfg.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }

}
interface ConfigClickDeleteInterface {
    // creating a method for click
    // action on delete image view.
    fun onDeleteIconClick(config: Config)
}

interface ConfigClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onConfigClick(config: Config)
}
