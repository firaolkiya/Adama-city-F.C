package com.example.adamacityfc.Presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UpcomingCard(
    club2:String="Adama City F.C",
    type:String,
    club:String,
    date:String,
    image:Int
){
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 7.dp)
            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant, RectangleShape)
            .clickable { }
            ,
        elevation = CardDefaults.cardElevation(
            focusedElevation = 20.dp,
            defaultElevation = 15.dp,
            draggedElevation = 40.dp,
            pressedElevation = 100.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = type)
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "$club2 vs ", style = MaterialTheme.typography.labelMedium)
                    Text(text = club, style = MaterialTheme.typography.labelMedium)
                    Text(text = date, modifier = Modifier.padding(start = 5.dp), fontWeight = FontWeight.Thin)
                }
                Image(
                    modifier = Modifier
                        .size(width = 120.dp, height = 65.dp),
                    painter = painterResource(id = image),
                    contentScale = ContentScale.FillBounds,
                    contentDescription ="right side image" )
            }
        }
        }


}