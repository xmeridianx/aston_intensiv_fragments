package com.example.aston_intensiv_fragments.task2.data

import androidx.recyclerview.widget.DiffUtil
import com.example.aston_intensiv_fragments.task2.data.model.UserItem

class UserDiffCallback: DiffUtil.ItemCallback<UserItem>() {
    override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem == newItem
    }
}