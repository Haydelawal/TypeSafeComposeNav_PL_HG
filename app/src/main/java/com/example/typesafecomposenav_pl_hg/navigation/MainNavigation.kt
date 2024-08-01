package com.example.typesafecomposenav_pl_hg.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.typesafecomposenav_pl_hg.data.MyDummy
import com.example.typesafecomposenav_pl_hg.utils.Constants
import kotlin.reflect.typeOf

@Composable
fun MainNavigation(modifier: Modifier = Modifier){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =MyDestination.Home) {


        composable<MyDestination.Home>{
            HomeScreen {
                navController.navigate(MyDestination.Profile)
            }
        }

        composable<MyDestination.Profile>{
            ProfileScreen {
                navController.navigate(MyDestination.About(
                    name = "haydelawal",
                    age = 99
                ))
            }
        }

        composable<MyDestination.About>{
            val myArguments = it.toRoute<MyDestination.About>()
            val myDumDum = MyDummy("aaaa", "male", 99)
            AboutScreen(myArguments) {
                navController.navigate(MyDestination.Info(
                    myDumDum
                ))
            }
        }

        composable<MyDestination.Info>(
            typeMap = mapOf(typeOf<MyDummy>() to Constants.CustomNavType<MyDummy>(
                MyDummy::class,
                MyDummy.serializer()
            ))
        ){
            val myArguments = it.toRoute<MyDestination.Info>()
            InfoScreen (myArguments) {

            }
        }
    }
}