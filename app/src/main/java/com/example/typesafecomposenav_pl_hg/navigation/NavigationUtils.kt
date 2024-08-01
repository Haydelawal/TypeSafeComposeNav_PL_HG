package com.example.typesafecomposenav_pl_hg.navigation

import com.example.typesafecomposenav_pl_hg.data.MyDummy
import kotlinx.serialization.Serializable

sealed class MyDestination{

    @Serializable
    data object Home:MyDestination()

    @Serializable
    data object Profile:MyDestination()

    /** Adding singular primitive data type arguments here, use data class not data object
    */
    @Serializable
    data class About(val name: String, val age: Int):MyDestination()

    /** Adding custom data class arguments here, use data class not data object
    */
    @Serializable
    data class Info(val myDummy: MyDummy) :MyDestination()

}