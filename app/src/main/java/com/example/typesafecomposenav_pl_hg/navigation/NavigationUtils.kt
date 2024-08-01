package com.example.typesafecomposenav_pl_hg.navigation

import com.example.typesafecomposenav_pl_hg.data.MyDummy
import kotlinx.serialization.Serializable

sealed class MyDestination {

    @Serializable
    data object Home : MyDestination()

    @Serializable
    data object Profile : MyDestination()

    /** Adding singular primitive data type arguments here, use data class not data object
     */
    @Serializable
    data class About(val name: String, val age: Int) : MyDestination()

    /** Adding custom data class arguments here, use data class not data object
     */
    @Serializable
    data class Info(val myDummy: MyDummy) : MyDestination()

}

sealed class SubGraph {

    @Serializable
    data object Auth : SubGraph()

    @Serializable
    data object Dashboard : SubGraph()
}


sealed class DestSubGraph {

    @Serializable
    data object AuthFirstScreen : DestSubGraph()

    @Serializable
    data object AuthSecondScreen : DestSubGraph()

    @Serializable
    data object DashFirstScreen : DestSubGraph()

    @Serializable
    data class DashThirdScreen(val myDummy: MyDummy) : DestSubGraph()

    @Serializable
    data class  DashSecondScreen(val name: String, val age: Int ): DestSubGraph()
}