package com.example.aston_intensiv_fragments.task2.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.task2.data.model.UserItem

class UserAdapter(private val onUserItemClick: (UserItem) -> Unit)
    : ListAdapter<UserItem, UserViewHolder>(UserDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.textViewName.text = user.name
        holder.textViewSurname.text = user.surname
        holder.textViewPhoneNumber.text = user.phoneNumber
        holder.itemView.setOnClickListener { onUserItemClick(user) }
    }
}

