package com.erickresend.aulao_006

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.aulao_006.databinding.ResItemLiveBinding
import com.erickresend.aulao_006.models.Live

class LiveAdapter : RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {

    private var items = mutableListOf<Live>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflater, parent, false)
        return LiveViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
        val live = items[position]
        holder.bind(live)
    }

    fun setDataSet(lives : List<Live>) {
        this.items = lives.toMutableList()
        notifyDataSetChanged()
    }

    class LiveViewHolder(val binding: ResItemLiveBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(live : Live) {
            binding.title.text = live.title
            binding.author.text = live.author
        }
    }
}