package com.example.adamacityfc.Presentation.Players

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.adamacityfc.Presentation.Component.PhotoTextCard
import com.example.adamacityfc.R
import com.example.adamacityfc.playersList

@Composable
fun PlayerScreen(navController: NavController){
    Scaffold (
        topBar = { BuyScreenTopAppBar()}
    ){paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(paddingValues),
            userScrollEnabled = true
        ){

            item {
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RectangleShape)
                        .padding(5.dp)
                ){

                    Image(
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds,
                        painter = painterResource(id = R.drawable.allplayers),
                        contentDescription = "all player")

                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            PlayerList(onPlayerClicked = {navController.navigate("player_profile")
            {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true

            }})

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyScreenTopAppBar(){
    CenterAlignedTopAppBar(title = { Text(text = "Players", style = MaterialTheme.typography.headlineMedium) })
}

fun LazyListScope.PlayerList(onPlayerClicked:()->Unit){
    items(playersList){player->
        PhotoTextCard(
            text = player.name,
            onCardClicked = {onPlayerClicked()},
            photo = player.image,
            date = player.role,
            modifier = Modifier
                .clickable {  }
                .size(50.dp)
                .padding(5.dp)
                .border(1.dp,MaterialTheme.colorScheme.background, CircleShape)
                .clip(CircleShape))
    }
}