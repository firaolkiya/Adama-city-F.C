package com.example.adamacityfc.Presentation.Players

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adamacityfc.R

@Composable
fun PlayerProfileScreen(){
    Scaffold (
        topBar = {
            PlayerPrTopApp(title = "Getacho Abebe")
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(paddingValues)
        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.onBackground)
                                .clickable { },
                            painter = painterResource(id = R.drawable.haider),
                            contentDescription = "profile"
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Getecho Kebede",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 19.sp)
                        )
                        Text(
                            text = "Midfielder | 25 years old",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Light)
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
            }
            item {
                var isEnabled by remember {
                    mutableStateOf(true)
                }
                var text by remember {
                    mutableStateOf("Follow")
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    enabled = isEnabled,
                    onClick = {
                        text="Following"
                        isEnabled=false}) {
                    Text(text = text)
                }
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }
        item {
            Text(
                text = "Player Stats",
                style = MaterialTheme.typography.labelMedium
            )
        }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .weight(.5f)
                            .padding(10.dp)
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Goal")
                            Text(text = "5",fontSize = 25.sp)

                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(.5f)
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Assists")
                            Text(text = "20", fontSize = 25.sp)

                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .weight(.5f)
                            .padding(10.dp)
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Minutes")
                            Text(text = "25",fontSize = 25.sp)

                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(.5f)
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Shoot to Target")
                            Text(text = "71", fontSize = 25.sp)

                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }





            item {

                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Passing Accuracy")
                        Text(text = "86.5%", fontSize = 25.sp)
                    }

                }
            }



    }

    }
}

@Composable
@Preview
fun View(){
    PlayerProfileScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerPrTopApp(title:String){

    CenterAlignedTopAppBar(title = { Text(text = title,
        style = MaterialTheme.typography.headlineMedium) },
        navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription ="back to home" )

        }}
    )
}


