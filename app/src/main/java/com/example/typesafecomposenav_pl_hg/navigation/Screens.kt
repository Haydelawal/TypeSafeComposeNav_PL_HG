package com.example.typesafecomposenav_pl_hg.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.typesafecomposenav_pl_hg.data.MyDummy

@Composable
fun AuthFirst(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Auth First Screen", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}


@Composable
fun AuthSecond(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Auth Second Screen", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}

@Composable
fun DashFirst(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Dash First Screen ", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}


@Composable
fun DashSecond(dashboard: DestSubGraph.DashSecondScreen, modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Dash Second Screen ${dashboard.name} ${dashboard.age}", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}

@Composable
fun DashThird(args: DestSubGraph.DashThirdScreen, modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Dash Third Screen ${args.myDummy.gender}, ${args.myDummy.name}, ${args.myDummy.age}", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}