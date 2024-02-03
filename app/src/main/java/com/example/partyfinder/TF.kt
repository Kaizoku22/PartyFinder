package com.example.partyfinder

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.partyfinder.navigation.PartyUpRouterSam
import com.example.partyfinder.navigation.Screens
import com.example.partyfinder.ui.theme.HomeScreen
import com.example.partyfinder.ui.theme.HomepageContent
import com.example.partyfinder.ui.theme.LogInPage
import com.example.partyfinder.ui.theme.PartyFinderApp
import com.example.partyfinder.ui.theme.PartyFinderTheme
import com.example.partyfinder.ui.theme.RegisterPage
import com.example.partyfinder.ui.theme.TermsAndConditons

//Merger Comment
@Composable
fun TF(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(808.dp)
            .width(393.dp)
            .background(color = colorResource(id = R.color.black)),
        contentAlignment = Alignment.Center
    ) {
        Crossfade(targetState = PartyUpRouterSam.currentScreen, label = "Navigation") { currentState ->
            when(currentState.value){
                is Screens.HomeScreen -> {
                    PartyFinderApp()
                }
                is Screens.RegisterScreen -> {
                    RegisterPage()
                }
                is Screens.LoginScreen -> {
                    LogInPage()
                }
                is Screens.TermsAndConditionsScreen -> {
                    TermsAndConditons()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTF(){
    PartyFinderTheme {
//        LogInPage()
    }
}

