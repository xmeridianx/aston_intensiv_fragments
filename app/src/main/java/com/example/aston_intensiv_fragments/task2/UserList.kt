package com.example.aston_intensiv_fragments.task2

import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.task2.data.model.UserItem
import kotlin.random.Random

object UserList {

    private var listUsers = (1..4).map {
        UserItem(it, R.drawable.baseline_person_24,"Name$it", "LastName$it", Random.nextInt().toString())
    }

    fun getUsers(): List<UserItem> {
        return listUsers
    }

    fun getUserById(id: Int): UserItem? {
        return listUsers.find { it.id == id }
    }

    fun editUser(
        id: Int,
        name: String,
        surname: String,
        phoneNumber: String
    ) {
        listUsers = listUsers.map {
            if (it.id == id) {
                it.copy(
                    name = name,
                    surname = surname,
                    phoneNumber = phoneNumber,
                )
            } else {
                it
            }
        }
    }
}