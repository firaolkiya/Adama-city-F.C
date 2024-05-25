package com.example.adamacityfc.Presentation.ContainerScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adamacityfc.Data.Model.BottomBarItem
import com.example.adamacityfc.Presentation.Buy.BuyDeepScreen
import com.example.adamacityfc.Presentation.Buy.BuyScreen
import com.example.adamacityfc.Presentation.Home.HomeScreen
import com.example.adamacityfc.Presentation.Home.NewsDeepScreen
import com.example.adamacityfc.Presentation.Match.MatchScreen
import com.example.adamacityfc.Presentation.Players.PlayerProfileScreen
import com.example.adamacityfc.Presentation.Players.PlayerScreen
import com.example.adamacityfc.R

@Composable
fun MainScreen(){
    val navController: NavController = rememberNavController()
    val bottomBarItems:List<BottomBarItem> = listOf(
        BottomBarItem(
            title = "Home",
            route = "home_screen",
            icon = painterResource(id = R.drawable.home)
        ),
        BottomBarItem(
            title = "Matches",
            route = "match_screen",
            icon = painterResource(id = R.drawable.matches)
        ),
        BottomBarItem(
            title = "Players",
            route = "player_screen",
            icon = painterResource(id = R.drawable.playerss)
        ),
        BottomBarItem(
            title = "Buy",
            route = "buy_screen",
            icon =painterResource(id = R.drawable.shop)
        ),
        BottomBarItem(
            title = "User",
            route = "user_screen",
            icon =painterResource(id = R.drawable.person)
        )
    )
    Scaffold (
        bottomBar = {
            ScreenBottomAppBar(barItem = bottomBarItems,
                navController = navController,
                modifier =Modifier )
        }
    ){paddingValues ->

        NavHost(navController = navController as NavHostController,
            modifier = Modifier.padding(paddingValues),
            startDestination = "home_screen"
        ){

            composable(route = "home_screen"){
                HomeScreen(navController)
            }
            composable(route="match_screen"){
                MatchScreen()
            }
            composable(route="player_screen"){
                PlayerScreen(navController)
            }
            composable(route="buy_screen"){
                BuyScreen(navController)
            }

            composable(route="player_profile"){
                PlayerProfileScreen()
            }
            composable(route="user_screen"){
                PlayerProfileScreen()
            }
            composable(route="buy_deep"){
                BuyDeepScreen()
            }
            composable(route="news_deep"){
                NewsDeepScreen()
            }

        }

    }



}

@Composable
fun ScreenBottomAppBar(
    barItem: List<BottomBarItem>,
    navController: NavController,
    modifier: Modifier)
{

    NavigationBar (
        modifier = modifier,
    ){
        val navbackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navbackEntry?.destination
        barItem.forEach{bar->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any{it.route==bar.route}==true,
                icon = {
                       Icon(painter = bar.icon, contentDescription ="" )
                   },
                onClick = {
                    navController.navigate(bar.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }
                },
                label = { Text(text = bar.title)}
            )
            
        }
    }
}

@Composable
@Preview
fun View(){
    MainScreen()
}