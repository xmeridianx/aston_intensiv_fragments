package com.example.aston_intensiv_fragments.task2.data

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aston_intensiv_fragments.R

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    val textViewSurname: TextView = itemView.findViewById(R.id.textViewSurname)
    val textViewPhoneNumber: TextView = itemView.findViewById(R.id.textViewPhoneNumber)
}