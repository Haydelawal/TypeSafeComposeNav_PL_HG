package com.example.typesafecomposenav_pl_hg.utils

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.typesafecomposenav_pl_hg.data.MyDummy
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


object NavigationConstants {
    val MyDummyType = object : NavType<MyDummy>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): MyDummy? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): MyDummy {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: MyDummy): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: MyDummy) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}