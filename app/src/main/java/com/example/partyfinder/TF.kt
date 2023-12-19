package com.example.partyfinder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.partyfinder.ui.theme.PartyFinderTheme


@Composable
fun TF(){
    Surface(color= colorResource(id = R.color.black)){
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState(), true)
            .height(808.dp)
            .width(393.dp)
        ) {
            GamersCallTopBar()
            GamersCallContent()
        }
    }
}


@Composable
fun GamersCallTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(dimensionResource(id = (R.dimen.top_bar_height)))
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.DarkBG)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = (R.drawable.back_blue)),
            contentDescription = "BackIcon",
            modifier = modifier
                .padding(25.dp, 5.dp, 0.dp, 0.dp)
                .size(25.dp)
                .align(Alignment.CenterStart)
        )
        Text(
            text = "Gamers Call",
            style = MaterialTheme.typography.titleMedium,
            color = colorResource(id = R.color.primary)
        )
    }
}

@Composable
fun GamersCallContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        LazyColumn(
            modifier = modifier
                .padding(0.dp, 5.dp)
                .background(
                    color = colorResource(id = R.color.black),
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(dimensionResource(id = R.dimen.main_padding), 0.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(2) {
                G_Calls()
            }
        }

////        To toggle Hide Menu screen
//        if (!isMenuVisible){
//        Surface(color = colorResource(id = R.color.white),
//            modifier = modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .zIndex(1f)
//                    .clickable { isMenuVisible = !isMenuVisible }
//        ) {}
//        }
    }
}


@Composable
fun G_Calls(modifier: Modifier = Modifier) {

//        Variable declaration for menu
    var isMenuVisible by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxWidth()
        .zIndex(1f)
    ){
        Column(
            modifier = modifier
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .background(
                    color = colorResource(id = R.color.DarkBG),
                    shape = RoundedCornerShape(15.dp)
                )
                .height(160.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.CallWidgetBorder),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Row(
                modifier = modifier
                    .background(
                        color = colorResource(id = R.color.DarkBG),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp, 16.dp, 0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pp),
                    contentDescription = "GamerIcon",
                    modifier = modifier
                        .padding(top = 4.dp)
                        .size(76.dp)
                )

                Column {
//                Menu Icon
                    Row(
                        modifier = modifier
                            .padding(top = 6.dp)
                            .background(
                                color = colorResource(id = R.color.DarkBG),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .height(32.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Valorant",
                            style = MaterialTheme.typography.titleSmall,
                            color = colorResource(id = R.color.white),
                            modifier = modifier
                                .padding(top = 12.dp)
                        )

                        if (!isMenuVisible) {
                            Image(
                                painter = painterResource(id = R.drawable.menu_icon_blue),
                                contentDescription = "MenuIcon",
                                modifier = modifier
                                    .size(16.dp)
                                    .clickable { isMenuVisible = !isMenuVisible }
                            )
                        }
                        if (isMenuVisible) {
                            Image(
                                painter = painterResource(id = R.drawable.close_white),
                                contentDescription = "MenuIcon",
                                modifier = modifier
                                    .size(18.dp)
                                    .clickable { isMenuVisible = !isMenuVisible }
                            )
                        }
                    }

//                Name + Other details
                    Row(
                        modifier = modifier
                            .padding(top = 4.dp)
                            .background(
                                color = colorResource(id = R.color.DarkBG),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
//                    horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "#58008",
                            style = MaterialTheme.typography.labelSmall,
                            color = colorResource(id = R.color.SubliminalText),
                            modifier = modifier
                                .padding(start = 4.dp)
                        )

                        Spacer(modifier = modifier.weight(1f))

//                    Icons
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playericon_white),
                                contentDescription = "NoOfPlayersIcon",
                                modifier = modifier
                                    .padding(bottom = 1.dp)
                                    .size(16.dp)
                            )
                            Spacer(modifier = modifier.width(4.dp))
                            Text(
                                text = "5",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorResource(id = R.color.white),
                                modifier = modifier
                                    .padding(bottom = 2.dp)
                            )
                        }

                        Spacer(modifier = modifier.width(16.dp))

                        Image(
                            painter = painterResource(id = R.drawable.dmicon_white),
                            contentDescription = "NoOfPlayersIcon",
                            modifier = modifier
                                .padding(bottom = 1.dp)
                                .size(16.dp)
                        )

                        Spacer(modifier = modifier.width(20.dp))

                    }
                }
            }

            Divider(color = colorResource(id = R.color.CallWidgetBorder), thickness = 1.dp)

//        Description
            Row(
                modifier = modifier
                    .background(
                        color = colorResource(id = R.color.DarkBG),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .height(60.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Need a 4 stack of cracked Valorant gamers for comp grind, And I mean Cracked(CRAZY) ",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.white),
                    modifier = modifier
                        .padding(12.dp, 0.dp)
                )
            }
        }

        
//        Menu
        if (isMenuVisible) {
            Surface(color = colorResource(id = R.color.black),
                modifier = modifier
                    .padding(
                        208.dp,
                        (dimensionResource(id = R.dimen.top_bar_height) - 24.dp),
                        28.dp,
                        0.dp
                    )
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.CallWidgetBorder),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .zIndex(2f)
            ) {
                Column ( modifier = modifier
                    .padding(20.dp, 8.dp, 20.dp, 8.dp)
                ){
                    Row ( verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
//                        .fillMaxWidth()
                            .height(36.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.share_icon_white),
                            contentDescription = "ShareIcon",
                            modifier = modifier
                                .padding(0.dp, 5.dp, 12.dp, 4.dp)
                                .size(18.dp)
                        )
                        Text(
                            text = "Share",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorResource(id = R.color.primary)
                        )
                    }
                    Row ( verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
//                        .fillMaxWidth()
                            .height(36.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.report_blue),
                            contentDescription = "DeleteChats",
                            modifier = modifier
                                .padding(0.dp, 5.dp, 12.dp, 4.dp)
                                .size(20.dp)
                        )
                        Text(
                            text = "Report",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorResource(id = R.color.primary)
                        )
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewTF(){
    PartyFinderTheme {
        TF()
    }
}

