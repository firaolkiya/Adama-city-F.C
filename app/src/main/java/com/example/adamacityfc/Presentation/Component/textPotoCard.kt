package com.example.adamacityfc.Presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoTextCard(
    text:String,
    text2:String?=null,
    photo: Int,
    date:String,
    modifier:Modifier,
    onCardClicked:()->Unit
){
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 7.dp)
            .border(1.dp, MaterialTheme.colorScheme.background, RectangleShape)
            ,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        onClick = { onCardClicked() }
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = modifier,
                painter = painterResource(id = photo),
                contentScale = ContentScale.FillBounds,
                contentDescription ="left side photo" )
            Spacer(modifier = Modifier.width(5.dp))
            Column (
                verticalArrangement = Arrangement.Center,
            ){
                Text(text = text,
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
                if(text2!=null){
                    Text(text = text2, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal))
                }
                Text(text = "  ${date}", fontWeight = FontWeight.Thin)
            }
            
        }
        
        
    }

}