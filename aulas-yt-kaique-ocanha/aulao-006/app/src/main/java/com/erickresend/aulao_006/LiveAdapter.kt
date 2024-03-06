package com.erickresend.aulao_006

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.erickresend.aulao_006.databinding.ResItemLiveBinding
import com.erickresend.aulao_006.models.Live

class LiveAdapter(private val onItemClicked : (Live) -> Unit) : RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {

    private var items : List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder{
        val item = ResItemLiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LiveViewHolder(item)
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
        holder.bind(items[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(lives : List<Live>) {
        this.items = lives
    }

    class LiveViewHolder(private val bind : ResItemLiveBinding): RecyclerView.ViewHolder(bind.root){

        fun bind(live : Live, onItemClicked : (Live) -> Unit) {
            bind.title.text = live.title
            bind.author.text = live.author

            // Para carregamento de imagens tempos que definir o molde de ok e erro
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            //Aqui colocamos as iformaçoes da imagem que sera carregada
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailUrl)
                .into(bind.thumbnail)

            itemView.setOnClickListener {
                onItemClicked(live)
            }
        }
    }
}