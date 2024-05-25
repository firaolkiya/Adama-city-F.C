package com.example.adamacityfc.Presentation.Component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultCard(
    club:String,
    club2:String="Adama City F.C",
    date:String,
    adamaScore:Int,
    otherScore:Int,
    type:String
){

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
            .clickable { }
            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant, RectangleShape),
        elevation = CardDefaults.outlinedCardElevation(
            focusedElevation = 30.dp,
            defaultElevation = 40.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
    ){
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = date, style = MaterialTheme.typography.labelSmall)
            Text(text = type, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Thin))
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = club2)
                Box {
                    Text(text = adamaScore.toString(), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                }
                Box {
                    Text(text = otherScore.toString(), fontSize = 25.sp,fontWeight = FontWeight.Bold)
                }
                Text(text = club)
            }



        }
    }

}