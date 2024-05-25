package com.example.adamacityfc.Presentation.Match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adamacityfc.Presentation.Component.ResultCard
import com.example.adamacityfc.Presentation.Component.UpcomingCard
import com.example.adamacityfc.R
import com.example.adamacityfc.getFiltered
import com.example.adamacityfc.matchList

@Composable
fun MatchScreen(){
    var isResult by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = { MatchScreenTopAppBar()}
    ) {paddingValues ->

        Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalArrangement = Arrangement.Center
        ){
            TextButton(onClick = { isResult=false }) {
                Text(text = "Upcoming")
            }
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = { isResult=true }) {
                Text(text = "Results")
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
        ) {

            if (!isResult) {
                items(matchList.getFiltered(false)) { item ->
                    UpcomingCard(
                        club = item.othersTeamName,
                        date = item.date,
                        type = item.matchType,
                        image = R.drawable.upcoming
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            } else {
                items(matchList.getFiltered(true)) { item ->
                    ResultCard(
                        club = item.othersTeamName,
                        date = item.date,
                        adamaScore = item.adamaScore,
                        otherScore = item.othersScore,
                        type = item.matchType
                    )
                }
            }

        }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchScreenTopAppBar(){
    CenterAlignedTopAppBar(
        title = { Text(text = "Matches",
        style = MaterialTheme.typography.headlineMedium) }
    )
}