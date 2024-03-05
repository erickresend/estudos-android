package com.erickresend.aulao_006

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.aulao_006.databinding.ActivityMainBinding
import com.erickresend.aulao_006.models.Live
import kotlinx.android.synthetic.main.res_item_live.view.author
import kotlinx.android.synthetic.main.res_item_live.view.thumbnail
import kotlinx.android.synthetic.main.res_item_live.view.title

class LiveAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is LiveViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun setDataSet(lives : List<Live>) {
        this.items = lives
    }

    class LiveViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        // Para fazer essa referencia ao itens do xml que no grandle usamos id("kotlin-android-extensions")
        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live : Live) {
            liveTitle.text = live.title
            liveAuthor.text = live.author
        }
    }
}