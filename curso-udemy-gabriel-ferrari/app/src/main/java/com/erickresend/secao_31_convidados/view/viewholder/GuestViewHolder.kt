package com.erickresend.secao_31_convidados.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.erickresend.secao_31_convidados.databinding.RowGuestBinding
import com.erickresend.secao_31_convidados.model.GuestModel

/* Tipo RecyclerView.ViewHolder() e add o construtor sozinho,
* Essa classe é para passar no GuestAdapter e manipular o recycler view
* -
* o parametro que era recebido era de View, precisamos mudar para binding para não ser
* diferente de toda a forma que é usada o acesso a coisas da tela
* esse RowGuestBinding é a layout file criado para ser instanciada por cada item da lista de guests*/
class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}