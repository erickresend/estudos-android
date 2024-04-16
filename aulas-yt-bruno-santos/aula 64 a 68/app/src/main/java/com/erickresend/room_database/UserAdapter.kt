package com.erickresend.room_database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.room_database.databinding.RowUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<UserModel> = listOf()
    private lateinit var listener: OnUserListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val item = RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(item, listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun updateUsers(list: List<UserModel>) {
        userList = list
        notifyDataSetChanged()
    }

    fun attachListener(userListener: OnUserListener) {
        listener = userListener
    }

    class UserViewHolder(private val bind: RowUserBinding, private val listener: OnUserListener):
        RecyclerView.ViewHolder(bind.root) {

            fun bind(user: UserModel) {
                bind.textUsername.text = user.username

                bind.textUsername.setOnClickListener {
                    listener.onClick(user.id)
                }
            }
    }

    interface OnUserListener {
        fun onClick(id: Int)
    }
}