package com.example.typesafecomposenav_pl_hg.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class MyDummy(
    val name: String,
    val gender: String,
    val age: Int

): Parcelable
