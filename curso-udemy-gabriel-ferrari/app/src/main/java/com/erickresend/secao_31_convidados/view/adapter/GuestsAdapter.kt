package com.erickresend.secao_31_convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.secao_31_convidados.databinding.RowGuestBinding
import com.erickresend.secao_31_convidados.model.GuestModel
import com.erickresend.secao_31_convidados.view.viewholder.GuestViewHolder

//Classe criada para o recycler view e criação de lista
class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    //Criado para pegar a lista que é recebida como parametro na função updateGuests
    private var guestList: List<GuestModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updateGuests(list: List<GuestModel>) {
        guestList = list
        // Usado para a recycler view se atualizar caso chegue alguma informação apos ela ser instanciada
        notifyDataSetChanged()
    }
}