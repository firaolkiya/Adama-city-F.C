package com.example.adamacityfc.Presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
fun ItemCard(
    itemName:String,
    itemDescription:String,
    itemPhoto:Int,
    onItemClicked:()->Unit
){
    Card (
        modifier = Modifier
            .border(1.dp,MaterialTheme.colorScheme.background, RectangleShape)
            .padding(vertical = 4.dp, horizontal = 7.dp)
            .clickable { onItemClicked() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),

    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = itemPhoto),
                contentDescription ="item image",
                contentScale = ContentScale.FillBounds
            )
            Text(text = itemName, 
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
            Text(text = itemDescription, modifier = Modifier.padding(start =5.dp))
        }
    }
}