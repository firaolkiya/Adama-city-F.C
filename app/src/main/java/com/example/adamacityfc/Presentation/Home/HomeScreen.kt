@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.adamacityfc.Presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.adamacityfc.Presentation.Component.ItemCard
import com.example.adamacityfc.Presentation.Component.PhotoTextCard
import com.example.adamacityfc.R
import com.example.adamacityfc.getFiltered
import com.example.adamacityfc.matchList
import com.example.adamacityfc.newsList
import com.example.adamacityfc.playersList
import com.example.adamacityfc.shops

@Composable
fun HomeScreen(navController: NavController){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {

            HomeTopAppBar(scrollBehavior)
        }
    ){paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(),
            flingBehavior = ScrollableDefaults.flingBehavior(),
            contentPadding = paddingValues,
            userScrollEnabled = true
        ){
            item { Spacer(modifier = Modifier.height(5.dp)) }
            item {
                Text(text = "Schedule",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)
                )
            }
            getSchedule()

            item {
                Spacer(modifier = Modifier
                    .height(10.dp))
            }
            item {
                Text(text = "Latest News", style = MaterialTheme.typography.headlineSmall)
            }
            getNews(onNewsClicked = {
                navController.navigate("news_deep") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true

                }
            })

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item { Text(text = "Players",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)) }
            item{
                GetPlayers(onPlayerClicked = {
                    navController.navigate("player_profile") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }




                })
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item { Text(text = "Shop",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp)) }
            item{
                GetShop(onShopClicked = {
                    navController.navigate("buy_deep") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                })
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(scrollBehavior: TopAppBarScrollBehavior){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Adama City F.C",
                style = MaterialTheme.typography.headlineMedium
            )
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onBackground),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.adama),
                contentDescription = "head")
        }
    })
}

fun LazyListScope.getSchedule(){
    items(matchList.getFiltered(false)){match->
        PhotoTextCard(text = "Adama city F.C vs ${match.othersTeamName}",
            photo = R.drawable.upmatches,
            date = match.date,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)) {
            
        }
        
    }
}

fun LazyListScope.getNews(onNewsClicked:()->Unit){
    items(newsList){news->
        PhotoTextCard(text = news.owner,
            text2 = news.newsDescription,
            photo = R.drawable.news,
            date = news.postedDate,
            onCardClicked = onNewsClicked,
            modifier = Modifier
                .size(width = 80.dp, height = 100.dp)
                .padding(5.dp)
                .clip(RectangleShape))
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun GetPlayers(onPlayerClicked:()->Unit){
    LazyRow {
        items(playersList){player->
            ItemCard(itemName = player.name,
                itemDescription = player.role,
                itemPhoto = player.image,
                onItemClicked = onPlayerClicked)
            Spacer(modifier = Modifier.width(7.dp))
        }
    }
}

@Composable
fun GetShop(onShopClicked:()->Unit){
    LazyRow {
        items(shops){ shop->
            ItemCard(itemName =shop.itemName,
                itemDescription = "${shop.itemPrice.toString()} Birr",
                itemPhoto = shop.itemImage,
                onItemClicked = onShopClicked)
            Spacer(modifier = Modifier.width(7.dp))
        }
    }
}

