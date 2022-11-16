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


    private val allCfg = ArrayList<Config>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val configTV: TextView = itemView.findViewById(R.id.idTVConfig)
        val dateTV2: TextView = itemView.findViewById(R.id.idTVDate)
        val deleteIV2: TextView = itemView.findViewById(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.config_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.configTV.text = allCfg[position].nameConfig
        holder.dateTV2.text = "Last Updated : " + allCfg[position].timeStamp
        holder.deleteIV2.setOnClickListener {
            configClickDeleteInterface.onDeleteIconClick(allCfg[position])
        }


        holder.itemView.setOnClickListener {
            configClickInterface.onConfigClick(allCfg[position])
        }
    }

    override fun getItemCount(): Int {

        return allCfg.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Config>) {
        allCfg.clear()
        allCfg.addAll(newList)
        notifyDataSetChanged()
    }

}
interface ConfigClickDeleteInterface {
    fun onDeleteIconClick(config: Config)
}

interface ConfigClickInterface {
    fun onConfigClick(config: Config)
}
