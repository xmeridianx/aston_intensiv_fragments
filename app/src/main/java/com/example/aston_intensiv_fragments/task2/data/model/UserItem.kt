package com.example.aston_intensiv_fragments.task2.data.model

import android.os.Parcelable
import java.io.Serializable

data class UserItem(
    val id: Int,
    val photo: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String
): Serializable
