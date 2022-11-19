package com.csi.bottomnavigationactivity.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csi.bottomnavigationactivity.databinding.CharRvItemBinding
import com.csi.bottomnavigationactivity.network.Character

class CharRVAdapter : ListAdapter<Character, CharRVAdapter.CharViewHolder>(DiffCallback) {
    inner class CharViewHolder(val binding: CharRvItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(character: Character) {
                binding.apply {
                    loadImage(charImage, character.img)
                    charFullname.text = character.name
                    charNickname.text= character.nickname
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        return CharViewHolder(CharRvItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    private fun loadImage(imageView: ImageView, url: String?) {
        url?.let {
            val uri = url.toUri().buildUpon().scheme("https").build()
            imageView.load(uri)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}