package com.example.adamacityfc.Presentation.Buy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.adamacityfc.Presentation.Component.BuyTicket
import com.example.adamacityfc.getFiltered
import com.example.adamacityfc.matchList
import com.example.adamacityfc.shops

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyScreen(navController: NavController) {
    Scaffold(
        topBar = { BuyScreenTopAppBar() }
    ) { paddingValues ->
        var isTicket by remember {
            mutableStateOf(false)
        }
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { isTicket = false }) {
                    Text(text = "Shop")
                }
                Spacer(modifier = Modifier.width(5.dp))
                TextButton(onClick = { isTicket = true }) {
                    Text(text = "Tickets")
                }
            }

            if (!isTicket) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    columns = GridCells.Fixed(2)
                ) {

                    items(shops) { shop ->
                        OutlinedCard(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            onClick = { navController.navigate("buy_deep") {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true

                            }}) {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Image(
                                    modifier = Modifier.size(150.dp),
                                    painter = painterResource(id = shop.itemImage),
                                    contentScale = ContentScale.FillBounds,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(text = shop.itemName)
                                Text(text = shop.description, fontWeight = FontWeight.Thin)
                                Text(text = shop.itemPrice.toString())
                            }
                        }
                    }

                }
            } else {
                LazyColumn {
                    items(matchList.getFiltered(false)) { match ->
                        BuyTicket(text1 = match.othersTeamName, date = match.date)
                    }
                }

            }
        }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuyScreenTopAppBar() {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Buy",
                style = MaterialTheme.typography.headlineMedium
            )
        })
    }

