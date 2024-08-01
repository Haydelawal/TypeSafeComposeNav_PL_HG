package com.example.typesafecomposenav_pl_hg.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.typesafecomposenav_pl_hg.data.MyDummy
import com.example.typesafecomposenav_pl_hg.utils.Constants
import kotlin.reflect.typeOf

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SubGraph.Auth) {


        navigation<SubGraph.Auth>(startDestination = DestSubGraph.AuthFirstScreen) {
            composable<DestSubGraph.AuthFirstScreen> {
                AuthFirst {
                    navController.navigate(DestSubGraph.AuthSecondScreen)
                }
            }


            composable<DestSubGraph.AuthSecondScreen> {
                AuthSecond {

                    /** Navigate to screen with singular primitive data types */
                    /*navController.navigate(DestSubGraph.DashSecondScreen(
                        name = "aaaaa",
                        age = 12
                    ))
*/

                    val myDummy = MyDummy("bbbb", "cccc", 12)
                    navController.navigate(DestSubGraph.DashThirdScreen(myDummy))

                }
            }
        }

        navigation<SubGraph.Dashboard>(startDestination = DestSubGraph.DashFirstScreen) {

            composable<DestSubGraph.DashFirstScreen> {
                /** IDK why but trying to pass data class/ arguments in general to start destination sub graph screen gives issues
                 * worth looking into **/
            }

            composable<DestSubGraph.DashSecondScreen> {
                val dashSecondScreenArgs = it.toRoute<DestSubGraph.DashSecondScreen>()
                DashSecond(dashSecondScreenArgs) {

                }
            }
        }

        composable<DestSubGraph.DashThirdScreen>(
            typeMap = mapOf(
                typeOf<MyDummy>() to Constants.CustomNavType<MyDummy>(
                    MyDummy::class,
                    MyDummy.serializer()
                )
            )

        ) {
            val myArguments = it.toRoute<DestSubGraph.DashThirdScreen>()
            DashThird(myArguments) {

            }

        }

    }
}