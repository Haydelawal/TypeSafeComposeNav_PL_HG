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
fun HomeScreen(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Home Screen", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}


@Composable
fun ProfileScreen(modifier: Modifier = Modifier, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Profile Screen", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}


@Composable
fun AboutScreen(myArguments: MyDestination.About, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "About Screen ${myArguments.name}, ${myArguments.age}", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}

@Composable
fun InfoScreen(myDummy: MyDestination.Info, onClick:() -> Unit) {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Info Screen ${myDummy.myDummy.name}, ${myDummy.myDummy.gender}, ${myDummy.myDummy.age}", modifier = Modifier.clickable {
            onClick.invoke()
        })
    }
}